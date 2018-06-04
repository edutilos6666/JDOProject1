package com.edutilos.action;


import com.edutilos.jdbc.PersonJDBCHelper;
import com.edutilos.pojo.Person;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PersonJDBCAction extends ActionSupport {

    private Person person = new Person();
    private PersonJDBCHelper jdbc = new PersonJDBCHelper();
    private List<Person> personList = new ArrayList<>();
    private long id ;
    private Logger logger = LogManager.getLogger(PersonJDBCAction.class);
  /*  {
        logger.info("inside PersonJDBCAction ctor");
        jdbc.connect();
        jdbc.dropTablePerson();
        jdbc.createTablePerson();
        jdbc.save(new Person("foo", 10 , 100.0, true));
        jdbc.save(new Person("bar", 20 , 200.0 , false));
        jdbc.save(new Person("bim", 30 , 300.0, true));
    }*/

    public PersonJDBCAction() {
        logger.info("inside PersonJDBCAction ctor");
        jdbc.connect();
      /*  jdbc.dropTablePerson();
        jdbc.createTablePerson();
        jdbc.savePerson(new Person("foo", 10 , 100.0, true));
        jdbc.savePerson(new Person("bar", 20 , 200.0 , false));
        jdbc.savePerson(new Person("bim", 30 , 300.0, true));*/
    }

    public String findAll() {
        personList = jdbc.findAll();
        return SUCCESS;
    }

    public String savePerson()  {
        jdbc.savePerson(person);
        personList = jdbc.findAll();
        logger.info(String.format("name = %s", person.getName()));
        logger.info(String.format("age = %d", person.getAge()));
        return SUCCESS ;
    }

    public String updatePerson() {
        jdbc.updatePerson(id , person);
        personList = jdbc.findAll();
        return SUCCESS ;
    }

    public String deletePerson() {
        jdbc.deletePerson(id);
        personList = jdbc.findAll();
        return SUCCESS ;
    }
    public String findById() {
        person = jdbc.findById(id);
        logger.info(String.format("[%d, %s, %d , %f, %b]", person.getId(),
                person.getName(), person.getAge(), person.getWage(), person.isActive()));
        return SUCCESS ;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
