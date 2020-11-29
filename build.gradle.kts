import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.1.BUILD-SNAPSHOT"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	val kotlinVersion = "1.4.10"
	kotlin("jvm") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion
	kotlin("plugin.jpa") version kotlinVersion
}

group = "pl.piotr"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	val springBootStarter = "2.3.1.BUILD-SNAPSHOT"
	implementation("org.springframework.boot:spring-boot-starter:$springBootStarter")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springBootStarter")
	implementation("org.springframework.boot:spring-boot-starter-web:$springBootStarter")

  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
  }

  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.3")
  implementation("org.postgresql:postgresql:42.2.18")
  implementation("com.google.firebase:firebase-admin:7.0.1")
  implementation("io.springfox:springfox-boot-starter:3.0.0")
  implementation("io.springfox:springfox-swagger-ui:3.0.0")
  implementation("com.squareup.okhttp3:okhttp:4.10.0-RC1")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
