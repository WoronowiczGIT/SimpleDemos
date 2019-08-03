package com.example.demo3;

public class PersonCommand {
    private Long id;
    private String name;
    private String surename;

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

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public PersonCommand(Long id, String name, String surename) {
        this.id = id;
        this.name = name;
        this.surename = surename;
    }

    public PersonCommand(String name, String surename) {
        this.name = name;
        this.surename = surename;
    }

    public PersonCommand() {
    }
}
