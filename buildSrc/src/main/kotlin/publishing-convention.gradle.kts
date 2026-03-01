plugins {
    `maven-publish`
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
