package edu.upc.dsa;

import edu.upc.dsa.Classes.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class Covid19ManagerTest {

    Covid19Manager cm = Covid19ManagerImp.getInstance();
    private Laboratorio l1;
    private Laboratorio l2;



    @Before
    public void init(){

        UserCovid u1 = new UserCovid("Maria", "Casas", 40, "B",1);
        UserCovid u2 = new UserCovid("Juan", "Mateo", 20, "A",2);
        UserCovid u3 = new UserCovid("Francisco", "Peralta", 80, "D",3);

        cm.addUser(u1);
        cm.addUser(u2);
        cm.addUser(u3);

        l1 = new Laboratorio(1, "Barcelona");
        l2 = new Laboratorio(2, "Gava");

        cm.addLab(l1);
        cm.addLab(l2);

        Muestra m1 = new Muestra("1254d", 123222, "Juan","Barcelona", "2021-02-02");
        Muestra m2 = new Muestra("4445f", 123222, "Francisco","Gava", "2021-03-08");
        Muestra m3 = new Muestra("6754g", 123222, "Maria","Gava", "2021-04-22");

        cm.ExtraerMuestra(m1);
        cm.ExtraerMuestra(m2);
        cm.ExtraerMuestra(m3);

    }

    @After
    public void reset(){
        cm.clear();
    }


    @Test
    public void test1(){
        UserCovid u5 = new UserCovid("Sara", "Pas", 30, "C",8);
        cm.addUser(u5);
        UserCovid u6 = cm.getUser("Sara");
        Assert.assertEquals(u6.getSurname(),"Pas");

    }
    @Test
    public void test2(){
        Muestra m9 = cm.ProcesarMuestra(2);
        Informe i1 = new Informe("positivo", "gran cantidad virica");
        cm.GenerarInforme(m9,i1);
        Muestra m10 = cm.ProcesarMuestra(2);
        Assert.assertEquals(m10.getName(),"Maria");

    }
    @Test
    public void test3(){
        /*
        List<Muestra> lm = cm.MuestrasProcesadasUsuario("Maria");
        Assert.assertEquals(lm.get(0).getSurname(),"Pas");
        */

    }

}
