package br.com.test;

import br.com.core.BaseTest;
import br.com.core.DSL;
import br.com.page.CampoTreinamentoPO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static br.com.core.DriverFactory.*;


@RunWith(Parameterized.class)
public class TesteRegrasCadastro extends BaseTest {

    private DSL dsl;
    private CampoTreinamentoPO page;

    @Parameterized.Parameter
    public String nome;
    @Parameterized.Parameter(value=1)
    public String sobrenome;
    @Parameterized.Parameter(value=2)
    public String sexo;
    @Parameterized.Parameter(value=3)
    public List<String> comidas;
    @Parameterized.Parameter(value=4)
    public String[] esportes;
    @Parameterized.Parameter(value=5)
    public String msg;


    @Before
    public void inicializa() {
        getDriver().get("file:///C:/ambiente/workspaces/Automacao_Java_Selenium_WebDriver/src/test/resources/massas/componentes.html");
        dsl = new DSL();
        page = new CampoTreinamentoPO();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getCollection(){
        return Arrays.asList(new Object[][] {
                {"", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
                {"Abmael", "", "", Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
                {"Abmael", "Santana", "", Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
                {"Abmael", "Santana", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[]{}, "Tem certeza que voce eh vegetariano?"},
                {"Abmael", "Santana", "Masculino", Arrays.asList("Carne"), new String[]{"Karate", "O que eh esporte?"}, "Voce faz esporte ou nao?"}
        });
    }

    @Test
    public void deveValidarRegras(){
        page.setNome(nome);
        page.setSobrenome(sobrenome);
        if(sexo.equals("Masculino")) {
            page.setSexoMasculino();
        }
        if(sexo.equals("Feminino")) {
            page.setSexoFeminino();
        }
        if(comidas.contains("Carne")) page.setComidaCarne();
        if(comidas.contains("Pizza")) page.setComidaPizza();
        if(comidas.contains("Vegetariano")) page.setComidaVegetariano();
        page.setEsporte(esportes);
        page.cadastrar();
        System.out.println(msg);
        Assert.assertEquals(msg, dsl.alertaObterTextoEAceita());
    }


}
