package br.com.tests;

import br.com.dsl.DSL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {

    private WebDriver driver;

    private DSL dsl;

    @Before
    public void inicializa(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("file:///C:/ambiente/workspaces/Automacao_Java_Selenium_WebDriver/src/test/resources/massas/componentes.html");
        dsl = new DSL(driver);
    }

    @Test
    public void deveInteragirComAlertSimples(){
        dsl.clicarBotao("alert");
        String texto = dsl.alertaObterTextoEAceita();
        Assert.assertEquals("Alert Simples", texto);

        dsl.escrever("elementosForm:nome", texto);
    }

    @Test
    public void deveInteragirComAlertConfirm(){
        dsl.clicarBotao("confirm");
        Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
        Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceita());

        dsl.clicarBotao("confirm");
        Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
        Assert.assertEquals("Negado", dsl.alertaObterTextoENega());
    }

    @Test
    public void deveInteragirComAlertPrompt(){
        dsl.clicarBotao("prompt");
        Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
        dsl.alertaEscrever("18");
        Assert.assertEquals("Era 18?", dsl.alertaObterTextoEAceita());
        Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());
    }

    @After
    public void finaliza(){
//		driver.quit();
    }
}