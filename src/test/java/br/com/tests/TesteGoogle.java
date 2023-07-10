package br.com.tests;

import br.com.dsl.DSL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {

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
    public void teste() {
        driver.get("http://www.google.com");
        Assert.assertEquals("Google", driver.getTitle());
    }

    @After
    public void finaliza(){
//		driver.quit();
    }
}
