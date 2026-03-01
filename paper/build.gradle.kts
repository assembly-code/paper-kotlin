plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.shadow)
    alias(libs.plugins.dokka)
    alias(libs.plugins.paperWeight)
    `maven-publish`
}

val paperDevBundle = libs.versions.paperDevBundle.get()
val minecraft = paperDevBundle.substringBefore('-')

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    paperweight.paperDevBundle(paperDevBundle)
    api(libs.bundles.kotlin)
}

kotlin {
    jvmToolchain(21)
}

tasks {
    build {
        dependsOn(
            "shadowJar",
            "kotlinSourcesJar",
            "dokkaGenerate",
            "dokkaGenerateHtml",
        )
    }

    jar {
        enabled = false
    }

    shadowJar {
        archiveClassifier = ""
    }

    processResources {
        filteringCharset = "UTF-8"
        val properties = mapOf(
            "description" to project.description,
            "version" to project.version,
            "minecraft" to minecraft,
        )
        inputs.properties(properties)
        filesMatching("paper-plugin.yml") {
            expand(properties)
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = project.group.toString()
            version = project.version.toString()
            artifactId = project.name
        }
    }
}