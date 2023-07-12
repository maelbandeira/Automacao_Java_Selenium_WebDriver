package br.com.core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static br.com.core.DriverFactory.getDriver;
import static br.com.core.DriverFactory.killDriver;

public class BaseTest {

    @Rule
    public TestName name = new TestName();

    @After
    public void finaliza() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("target" + File.separator + "screenshot"  + File.separator + name.getMethodName() + ".jpg"));

        if (Propriedades.FECHA_BROWSER){
            killDriver();
        }
    }
}
