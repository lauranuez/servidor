package edu.upc.dsa.Classes;

import java.util.ArrayList;
import java.util.List;

public class UserCovid {
    private int id;
    private String name;
    private String surname;
    private int edad;
    private String health; //A enfermedad menos avanzada y D mas avanzada
    private List<Muestra> listMuestras = new ArrayList<>();

    public UserCovid(String name, String surname, int edad, String health, int id) {
        this.name = name;
        this.surname = surname;
        this.edad = edad;
        this.health = health;
        this.id = id;
    }

    public UserCovid(){

    }

    public List<Muestra> getListMuestras() {
        return listMuestras;
    }

    public void AddListMuestras(Muestra m) {
        listMuestras.add(m);
    }

    public void setListMuestras(List<Muestra> listMuestras) {
        this.listMuestras = listMuestras;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String toString() {
        return "User [id= "+id+ " name = " + name + " surname = " + surname + " edad= " + edad +" Health = " + health + "]";
    }


}
