package com.sda.webgame.model;

import javax.persistence.*;

@Entity
public class Colony {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToOne
    private GameWorldField field;

    @ManyToOne
    private GameUser owner;

    private int maxSlots;

    public Colony(String name, GameWorldField field, GameUser owner, int maxSlots) {
        this.name = name;
        this.field = field;
        this.owner = owner;
        this.maxSlots = maxSlots;
    }

    public Colony(String colonyName, int i, GameWorldField field, GameUser owner) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameWorldField getField() {
        return field;
    }

    public void setField(GameWorldField field) {
        this.field = field;
    }

    public GameUser getOwner() {
        return owner;
    }

    public void setOwner(GameUser owner) {
        this.owner = owner;
    }

    public int getMaxSlots() {
        return maxSlots;
    }

    public void setMaxSlots(int maxSlots) {
        this.maxSlots = maxSlots;
    }
}
