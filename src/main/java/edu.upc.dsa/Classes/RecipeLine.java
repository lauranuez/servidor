package edu.upc.dsa.Classes;

public class RecipeLine {
    private Ingredient ingredient;
    private int cant;

    public RecipeLine(Ingredient ingredient, int cant) {
        this.ingredient = ingredient;
        this.cant = cant;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
}
