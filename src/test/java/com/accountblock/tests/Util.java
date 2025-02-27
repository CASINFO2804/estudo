package com.accountblock.tests;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class Util {
    public static class TestConfig {
        protected static final String BASE_URL = "http://localhost:8080"; // URL Mock

        protected static WireMockServer wireMockServer;

        @BeforeAll
        static void setup() {
            wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().port(8080));
            wireMockServer.start();
            WireMock.configureFor("localhost", 8080);

            wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/status"))
                    .willReturn(WireMock.aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "application/json")
                            .withBody("{ \"message\": \"API online\" }")));

            System.out.println("=== WireMock iniciado na porta 8080 ===");
        }

        @AfterAll
        static void tearDown() {
            wireMockServer.stop();
            System.out.println("=== WireMock finalizado ===");
        }
    }
}
