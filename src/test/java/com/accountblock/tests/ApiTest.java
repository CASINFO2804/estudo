package com.accountblock.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTest {

    @BeforeAll
    static void setup() {
        // Defina a URL base da sua API
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    void deveRetornar200AoBloquearContaFraudulenta() {
        given()
                .header("Content-Type", "application/json")
                .body("{ \"contaId\": 12345, \"motivo\": \"fraude detectada\" }")
                .when()
                .post("/conta/bloquear")
                .then()
                .statusCode(200)
                .body("mensagem", equalTo("Conta bloqueada com sucesso"));
    }

    @Test
    void deveRetornar404SeContaNaoExiste() {
        given()
                .header("Content-Type", "application/json")
                .body("{ \"contaId\": 99999, \"motivo\": \"fraude detectada\" }")
                .when()
                .post("/conta/bloquear")
                .then()
                .statusCode(404)
                .body("erro", containsString("Conta não encontrada"));
    }
}
