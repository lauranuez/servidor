package edu.upc.dsa.Classes;

public class ObjectGame {
    private int id;
    private String name;

    public ObjectGame(String name) {
        this.name = name;
    }
    public ObjectGame() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "User [id= "+id+ " name = " + name + "]";
    }
}
