plugins {
  id("java")

  application
}

group = "benedict.zhang"

version = "1.0-SNAPSHOT"

repositories { mavenCentral() }

dependencies {
  compileOnly("org.projectlombok:lombok:1.18.24")
  implementation("com.squareup.okhttp3:okhttp:4.10.0")
  annotationProcessor("org.projectlombok:lombok:1.18.24")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

application { mainClass.set("benedict.zhang.Main") }

tasks.getByName<Test>("test") { useJUnitPlatform() }
