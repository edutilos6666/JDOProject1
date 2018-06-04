package com.edutilos.action;

/**
 * Created by edutilos on 29/08/2016.
 */
public class HelloWorldAction {
   private String name;
    private int age ;
    private double wage ;
    private boolean active ;
    public String execute() {
        return "success";
    }

    public String getPerson() {
        return "person";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
