package br.com.test;

import br.com.core.BasePage;
import br.com.core.BaseTest;
import br.com.core.JavascriptExecute;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static br.com.core.DriverFactory.*;

public class TesteCampoTreinamento extends BaseTest {

    JavascriptExecute js;

    private BasePage basePage;

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
        basePage = new BasePage();
        js = new JavascriptExecute();
    }
    @Test
    public void testeTextField(){
        basePage.escrever("elementosForm:nome", "Teste de escrita");
        Assert.assertEquals("Teste de escrita", basePage.obterValorCampo("elementosForm:nome"));
    }

    @Test
    public void testTextFieldDuplo(){
        basePage.escrever("elementosForm:nome", "Abmael");
        Assert.assertEquals("Abmael", basePage.obterValorCampo("elementosForm:nome"));
        basePage.escrever("elementosForm:sobrenome", "Santana");
        Assert.assertEquals("Santana", basePage.obterValorCampo("elementosForm:sobrenome"));
    }

    @Test
    public void deveIntegarirComTextArea(){
        basePage.escrever("elementosForm:sugestoes", "testando\n\nfdfgndlks\n\nUltima linha");
        Assert.assertEquals("testando\n\nfdfgndlks\n\nUltima linha", basePage.obterValorCampo("elementosForm:sugestoes"));
    }

    @Test
    public void deveIntegarirComRadioButton(){
        basePage.clicarRadio("elementosForm:sexo:0");
        Assert.assertTrue(basePage.isRadioMarcado("elementosForm:sexo:0"));
    }

    @Test
    public void deveIntegarirComCheckbox(){
        basePage.clicarCheck("elementosForm:comidaFavorita:2");
        Assert.assertTrue(basePage.isCheckMarcado("elementosForm:comidaFavorita:2"));
    }

    @Test
    public void deveIntegarirComCombo(){
        basePage.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
        Assert.assertEquals("2o grau completo", basePage.obterValorCombo("elementosForm:escolaridade"));
    }

    @Test
    public void deveVerificarValoresCombo(){
        Assert.assertEquals(8, basePage.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
        Assert.assertTrue(basePage.verificarOpcaoCombo("elementosForm:escolaridade", "Mestrado"));
    }

    @Test
    public void deveVerificarValoresComboMultiplo(){
        basePage.selecionarCombo("elementosForm:esportes", "Natacao");
        basePage.selecionarCombo("elementosForm:esportes", "Corrida");
        basePage.selecionarCombo("elementosForm:esportes", "O que eh esporte?");

        List<String> opcoesMarcadas = basePage.obterValoresCombo("elementosForm:esportes");
        Assert.assertEquals(3, opcoesMarcadas.size());

        basePage.deselecionarCombo("elementosForm:esportes", "Corrida");
        opcoesMarcadas = basePage.obterValoresCombo("elementosForm:esportes");
        Assert.assertEquals(2, opcoesMarcadas.size());
        Assert.assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Natacao", "O que eh esporte?")));
    }

    @Test
    public void deveInteragirComBotoes(){
        basePage.clicarBotao("buttonSimple");

        Assert.assertEquals("Obrigado!", basePage.obterValueElemento("buttonSimple"));
    }

    @Test
    public void deveInteragirComLinks(){
        basePage.clicarLink("Voltar");

        Assert.assertEquals("Voltou!", basePage.obterTexto("resultado"));
    }

    @Test
    public void deveBuscarTextosNaPagina(){
//		Assert.assertTrue(driver.findElement(By.tagName("body"))
//				.getText().contains("Campo de Treinamento"));
        js.jsExecuteBordaElementoXpath("//h3[contains(.,'Campo de Treinamento')]");
        Assert.assertEquals("Campo de Treinamento", basePage.obterTexto(By.tagName("h3")));

        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
                basePage.obterTexto(By.className("facilAchar")));
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
