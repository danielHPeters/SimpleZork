version = "1.0"
group = "ch.peters.daniel"


plugins {
  java
  kotlin("jvm") version "1.3.20"
  application
  groovy
}

application {
  applicationName = "zork"
  mainClassName = "${project.group}.$applicationName.App"
}

dependencies {
  implementation(kotlin("stdlib"))
  testImplementation("org.codehaus.groovy:groovy-all:2.5.5")
  testImplementation("org.spockframework:spock-core:1.2-groovy-2.5")
  testImplementation("junit:junit:4.12")
}

repositories {
  jcenter()
}

configure<JavaPluginConvention> {
  sourceCompatibility = JavaVersion.VERSION_1_10
  targetCompatibility = JavaVersion.VERSION_1_10
}

tasks.withType(JavaExec::class.java) {
  standardInput = System.`in`
}
