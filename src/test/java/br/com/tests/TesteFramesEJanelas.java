package br.com.tests;

import br.com.dsl.DSL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFramesEJanelas {

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
    public void deveInteragirComFrames(){
        dsl.entrarFrame("frame1");
        dsl.clicarBotao("frameButton");
        String msg = dsl.alertaObterTextoEAceita();
        Assert.assertEquals("Frame OK!", msg);

        dsl.sairFrame();
        dsl.escrever("elementosForm:nome", msg);
    }

    @Test
    public void deveInteragirComJanelas(){
        dsl.clicarBotao("buttonPopUpEasy");
        dsl.trocarJanela("Popup");
        dsl.escrever(By.tagName("textarea"), "Deu certo?");
        driver.close();
        dsl.trocarJanela("");
        dsl.escrever(By.tagName("textarea"), "e agora?");
    }

    @Test
    public void deveInteragirComJanelasSemTitulo(){
        dsl.clicarBotao("buttonPopUpHard");
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());
        dsl.trocarJanela((String) driver.getWindowHandles().toArray()[1]);
        dsl.escrever(By.tagName("textarea"), "Deu certo?");
        dsl.trocarJanela((String) driver.getWindowHandles().toArray()[0]);
        dsl.escrever(By.tagName("textarea"), "e agora?");
    }


    @After
    public void finaliza(){
//		driver.quit();
    }
}
