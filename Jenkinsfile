@Library('symantec-pipeline')
import com.tesseraga.util.Shell

pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: "5"))
    }
    parameters {
        choice(name: "VERSION_INCREMENT",
                choices: "patch\nminor\nmajor",
                description: "Version to be incremented in artifact")
        string(name: "GIT_URL",
                choices: "patch\nminor\nmajor",
                description: "Version to be incremented in artifact")
    }
    stages {
        stage("Checkout") {
            steps {
                deleteDir()
                checkout([
                        $class: "GitSCM",
                        branches: [[name: "*/master"]],
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [],
                        submoduleCfg: [],
                        userRemoteConfigs: [[
                                credentialsId: "a7fc5bd1-6174-4175-842b-8826f0e16b01",
                                url: "${params.GIT_URL}"]]])
            }
        }
        stage("Version") {
            steps {
                Shell.download("https://raw.githubusercontent.com/fsaintjacques/semver-tool/2.0.0/src/semver")
            }
        }
    }
}