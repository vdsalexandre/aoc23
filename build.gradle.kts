import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val assertjVersion: String = "3.24.2"

plugins {
    kotlin("jvm") version "1.8.21"
}

group = "com.vds"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:$assertjVersion")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}