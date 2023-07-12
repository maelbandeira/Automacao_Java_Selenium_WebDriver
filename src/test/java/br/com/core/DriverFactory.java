package br.com.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static WebDriver driver;

    public DriverFactory() {

    }

    public static WebDriver getDriver() {
        if(driver == null){
            switch (Propriedades.browser){
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void killDriver(){
        driver.quit();
        driver = null;
    }
}
