package edu.upc.dsa;

import edu.upc.dsa.Classes.Informe;
import edu.upc.dsa.Classes.Laboratorio;
import edu.upc.dsa.Classes.Muestra;
import edu.upc.dsa.Classes.UserCovid;

import java.util.List;

public interface Covid19Manager {
    public void addUser(UserCovid user);
    public void ExtraerMuestra(Muestra muestra);
    public Muestra ProcesarMuestra(int idLab);
    public void GenerarInforme(Muestra m, Informe i);
    public List<Muestra> MuestrasProcesadasUsuario(String name);
    public void addLab(Laboratorio lab);
    public void clear();
    public void dirty();
    public boolean isDirty();
    public UserCovid getUser(String name);



}
