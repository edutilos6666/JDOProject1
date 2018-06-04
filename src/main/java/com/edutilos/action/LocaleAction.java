package com.edutilos.action;

import com.edutilos.pojo.Employee;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by edutilos on 30/08/2016.
 */
public class LocaleAction extends ActionSupport {

    private Employee employee ;

    public String execute() {
        return SUCCESS;
    }


    public String changeLocale() {
        return SUCCESS ;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
