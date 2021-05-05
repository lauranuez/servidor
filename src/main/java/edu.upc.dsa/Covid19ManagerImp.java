package edu.upc.dsa;

import edu.upc.dsa.Classes.*;
import org.apache.log4j.Logger;

import java.util.*;

public class Covid19ManagerImp implements Covid19Manager{

    private HashMap<String, UserCovid> hmUsers;
    private List<Laboratorio> listLabs;
    final static Logger logger = Logger.getLogger(Covid19ManagerImp.class);

    private boolean dirty=false;

    private static Covid19Manager instance;

    public static Covid19Manager getInstance() {
        if (instance==null)
        {
            instance = new Covid19ManagerImp();
        }

        return instance;
    }


    public Covid19ManagerImp() {
        this.hmUsers = new HashMap<String,UserCovid>();
        listLabs = new ArrayList<>();
    }


    @Override
    public void addUser(UserCovid user) {
        logger.info("new user " + user.getName());
        hmUsers.put(user.getName(),user);
        logger.info("new user added");

    }

    @Override
    public void ExtraerMuestra(Muestra muestra) {
        logger.info("nueva muestra " + muestra.getId());
        for(int i=0; i<listLabs.size(); i++)
        {
            if(listLabs.get(i).getName() == muestra.getIdLab())
            {
                listLabs.get(i).addQueueMuestra(muestra);
                logger.info("muestra añadida al laboratorio" + muestra.getIdLab());
            }
        }
    }

    @Override
    public Muestra ProcesarMuestra(int idLab) {
        Laboratorio lab = new Laboratorio();
        logger.info("Procesar muestra del laboratorio " + idLab);
        for (int i = 0; i<listLabs.size(); i++)
        {
            if (idLab == listLabs.get(i).getId()) {
                lab = listLabs.get(i);

            }
        }
        Muestra m = lab.ProcesarMuestra();
        logger.info("muestra procesada");
        hmUsers.get(m.getName()).AddListMuestras(m);
        logger.info("muestra añadida al usuario" + m.getName());

        return m;
    }

    public void GenerarInforme(Muestra m, Informe i)
    {
        logger.info("informe generado de la muestra" + m.getId());
        m.setInf(i);
    }

    @Override
    public List<Muestra> MuestrasProcesadasUsuario(String name) {
        List<Muestra> listUser = new ArrayList<>();
        logger.info("Muestras procesadas del usuario " + name);
        if(hmUsers.get(name).getListMuestras().size() == 0)
            logger.warn("no hay muestra procesadas de ese usuaario");
        else
        {
            listUser = hmUsers.get(name).getListMuestras();
            logger.info("la  primera muestra procesada es " + listUser.get(0).getId());
        }

        return listUser;
    }

    @Override
    public void addLab(Laboratorio lab) {
        logger.info("new lab " + lab.getName());
        listLabs.add(lab);
        logger.info("new lab added");

    }
    public UserCovid getUser(String name)
    {
        return hmUsers.get(name);
    }

    public void clear(){
        listLabs.clear();
        hmUsers.clear();
    }
    public void dirty() {
        this.dirty = true;
    }

    public boolean isDirty(){
        return dirty;
    }
}
