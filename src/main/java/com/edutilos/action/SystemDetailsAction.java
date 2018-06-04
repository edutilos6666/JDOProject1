package com.edutilos.action;

import com.edutilos.pojo.SystemDetails;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by edutilos on 30/08/2016.
 */
public class SystemDetailsAction extends ActionSupport {
    private SystemDetails details ;

    public String execute() {
        return SUCCESS ;
    }

    public SystemDetails getDetails() {
        return details;
    }

    public void setDetails(SystemDetails details) {
        this.details = details;
    }
}
