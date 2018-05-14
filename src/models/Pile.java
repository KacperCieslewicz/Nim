package models;

public class Pile{
    private char name;
    private Integer value;

    public Pile(char name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
