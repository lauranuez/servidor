package edu.upc.dsa.Classes;

public class Ingredient {
    private String id;

    public Ingredient(){

    }

    public Ingredient(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
        return "Product [id="+id+"]";
    }

}
