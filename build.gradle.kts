import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.4.21"
	kotlin("plugin.spring") version "1.4.21"
	id("com.netflix.dgs.codegen") version "4.0.12"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_13

repositories {
	mavenCentral()
	jcenter() //  only needed for the Apollo Federation on the JVM library,
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.postgresql:postgresql")
	implementation ("org.flywaydb:flyway-core:7.5.2")
	implementation("com.netflix.graphql.dgs:graphql-dgs-spring-boot-starter:3.0.10")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

@OptIn(kotlin.ExperimentalStdlibApi::class)
tasks.withType<com.netflix.graphql.dgs.codegen.gradle.GenerateJavaTask> {
	generateClient = true
	packageName = "com.example.kotlinDgsExample.generated"
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

//buildscript {
//	dependencies {
//		classpath "org.jetbrains.kotlin:kotlin-noarg:$kotlin_version"
//	}
//}
//
//apply plugin: "kotlin-jpa"

buildscript {
	dependencies {
		classpath("org.jetbrains.kotlin:kotlin-noarg:1.4.30")
	}
}

apply(plugin = "kotlin-jpa")