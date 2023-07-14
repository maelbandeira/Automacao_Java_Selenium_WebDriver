package br.com.page;

import br.com.core.BasePage;

public class CampoTreinamentoPO extends BasePage {


    public void setNome(String nome) {
        escrever("elementosForm:nome", nome);
    }

    public void setSobrenome(String sobrenome) {
        escrever("elementosForm:sobrenome", sobrenome);
    }

    public void setSexoMasculino(){
        clicarRadio("elementosForm:sexo:0");
    }

    public void setSexoFeminino(){
        clicarRadio("elementosForm:sexo:1");
    }

    public void setComidaCarne(){
        clicarRadio("elementosForm:comidaFavorita:0");
    }

    public void setComidaPizza(){
        clicarRadio("elementosForm:comidaFavorita:2");
    }

    public void setComidaVegetariano(){
        clicarRadio("elementosForm:comidaFavorita:3");
    }

    public void setEscolaridade(String valor) {
        selecionarCombo("elementosForm:escolaridade", valor);
    }

    public void setEsporte(String... valores) {
        for(String valor: valores)
            selecionarCombo("elementosForm:esportes", valor);
    }

    public void cadastrar(){
        clicarBotao("elementosForm:cadastrar");
    }

    public String obterResultadoCadastro(){
        return obterTexto("resultado");
    }

    public String obterNomeCadastro(){
        return obterTexto("descNome");
    }

    public String obterSobrenomeCadastro(){
        return obterTexto("descSobrenome");
    }

    public String obterSexoCadastro(){
        return obterTexto("descSexo");
    }

    public String obterComidaCadastro(){
        return obterTexto("descComida");
    }

    public String obterEscolaridadeCadastro(){
        return obterTexto("descEscolaridade");
    }

    public String obterEsportesCadastro(){
        return obterTexto("descEsportes");
    }

}
