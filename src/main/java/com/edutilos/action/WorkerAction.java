package com.edutilos.action;



public class WorkerAction {
  private String name;
    private int age;
    private double wage;
    private boolean active;


    public  static final String RESULT1 = "res1",
            RESULT2 = "res2";

    public String rs1() {
        return RESULT1;
    }

    public String rs2() {
        return RESULT2;
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
