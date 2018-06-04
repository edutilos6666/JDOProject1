package com.edutilos.action;

import com.edutilos.pojo.Employee;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Locale;

/**
 * Created by edutilos on 30/08/2016.
 */
public class EmployeeAction extends ActionSupport {
  private Employee employee ;
    {
        Locale.setDefault(Locale.US);
    }

    public String execute() {

        return SUCCESS ;
    }
   /* @Override
    public void validate() {
       long id = employee.getId();
        String name = employee.getName();
        int age = employee.getAge();
        double wage = employee.getWage();
        boolean active = employee.isActive();

        if(id <=0 || id > 20) {
            addFieldError("employee.id", "id must be in [1,20]");
        }

        if(!name.matches("[a-zA-Z]+")) {
            addFieldError("employee.name", "name must be only letters");
        }

        if(age <= 0 || age > 30) {
            addFieldError("employee.age", "age must be in [1,30]");
        }

        if(wage <= 0 || wage > 300.0) {
            addFieldError("employee.wage", "wage must be in [1, 300]");
        }

    }*/

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
