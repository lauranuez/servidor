package edu.upc.dsa;
import edu.upc.dsa.Classes.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GameManagerTest {
    GameManager gm = GameManagerImpl.getInstance();
    private UserGame u1;
    private UserGame u2;
    private UserGame u3;
    private UserGame u4;


    @Before
    public void init(){

        ObjectGame o1 = new ObjectGame("espada");
        ObjectGame o2 = new ObjectGame("escudo");
        ObjectGame o3 = new ObjectGame("pistola");

        u1 = new UserGame("Sara", "Rosello");
        u2 = new UserGame("Juan","Formento");
        u3 = new UserGame("Alba","Garcia");
        u4 = new UserGame("Fer","Casas");

        gm.addUser(u1);
        gm.addUser(u2);
        gm.addUser(u3);
        gm.addUser(u4);

        gm.addObject(o1,"Alba");
        gm.addObject(o3,"Alba");
        gm.addObject(o2,"Alba");

    }

    @After
    public void reset(){
        gm.clear();
    }


    @Test
    public void test1(){
        List<UserGame> listUsers = gm.getUsersByName();
        Assert.assertEquals(listUsers.get(0).getName(),"Alba");
    }
    @Test
    public void test2(){
        UserGame u5 = gm.changeUser("Fer", "Fraile", 52);
        Assert.assertEquals(u5.getId(),52);
        Assert.assertEquals(u5.getSurname(),"Fraile");
    }
    @Test
    public void test3() {
        int i = gm.numUsers();
        Assert.assertEquals(i,4);
    }
    @Test
    public void test4() {
        UserGame u5 = gm.returnInfoUser("Fer");
        Assert.assertEquals(u5.getId(),3);
    }
    @Test
    public void test5() {
        List<ObjectGame> listObject= gm.getObjects("Alba");
        Assert.assertEquals(listObject.get(1).getName(),"pistola");
    }
    @Test
    public void test6() {
        Assert.assertEquals(gm.numObjects("Alba"),3);
    }


}
