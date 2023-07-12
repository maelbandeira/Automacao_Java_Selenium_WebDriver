package br.com.test;

import br.com.page.CampoTreinamentoPO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static br.com.core.DriverFactory.*;
import static br.com.core.DriverFactory.getDriver;

public class TesteCadastro {

    private CampoTreinamentoPO page;

    @Before
    public void inicializa(){
        getDriver().get("file:///C:/ambiente/workspaces/Automacao_Java_Selenium_WebDriver/src/test/resources/massas/componentes.html");
        page = new CampoTreinamentoPO();
    }


    @Test
    public void deveRealizarCadastroComSucesso(){
        page.setNome("Abmael");
        page.setSobrenome("Santana");
        page.setSexoMasculino();
        page.setComidaPizza();
        page.setEscolaridade("Mestrado");
        page.setEsporte("Futebol");
        page.cadastrar();

        Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
        Assert.assertTrue(page.obterNomeCadastro().endsWith("Abmael"));
        Assert.assertEquals("Sobrenome: Santana", page.obterSobrenomeCadastro());
        Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
        Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
        Assert.assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastro());
        Assert.assertEquals("Esportes: Futebol", page.obterEsportesCadastro());
    }


    @After
    public void finaliza(){
        killDriver();
    }

}
