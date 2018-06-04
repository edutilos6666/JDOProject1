package com.edutilos.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by edutilos on 30/08/2016.
 */
public class NPEAction  extends ActionSupport{
    private String name;


    public String execute() {
        name = null ;
        name = name.substring(0, 5);
        return SUCCESS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
