package br.com.core;

public class Propriedades {

    public static boolean FECHA_BROWSER = true;

    public static Browsers BROWSER = Browsers.CHROME;

    public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.NUVEM;

    public enum Browsers{
        FIREFOX,
        CHROME
    }

    public enum TipoExecucao {
        LOCAL,
        GRID,
        NUVEM
    }
}
