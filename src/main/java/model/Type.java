package model;

public class Type {
    private int id_Type;
    private String name;


    public Type(int id_Type, String name) {
        this.id_Type = id_Type;
        this.name = name;

    }

    public Type() {
    }

    public int getId_Type() {
        return id_Type;
    }

    public void setId_Type(int id_Type) {
        this.id_Type = id_Type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
