package edu.upc.dsa.Classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Muestra {

    private String id;
    private int idClinico;
    private String name; //Nombre persona
    private String idLab;
    private String fechaMuestra;
    private Informe inf;

    public Muestra(String id, int idClinico, String name, String idLab, String fechaMuestra) {
        this.id = id;
        this.idClinico = idClinico;
        this.name = name;
        this.idLab = idLab;
        this.fechaMuestra = fechaMuestra;
    }
    public Muestra(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdClinico() {
        return idClinico;
    }

    public void setIdClinico(int idClinico) {
        this.idClinico = idClinico;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdLab() {
        return idLab;
    }

    public void setIdLab(String idLab) {
        this.idLab = idLab;
    }

    public String getFechaMuestra() {
        return fechaMuestra;
    }

    public void setFechaMuestra(String fechaMuestra) {
        this.fechaMuestra = fechaMuestra;
    }

    public Informe getInf() {
        return inf;
    }

    public void setInf(Informe inf) {
        this.inf = inf;
    }

    public String toString() {
        return "Muestra [id= "+id+ " clinico = " + id + " nameUser = " + name + " idLab = " + " fechaMuestra = " + fechaMuestra + "Informe = " + inf + "]";
    }

}
