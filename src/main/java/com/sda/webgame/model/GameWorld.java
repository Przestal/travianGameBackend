package com.sda.webgame.model;


import javax.persistence.*;

@Entity
public class GameWorld {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(unique = true)
    private String name;

    private int sizeRowColumns;

    public GameWorld() {
    }

    public GameWorld(String name, int sizeRowColumns) {
        this.name = name;
        this.sizeRowColumns = sizeRowColumns;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSizeRowColumns() {
        return sizeRowColumns;
    }

    public void setSizeRowColumns(int sizeRowColumns) {
        this.sizeRowColumns = sizeRowColumns;
    }
}
