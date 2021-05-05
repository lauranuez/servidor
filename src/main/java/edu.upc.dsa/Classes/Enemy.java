package edu.upc.dsa.Classes;

public class Enemy {
    private String id;
    private String name;
    private int fuerza;
    private int vida;

    public Enemy(){

    }
    public Enemy(String id,String name, int fuerza,int vida){
        this.id = id;
        this.name = name;
        this.fuerza = fuerza;
        this.vida = vida;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String toString() {
        return "Product [id= "+id+", fuerza= " + fuerza + ", vida= " + vida +"]";
    }

}
