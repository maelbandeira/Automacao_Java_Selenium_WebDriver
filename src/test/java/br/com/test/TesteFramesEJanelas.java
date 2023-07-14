package br.com.test;

import br.com.core.BasePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static br.com.core.DriverFactory.*;

public class TesteFramesEJanelas {

    private BasePage basePage;

    @Before
    public void inicializa(){
        getDriver().get("file:///C:/ambiente/workspaces/Automacao_Java_Selenium_WebDriver/src/test/resources/massas/componentes.html");
        basePage = new BasePage();
    }

    @Test
    public void deveInteragirComFrames(){
        basePage.entrarFrame("frame1");
        basePage.clicarBotao("frameButton");
        String msg = basePage.alertaObterTextoEAceita();
        Assert.assertEquals("Frame OK!", msg);

        basePage.sairFrame();
        basePage.escrever("elementosForm:nome", msg);
    }

    @Test
    public void deveInteragirComJanelas(){
        basePage.clicarBotao("buttonPopUpEasy");
        basePage.trocarJanela("Popup");
        basePage.escrever(By.tagName("textarea"), "Deu certo?");
        getDriver().close();
        basePage.trocarJanela("");
        basePage.escrever(By.tagName("textarea"), "e agora?");
    }

    @Test
    public void deveInteragirComJanelasSemTitulo(){
        basePage.clicarBotao("buttonPopUpHard");
        System.out.println(getDriver().getWindowHandle());
        System.out.println(getDriver().getWindowHandles());
        basePage.trocarJanela((String) getDriver().getWindowHandles().toArray()[1]);
        basePage.escrever(By.tagName("textarea"), "Deu certo?");
        basePage.trocarJanela((String) getDriver().getWindowHandles().toArray()[0]);
        basePage.escrever(By.tagName("textarea"), "e agora?");
    }


    @After
    public void finaliza(){
//        killDriver();
    }
}
