package com.tesseraga.util;

static String run(String script, Boolean returnStdout=false) {
    if (params.DEBUG)
        println("Shell Script: ${script}")

    String stdout = sh(script: script, returnStdout: true)

    if (params.DEBUG)
        println("Shell Script STD out: ${script}")

    if (returnStdout)
        return stdout.trim()
    else
        return null
}

static String httpGet(String url) {
    return Shell.run(script: "curl ${url}", returnStdout: true)
}

static void download(String url) {
    run(script: "wget ${url}")
}

static String latestCommitWithTag() {
    return run(script: "git rev-list --tags --max-count=1", returnStdout: true)
}

static String latestTag() {
    String commit = latestCommitWithTag()
    return run(script: "git describe ${commit} --tags", returnStdout: true)
}