plugins {
    kotlin("jvm")
}

val kotlinxCoroutinesVersion: String by rootProject

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutinesVersion")

}