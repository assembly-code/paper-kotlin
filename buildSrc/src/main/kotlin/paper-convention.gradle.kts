plugins {
    io.papermc.paperweight.userdev
}

val paperDevBundle = "1.21.11-R0.1-SNAPSHOT"
val minecraft = paperDevBundle.substringBefore('-')

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    paperweight.paperDevBundle(paperDevBundle)
}

tasks.processResources {
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

