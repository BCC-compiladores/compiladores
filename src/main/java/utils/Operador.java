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
    public static Operador getEnum(String value) {
        for(Operador v : values())
            if(v.get().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
}
