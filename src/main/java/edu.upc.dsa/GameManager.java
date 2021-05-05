package edu.upc.dsa;

import edu.upc.dsa.Classes.ObjectGame;
import edu.upc.dsa.Classes.UserGame;

import java.util.List;

public interface GameManager {
    public List<UserGame> getUsersByName(); //Listado de usuarios ordenados alfabeticamente
    public void addUser(UserGame user);
    public UserGame changeUser(String name, String surname, int i); //
    public int numUsers();
    public UserGame returnInfoUser(String name); //
    public void addObject(ObjectGame object, String name);
    public List<ObjectGame> getObjects(String name); //En orden de inserccion
    public int numObjects(String name);
    public void clear();
    public void dirty();
    public boolean isDirty();
}
