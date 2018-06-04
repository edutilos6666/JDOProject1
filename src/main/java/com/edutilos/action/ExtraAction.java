package com.edutilos.action;

import com.edutilos.pojo.Worker;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import java.util.Arrays;
import java.util.List;



@Results({
        @Result(name="success", location="/extraAction.jsp")
})
public class ExtraAction extends ActionSupport {
    private List<String> langSkills;
    @Action("/extraIndexAction")
    public String execute() {
        langSkills = Arrays.asList("reading", "writing", "listening", "speaking");
        return SUCCESS;
    }

    public List<String> getLangSkills() {
        return langSkills;
    }

    public Worker getWorker() {
        return new Worker(1L , "foobar", 10, 100.0, true);
    }
 }
