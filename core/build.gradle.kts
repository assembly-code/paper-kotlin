plugins {
    `kotlin-convention`
    `publishing-convention`
    `paper-convention`
}

dependencies {
    implementation(libs.bundles.kotlin)
}

tasks.shadowJar {
    minimizeJar = true
}
