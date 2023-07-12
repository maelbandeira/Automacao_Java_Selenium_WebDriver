package br.com.suite;

import br.com.test.TesteCadastro;
import br.com.test.TesteCampoTreinamento;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static br.com.core.DriverFactory.killDriver;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        TesteCadastro.class,
        TesteCampoTreinamento.class
})
public class SuiteTeste {

    @AfterClass
    public static void fecharTudo(){
        killDriver();
    }
}
