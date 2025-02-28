package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.*;

public class ExemploSteps {

    private boolean testeRodou = false;

    @Given("que o sistema está inicializado")
    public void sistemaInicializado() {
        System.out.println("Sistema inicializado!");
    }

    @When("eu executo um teste básico")
    public void executoTesteBasico() {
        testeRodou = true;
    }

    @Then("o resultado deve ser sucesso")
    public void resultadoDeveSerSucesso() {
        assertTrue(testeRodou, "O teste não rodou corretamente!");
    }
}
