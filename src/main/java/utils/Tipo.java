package utils;

public enum Tipo {

    int64("int64"),
    float64("float64"),
    string("string"),
    bool("bool"),
    doublee("double");

    private String msg;

    Tipo(String msg){
        this.msg = msg;
    }

    Tipo(){}

    public String get() {
        return msg;
    }

    @Override
    public String toString() {
        return msg;
    }
    public static Tipo getEnum(String value) {
        for(Tipo v : values())
            if(v.get().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }

}
