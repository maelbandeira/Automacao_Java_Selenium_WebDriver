package br.com.core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static br.com.core.DriverFactory.getDriver;

public class JavascriptExecute {

    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    public WebElement jsExecute(By elemento){
        return getDriver().findElement(elemento);
    }

    public void jsExecuteBordaElementoXpath(String xpath){
        WebElement elemento =  getDriver().findElement(By.xpath(xpath));;
        js.executeScript("arguments[0].style.border = arguments[1]", elemento, "solid 4px red");
    }

    public void jsExecuteBordaElemento(String id_campo){
        WebElement elemento =  jsExecute(By.id(id_campo));
        js.executeScript("arguments[0].style.border = arguments[1]", elemento, "solid 4px red");
    }

    public void escreverViaJS(String id_campo, String texto){
        js.executeScript("document.getElementById('"+id_campo+"').value = '" + texto +"'");

    }
}
