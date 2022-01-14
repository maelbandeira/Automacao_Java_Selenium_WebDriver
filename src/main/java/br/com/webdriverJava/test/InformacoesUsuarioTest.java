package br.com.webdriverJava.test;

// antes = "Assert.assertEquals(1, 1);"  precisava colocar o Assert.
//import org.junit.Assert;

// agora ="assertEquals(1, 1), Usar quando tiver varias classe staticas.
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InformacoesUsuarioTest {
	
	@Test
	public void  testAdicionarInformacaoDoUsuario(){
		// Abrindo o navegador.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABMAEL\\drivers\\chromedriver.exe");
		WebDriver navegador = new ChromeDriver();
		
		//tempo de espera 
		navegador.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		//Navegando para a pagina do http://www.juliodelima.com.br/taskit/!
		navegador.get("http://www.juliodelima.com.br/taskit/");
		
		//Clicar no link que possui o texto "Sign in".
		navegador.findElement(By.linkText("Sign in")).click();
		
		//Identificando o campo "login"
		WebElement formularioLogin = navegador.findElement(By.id("signinbox"));
		
		//Digitar no campo com name "login" que esta dentro do formulario "signbinox" o texto "julio0001"
		formularioLogin.findElement(By.name("login")).sendKeys("julio0001");		
		
		//Digitar no campo com name "Password" que esta dentro do formulario "signbinox" o texto "123456"
		formularioLogin.findElement(By.name("password")).sendKeys("123456");
		
		//Clicar no link com o texto "SIGN IN"
		navegador.findElement(By.linkText("SIGN IN")).click();		
		
		//Validar que dentro do elemento com classe "me" esta o texto "Hi, Julio"
		WebElement me = navegador.findElement(By.className("me"));
		String textoNoElementoMe = me.getText();
		assertEquals("Hi, Julio", textoNoElementoMe);		
		
		//Fechar o navegador
		navegador.quit();
		
		
		//Validação
		
	}

}
