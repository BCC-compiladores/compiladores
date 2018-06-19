package utils;

public enum Operador {

    MAIS("+"),
    MENOS("-"),
    MULTIPLICACAO("*"),
    DIVISAO("/"),
    IGUAL("="),
    DIFERENTE("!="),
    MENOR("<"),
    MAIOR(">"),
    MAIOR_IGUAL(">="),
    MENOR_IGUAL("<="),
    NEGACAO("!"),
    E("&&"),
    OU("||");

    private final String msg;

    Operador(String msg){
        this.msg = msg;
    }

    public String get() {
        return msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
