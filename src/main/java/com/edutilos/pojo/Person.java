package com.edutilos.pojo;


import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name="person.selectAll", query = "select p from Person p"),
        @NamedQuery(name="person.selectNamedParam", query = "select p from Person p where p.name = :name and p.age = :age and p.wage = :wage"),
        @NamedQuery(name="person.selectOrdinalParam", query = "select p from Person p where p.name = ?1 and p.age = ?2 and p.wage = ?3")
})
public class Person {

    @Id
    @GeneratedValue
    private long id ;
    private String name;
    private int age ;
    private double wage ;
    private boolean active;

    public Person(String name, int age, double wage, boolean active) {
        this.name = name;
        this.age = age;
        this.wage = wage;
        this.active = active;
    }

    public Person() {
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", wage=" + wage +
                ", active=" + active +
                '}';
    }
}
