package jsonModel;

import java.time.DayOfWeek;

public class JsonModel {
    private String name;
    private String sureName;
    private Integer age;
    private DayOfWeek dayOfWeek;

    public JsonModel(String name, String sureName, Integer age, DayOfWeek dayOfWeek) {
        this.name = name;
        this.sureName = sureName;
        this.age = age;
        this.dayOfWeek = dayOfWeek;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
