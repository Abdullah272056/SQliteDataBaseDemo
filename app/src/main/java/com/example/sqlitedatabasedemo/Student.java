package com.example.sqlitedatabasedemo;

public class Student {
    int id;
    String name;
    String roll;

    public Student() {

    }

    public Student(String name, String roll) {
        this.name = name;
        this.roll = roll;
    }

    public Student(int id, String name, String roll) {
        this.id = id;
        this.name = name;
        this.roll = roll;
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

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }
}
