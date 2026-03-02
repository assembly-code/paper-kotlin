import org.jetbrains.dokka.gradle.tasks.DokkaGeneratePublicationTask

plugins {
    org.jetbrains.kotlin.jvm
    org.jetbrains.dokka
    com.gradleup.shadow
}

base {
    archivesName = "${rootProject.name}-${project.name}"
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

tasks.shadowJar {
    archiveClassifier = "shadow"
}
