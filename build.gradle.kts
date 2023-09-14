plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.10"
    application
}

group = "com.usine"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
}

application {
    mainClass.set("com.usine.ApplicationKt")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

kotlin {
    jvmToolchain(19)
}