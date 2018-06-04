package com.edutilos.pojo;


import com.opensymphony.xwork2.validator.annotations.DoubleRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

public class AnnotatedWorker {
    private long id;
    private String name;
    private int age;
    private double wage;
    private boolean active;

    public AnnotatedWorker(long id, String name, int age, double wage, boolean active) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.wage = wage;
        this.active = active;
    }

    public AnnotatedWorker() {
    }

    @RequiredFieldValidator(message= "id is required")
    /*@IntRangeFieldValidator(min = "0" , max = "100", message = "id must be in [0,100]")*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @RequiredFieldValidator(message = "name is required")
    @RegexFieldValidator(regex = "[a-zA-Z]{1,}", message = "name must be in letters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @RequiredFieldValidator(message = "age is required")
    @IntRangeFieldValidator(min = "1", max = "35", message = "age must be in [1, 35]")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @RequiredFieldValidator(message = "wage is required")
    @DoubleRangeFieldValidator(minInclusive = "0", maxInclusive = "100.0", message = "wage must be in [100.0 , 300.0]")
    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @RequiredFieldValidator(message = "active is required")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
