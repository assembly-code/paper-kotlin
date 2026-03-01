plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(libs.kotlin.jvm)
    implementation(libs.dokka)
    implementation(libs.shadow)
    implementation(libs.paperWeight)
}
