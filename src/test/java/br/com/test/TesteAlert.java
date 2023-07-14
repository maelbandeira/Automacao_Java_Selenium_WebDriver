package br.com.test;

import br.com.core.BasePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static br.com.core.DriverFactory.*;

public class TesteAlert {

    private WebDriver driver;

    private BasePage basePage;

    @Before
    public void inicializa(){
        getDriver().get("file:///C:/ambiente/workspaces/Automacao_Java_Selenium_WebDriver/src/test/resources/massas/componentes.html");
        basePage = new BasePage();
    }

    @Test
    public void deveInteragirComAlertSimples(){
        basePage.clicarBotao("alert");
        String texto = basePage.alertaObterTextoEAceita();
        Assert.assertEquals("Alert Simples", texto);

        basePage.escrever("elementosForm:nome", texto);
    }

    @Test
    public void deveInteragirComAlertConfirm(){
        basePage.clicarBotao("confirm");
        Assert.assertEquals("Confirm Simples", basePage.alertaObterTextoEAceita());
        Assert.assertEquals("Confirmado", basePage.alertaObterTextoEAceita());

        basePage.clicarBotao("confirm");
        Assert.assertEquals("Confirm Simples", basePage.alertaObterTextoENega());
        Assert.assertEquals("Negado", basePage.alertaObterTextoENega());
    }

    @Test
    public void deveInteragirComAlertPrompt(){
        basePage.clicarBotao("prompt");
        Assert.assertEquals("Digite um numero", basePage.alertaObterTexto());
        basePage.alertaEscrever("18");
        Assert.assertEquals("Era 18?", basePage.alertaObterTextoEAceita());
        Assert.assertEquals(":D", basePage.alertaObterTextoEAceita());
    }

    @After
    public void finaliza(){
//        killDriver();
    }
}
