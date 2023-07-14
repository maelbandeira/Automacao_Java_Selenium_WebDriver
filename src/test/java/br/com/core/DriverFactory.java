package br.com.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static br.com.core.Propriedades.*;
import static br.com.core.Propriedades.Browsers.CHROME;
import static br.com.core.Propriedades.Browsers.FIREFOX;

public class DriverFactory {

    private static WebDriver driver;

    public DriverFactory() {

    }

//    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
//        @Override
//        protected synchronized WebDriver initialValue(){
//            return initDriver();
//        }
//    };

//    public static WebDriver getDriver(){
//        return threadDriver.get();
//    }

//    public static WebDriver initDriver() throws MalformedURLException {
//        WebDriver driver = null;
//        if(TIPO_EXECUCAO == TipoExecucao.LOCAL) {
//            switch (BROWSER) {
//                case FIREFOX: driver = new FirefoxDriver(); break;
//                case CHROME: driver = new ChromeDriver(); break;
//            }
//        }
//        if(TIPO_EXECUCAO == TipoExecucao.GRID) {
//            DesiredCapabilities cap = null;
//            switch (Propriedades.BROWSER) {
//                case FIREFOX: cap = DesiredCapabilities.firefox(); break;
//                case CHROME: cap = DesiredCapabilities.chrome(); break;
//            }
//            try {
//                driver = new RemoteWebDriver(new URL("SUA URL"), cap);
//            } catch (MalformedURLException e) {
//                System.err.println("Falha na conexão com o GRID");
//                e.printStackTrace();
//            }
//        }
//        if(TIPO_EXECUCAO == TipoExecucao.NUVEM) {
//            DesiredCapabilities cap = new DesiredCapabilities();
//            switch (BROWSER) {
//                case FIREFOX:
//                    cap.setCapability("browser", Browsers.CHROME);
//                    break;
//                case CHROME:
//                    cap = DesiredCapabilities.chrome();
//                    break;
////                case IE: cap = DesiredCapabilities.internetExplorer();
////                    cap.setCapability("platform", "Windows 7");
////                    cap.setCapability("version", "11.0");
////                    break;
//            }
//            try {
//                driver = new RemoteWebDriver(new URL("cloudUrl"), cap);
//            } catch (MalformedURLException e) {
//                System.err.println("Falha na conexão com a Saucelabs");
//                e.printStackTrace();
//            }
//        }
//        return driver;
//    }



/***************************** Sem usar o paralelo **************************/
    public static WebDriver getDriver() {
        if(driver == null){
            switch (BROWSER){
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

//    public static void killDriver(){
//        WebDriver driver = getDriver();
//        if(driver != null) {
//            driver.quit();
//        }
//        if(threadDriver != null) {
//            threadDriver.remove();
//        }
//    }

}
