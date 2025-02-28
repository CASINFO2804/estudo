plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // JUnit 5 (usando BOM para gerenciar versões)
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.platform:junit-platform-suite:1.9.2")

    // Rest Assured para testes de API
    testImplementation("io.rest-assured:rest-assured:5.3.0")

    // Cucumber para testes BDD e integração com JUnit 5
    testImplementation("io.cucumber:cucumber-java:7.14.0")
    testImplementation("io.cucumber:cucumber-spring:7.14.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.14.0")

    // Mockito para testes unitários e integração com JUnit 5
    testImplementation("org.mockito:mockito-core:4.11.0")
    testImplementation("org.mockito:mockito-junit-jupiter:4.11.0") // Para rodar com JUnit 5

    // WireMock para simular APIs
    testImplementation("com.github.tomakehurst:wiremock-jre8:2.35.1")
}

// Configurar JUnit 5 como plataforma de testes
tasks.withType<Test> {
    useJUnitPlatform()
}
