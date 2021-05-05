package edu.upc.dsa.Classes;

public class Player extends User {
    private String userId;
    private int fuerza;
    private int vida;

    public Player(){
    }

    public Player(String userId, int fuerza, int vida) {
        this.userId = userId;
        this.fuerza = fuerza;
        this.vida = vida;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        return "Product [id= "+userId+", fuerza= " + fuerza + ", vida= " + vida +"]";
    }

}
