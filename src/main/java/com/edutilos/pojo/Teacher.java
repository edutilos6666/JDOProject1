package com.edutilos.pojo;


import javax.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue
  private long id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    private School school;

    public Teacher(String name, School school) {
        this.name = name;
        this.school = school;
    }

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", school=" + school +
                '}';
    }
}

