package com.example.debut.entity;

public class Test {
    private String id;
    private int age;
    private boolean isOn;

    public Test() {

    }

    public Test(String id, int age) {
        super();
        this.id = id;
        this.age = age;
    }

    public Test(String id, int age, boolean isOn) {
        this.id = id;
        this.age = age;
        this.isOn = isOn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
