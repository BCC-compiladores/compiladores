package utils;

public class Constante {

    Tipo tipo;

    String id;

    int address;

    String value;

    public Constante(Tipo tipo, String id, int address, String value) {
        setTipo(tipo);
        setId(id);
        setAddress(address);
        setValue(value);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
