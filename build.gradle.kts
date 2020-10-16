group = "org.ice1000.texgen"
version = "0.1"

plugins {
  java
  `java-library`
  `maven-publish`
}

repositories {
  mavenCentral()
}

dependencies {
  api("org.jetbrains", "annotations", "20.1.0")
  testImplementation("junit", "junit", "4.12")
}

java {
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
  withSourcesJar()
}

tasks.withType<Wrapper> {
  gradleVersion = "6.5"
}

tasks.withType<JavaCompile> {
  options.encoding = "UTF-8"
}
