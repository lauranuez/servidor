package edu.upc.dsa.Classes;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String id;
    private String name;
    private String surnames;
    private String pass;
    private int edad;
    private List<Game> listGames;

    public User(){
    }

    public User(String id, String name, String surnames, String pass, int edad) {
        this.id = id;
        this.name = name;
        this.surnames = surnames;
        this.pass = pass;
        this.edad = edad;
        this.listGames = new ArrayList<Game>();
    }

    public void addGame(Game game){
        listGames.add(game);
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

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Game> getListGames() {
        return listGames;
    }

    public void setListGames(List<Game> listGames) {
        this.listGames = listGames;
    }

    public String toString() {
        return "Product [id="+id+", name=" + name+ ", surnames= " + surnames +"edad= "+edad+"]";
    }

}
