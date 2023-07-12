package br.com.test;

import br.com.core.BaseTest;
import br.com.core.DSL;
import br.com.core.JavascriptExecute;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static br.com.core.DriverFactory.*;

public class TesteCampoTreinamento extends BaseTest {

    JavascriptExecute js;

    private DSL dsl;

//    @Before
//    public void inicializa(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//
//        driver.manage().window().maximize();
//        driver.get("file:///C:/ambiente/workspaces/Automacao_Java_Selenium_WebDriver/src/test/resources/massas/componentes.html");
//        dsl = new DSL(driver);
//    }
//    @Test
//    public void testeFirefox(){
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.get("file:///C:/ambiente/workspaces/Automacao_Java_Selenium_WebDriver/src/test/resources/massas/componentes.html");
////        dsl = new DSL(driver);
//    }

    @Before
    public void inicializa(){
        getDriver().get("file:///C:/ambiente/workspaces/Automacao_Java_Selenium_WebDriver/src/test/resources/massas/componentes.html");
        dsl = new DSL();
        js = new JavascriptExecute();
    }
    @Test
    public void testeTextField(){
        dsl.escrever("elementosForm:nome", "Teste de escrita");
        Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));
    }

    @Test
    public void testTextFieldDuplo(){
        dsl.escrever("elementosForm:nome", "Abmael");
        Assert.assertEquals("Abmael", dsl.obterValorCampo("elementosForm:nome"));
        dsl.escrever("elementosForm:sobrenome", "Santana");
        Assert.assertEquals("Santana", dsl.obterValorCampo("elementosForm:sobrenome"));
    }

    @Test
    public void deveIntegarirComTextArea(){
        dsl.escrever("elementosForm:sugestoes", "testando\n\nfdfgndlks\n\nUltima linha");
        Assert.assertEquals("testando\n\nfdfgndlks\n\nUltima linha", dsl.obterValorCampo("elementosForm:sugestoes"));
    }

    @Test
    public void deveIntegarirComRadioButton(){
        dsl.clicarRadio("elementosForm:sexo:0");
        Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));
    }

    @Test
    public void deveIntegarirComCheckbox(){
        dsl.clicarCheck("elementosForm:comidaFavorita:2");
        Assert.assertTrue(dsl.isCheckMarcado("elementosForm:comidaFavorita:2"));
    }

    @Test
    public void deveIntegarirComCombo(){
        dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
        Assert.assertEquals("2o grau completo", dsl.obterValorCombo("elementosForm:escolaridade"));
    }

    @Test
    public void deveVerificarValoresCombo(){
        Assert.assertEquals(8, dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
        Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Mestrado"));
    }

    @Test
    public void deveVerificarValoresComboMultiplo(){
        dsl.selecionarCombo("elementosForm:esportes", "Natacao");
        dsl.selecionarCombo("elementosForm:esportes", "Corrida");
        dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");

        List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
        Assert.assertEquals(3, opcoesMarcadas.size());

        dsl.deselecionarCombo("elementosForm:esportes", "Corrida");
        opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
        Assert.assertEquals(2, opcoesMarcadas.size());
        Assert.assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Natacao", "O que eh esporte?")));
    }

    @Test
    public void deveInteragirComBotoes(){
        dsl.clicarBotao("buttonSimple");

        Assert.assertEquals("Obrigado!", dsl.obterValueElemento("buttonSimple"));
    }

    @Test
    public void deveInteragirComLinks(){
        dsl.clicarLink("Voltar");

        Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
    }

    @Test
    public void deveBuscarTextosNaPagina(){
//		Assert.assertTrue(driver.findElement(By.tagName("body"))
//				.getText().contains("Campo de Treinamento"));
        js.jsExecuteBordaElementoXpath("//h3[contains(.,'Campo de Treinamento')]");
        Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));

        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
                dsl.obterTexto(By.className("facilAchar")));
    }

    @Test
    public void testJavascript(){
//		js.executeScript("alert('Testando js via selenium')");

//        js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
//        js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");
        js.escreverViaJS("elementosForm:nome", "Abmael");
        js.jsExecuteBordaElemento("elementosForm:nome");

    }

//    @After
//    public void finaliza(){
////        killDriver();
//    }
}
