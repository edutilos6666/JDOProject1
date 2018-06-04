package com.edutilos.pojo;


import javax.persistence.*;
import java.util.List;

@Entity
public class School {
    @Id
    @GeneratedValue
   private long id;
    private String name;
    @OneToMany(cascade =CascadeType.ALL)
    private List<Teacher> teachers;

    public School(String name, List<Teacher> teachers) {
        this.name = name;
        this.teachers = teachers;
    }

    public School() {
    }

    public School(String name) {
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

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teachers=" + teachers +
                '}';
    }
}
