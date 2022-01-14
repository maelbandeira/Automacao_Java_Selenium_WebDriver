package br.com.webdriverJava.test;

// antes = "Assert.assertEquals(1, 1);"  precisava colocar o Assert.
//import org.junit.Assert;

// agora ="assertEquals(1, 1), Usar quando tiver varias classe staticas.
import static org.junit.Assert.*;

import org.junit.Test;

public class InformacoesUsuarioTest {
	
	@Test
	public void  testAdicionarInformacaoDoUsuario(){
		//classe para validação
		assertEquals(1, 1);
		
	}

}
