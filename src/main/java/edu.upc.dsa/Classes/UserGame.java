package edu.upc.dsa.Classes;

import java.util.ArrayList;
import java.util.List;

public class UserGame {
    int id;
    String name;
    String surname;
    private List<ObjectGame> listObject = new ArrayList<>();

    public UserGame() {
    }

    public UserGame(String name, String surname) {
        this.name=name;
        this.surname=surname;
    }


    public void addObjectToList(ObjectGame o)
    {
        listObject.add(o);
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

    public List<ObjectGame> getListObject() {
        return listObject;
    }

    public void setListObject(List<ObjectGame> listObject) {
        this.listObject = listObject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "User [id= "+id+ " name= "+ name + " surname = " + surname + "]";
    }


}
