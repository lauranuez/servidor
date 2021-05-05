package edu.upc.dsa.Classes;
import java.util.Date;

public class Game {

    private String id;
    private Date date;
    private String idPlayer;
    private int levelsPassed;
    private float startTime;
    private float endTime;

    public Game(){
    }

    public Game(String idPlayer,Date date, float startTime){
        this.idPlayer = idPlayer;
        this.date = date;
        this.startTime = startTime;
        //generate random id
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(String idPlayer) {
        this.idPlayer = idPlayer;
    }

    public int getLevelsPassed() {
        return levelsPassed;
    }

    public void setLevelsPassed(int levelsPassed) {
        this.levelsPassed = levelsPassed;
    }


    public String toString() {
        return "Product [id= "+id+", date= " + date + ", idPlayer= " + idPlayer +"levelsPassed= "+levelsPassed+"]";
    }

}
