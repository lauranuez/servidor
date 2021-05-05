package edu.upc.dsa.Classes;

import java.util.LinkedList;
import java.util.Queue;

public class Laboratorio {
    private int id;
    private String name;
    private Queue<Muestra> MuestrasPendientes = new LinkedList<>();

    public Laboratorio(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Laboratorio() {
    }

    public Queue<Muestra> getMuestrasPendientes() {
        return MuestrasPendientes;
    }

    public void setMuestrasPendientes(Queue<Muestra> muestrasPendientes) {
        MuestrasPendientes = muestrasPendientes;
    }

    public void addQueueMuestra(Muestra muestra)
    {
        MuestrasPendientes.add(muestra);
    }
    public Muestra ProcesarMuestra()
    {
        return MuestrasPendientes.remove();
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

    public String toString() {
        return "Lab [id= "+id+ " name = " + name + "]";
    }
}
