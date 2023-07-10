package br.com.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static WebDriver driver;

    public DriverFactory() {

    }

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        if(driver == null){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void killDriver(){
        driver.quit();
        driver = null;
    }
}
