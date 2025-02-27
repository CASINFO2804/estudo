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

    // Rest Assured para testes de API
    testImplementation("io.rest-assured:rest-assured:5.3.0")

    // Mockito para mocks
    testImplementation("org.mockito:mockito-core:4.5.1")
    testImplementation("org.mockito:mockito-junit-jupiter:4.5.1") // Para rodar com JUnit 5

    // WireMock para simular APIs
    testImplementation("com.github.tomakehurst:wiremock-jre8:2.35.1")
}

tasks.test {
    useJUnitPlatform()
}
