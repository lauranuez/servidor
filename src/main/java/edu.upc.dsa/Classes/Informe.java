package edu.upc.dsa.Classes;

public class Informe {
    private String resultado;
    private String comentario;

    public Informe(String resultado, String comentario) {
        this.resultado = resultado;
        this.comentario = comentario;
    }
    public Informe() {
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getResultado() {
        return resultado;
    }

    public String toString() {
        return "Informe [resultado= "+resultado+ " comentario = " + comentario + "]";
    }
}
