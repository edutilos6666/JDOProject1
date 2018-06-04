package com.edutilos.pojo;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by edutilos on 30/08/2016.
 */
public class SpringWorker extends ActionSupport {
  private long id ;
    private String name;

    public SpringWorker(long id, String name) {
        this.id = id;
        this.name = name;
    }



    public SpringWorker() {
    }

    public String execute() {
        return SUCCESS;
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

    @Override
    public String toString() {
        return "SpringWorker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
