import xyz.jpenilla.resourcefactory.bukkit.BukkitPluginYaml
import xyz.jpenilla.resourcefactory.paper.paperPluginYaml

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.shadow)
    alias(libs.plugins.dokka)
    alias(libs.plugins.resourceFactory)
    alias(libs.plugins.runPaper)
    `maven-publish`
}

group = "net.assembly.paperkotlin"
description = ""
version = "1.0.0"

val minecraft = libs.versions.minecraft.get()

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:$minecraft-R0.1-SNAPSHOT")
    api(libs.bundles.kotlin)
    api(libs.bundles.kotlinx)
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
    archiveClassifier = null
}

val factory = paperPluginYaml {
    name = project.name
    description = project.description
    version = project.version.toString()
    author = "alexthegoood"

    load = BukkitPluginYaml.PluginLoadOrder.STARTUP
    main = "${project.group}.PaperKotlin"
    apiVersion = minecraft
    foliaSupported = true
}.resourceFactory()

sourceSets.main {
    resourceFactory.factory(factory)
}
