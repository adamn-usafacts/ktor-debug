plugins {
    kotlin("jvm")
}

val kotlinxCoroutinesVersion: String by rootProject

dependencies {
    implementation(project(":domain"))

    implementation(kotlin("stdlib-jdk8"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$kotlinxCoroutinesVersion")
}
