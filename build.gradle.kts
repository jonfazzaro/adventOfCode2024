plugins {
    kotlin("jvm") version "2.0.21"
}

group = "com.fazzaro.advent"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(23) // Ensure Kotlin targets JVM 23
}


dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.26.3")
}

tasks.test {
    useJUnitPlatform()
}