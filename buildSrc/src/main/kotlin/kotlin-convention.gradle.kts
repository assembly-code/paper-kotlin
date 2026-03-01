plugins {
    org.jetbrains.kotlin.jvm
    org.jetbrains.dokka
    com.gradleup.shadow
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}

tasks.build {
    dependsOn(
        "shadowJar",
        "kotlinSourcesJar",
        "dokkaGenerate",
        "dokkaGenerateHtml",
    )
}

tasks.jar {
    enabled = false
}

tasks.shadowJar {
    archiveClassifier = ""
}