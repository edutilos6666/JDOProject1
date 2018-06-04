package com.edutilos.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Created by edutilos on 30/08/2016.
 */
public class PersonInterceptor extends AbstractInterceptor{
  private long id ;
    private String name;
    private int age;
    private double wage;

    public PersonInterceptor(long id, String name, int age, double wage) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.wage = wage;
    }

    public PersonInterceptor() {
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Logger logger = LogManager.getLogger(PersonInterceptor.class);
        logger.info("Pre-Processing PersonInterceptor");
        logger.info(String.format("[%d, %s, %d, %f]", id , name, age, wage));
        String result = invocation.invoke();
        logger.info("Post-Processing PersonInterceptor");

        return result;
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
}
