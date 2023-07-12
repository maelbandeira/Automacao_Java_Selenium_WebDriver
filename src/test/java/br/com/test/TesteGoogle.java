package br.com.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static br.com.core.DriverFactory.getDriver;

public class TesteGoogle {


    @Test
    public void teste() {
        getDriver().get("http://www.google.com");
        Assert.assertEquals("Google", getDriver().getTitle());
    }

    @After
    public void finaliza(){
//        killDriver();;
    }
}
