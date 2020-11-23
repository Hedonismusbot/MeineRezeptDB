package com.mono.myRecipeDB.model;


import javax.persistence.*;
import java.time.LocalDate;


@Entity // Mit Entity Tabellenname im Hybernate default -> klein geschriebener Klassenname
public class Todo {
    // Annotations können auch über Getter gschrieben werden
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO) //GenerationType.Auto -> Ist auto increment aber geht nicht mit H2 Datenbank
    private int id ;
    private String entry;
    private boolean done ;
    private LocalDate deadline ;
  //  @Column(name= "priority", length = 5) // Hier kann mit Columnannotation die Spalte eingestelt werden
    private Prio priority;

    //data.sql -> nicht nötig nur für testzwecke

    public Todo() {

    }


    public Todo(String entry, LocalDate deadline) {
        this.entry = entry;
        this.deadline = deadline;
    }
    public Todo(String entry, boolean done, LocalDate deadline) {
        this.entry = entry;
        this.done = done;
        this.deadline = deadline;

    }

    public Todo( String entry, boolean done, LocalDate deadline, Prio priority) {
        this.entry = entry;
        this.done = done;
        this.deadline = deadline;
        this.priority = priority;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Prio getPriority() {
        return priority;
    }

    public void setPriority(Prio prio) {
        this.priority = prio;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", entry='" + entry + '\'' +
                ", done=" + done +
                ", deadline=" + deadline +
                ", prio=" + priority +
                '}';
    }
}