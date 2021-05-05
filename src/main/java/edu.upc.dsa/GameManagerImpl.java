package edu.upc.dsa;

import edu.upc.dsa.Classes.ObjectGame;
import edu.upc.dsa.Classes.User;
import edu.upc.dsa.Classes.UserGame;
import org.apache.log4j.Logger;

import java.util.*;

public class GameManagerImpl implements GameManager {
    private static GameManager instance;

    private HashMap<String,UserGame> hmUsers;
    private List<UserGame> listUsers;
    private int contUsers = 0;
    private int contObj = 0;
    private boolean dirty = false;
    final static Logger logger = Logger.getLogger(GameManagerImpl.class);

    private GameManagerImpl(){
        hmUsers = new HashMap<String,UserGame>();
        listUsers = new ArrayList<>();
    }
    public static GameManager getInstance() {
        if (instance==null)
        {
            instance = new GameManagerImpl();
        }
        return instance;
    }
    public void clear(){
        listUsers.clear();
        hmUsers.clear();
        contObj=0;
        contUsers=0;
    }

    @Override
    public void dirty() {
        this.dirty = true;
    }

    @Override
    public boolean isDirty() {
        return dirty;
    }

    @Override
    public List<UserGame> getUsersByName() {
        logger.info("getUsersByName()");
        Collections.sort(listUsers, new Comparator<UserGame>() {
            @Override
            public int compare(UserGame u1, UserGame u2) {
                return u1.getName().compareTo(u2.getName());
            }
        });
        logger.info("the first product is: " + listUsers.get(0).getName());
        return listUsers;
    }

    @Override
    public void addUser(UserGame user) {
        logger.info("new user " + user.getName());
        user.setId(contUsers);
        contUsers++;
        hmUsers.put(user.getName(), user);
        listUsers.add(user);
        logger.info("new user added");
    }

    @Override
    public UserGame changeUser(String name, String surname, int i) {
        logger.info("ChangeUser");
        UserGame u = hmUsers.get(name);
        u.setId(i);
        u.setSurname(surname);
        logger.info("The id is" + u.getId());
        return u;
   }

    @Override
    public int numUsers() {
        logger.info("numUsers()");
        logger.info("numUsers = " + hmUsers.size());
        return hmUsers.size();
    }

    @Override
    public UserGame returnInfoUser(String name) {
        logger.info("returnInfoUser()");
        logger.info("name = " + hmUsers.get(name).getName() + "surname = " + hmUsers.get(name).getSurname() + "id = " + hmUsers.get(name).getId() );
        return hmUsers.get(name);
    }

    @Override
    public void addObject(ObjectGame object,String name) {
        logger.info("add the object "+ object +" to " + name );
        ObjectGame o = object;
        o.setId(contObj);
        contObj++;
        hmUsers.get(name).addObjectToList(o);
        logger.info("Object added");
    }

    @Override
    public List<ObjectGame> getObjects(String name) {
        logger.info("getObjects(" + name +")");
        logger.info("the first object of the list is: " + hmUsers.get(name).getListObject().get(0).getName());
        return hmUsers.get(name).getListObject();
    }

    @Override
    public int numObjects(String name) {
        logger.info("numObjects()");
        logger.info("numUsers = " + hmUsers.get(name).getListObject().size());
        return hmUsers.get(name).getListObject().size();
    }
}
