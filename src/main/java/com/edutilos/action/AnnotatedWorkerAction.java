package com.edutilos.action;


import com.edutilos.pojo.AnnotatedWorker;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({
        @Result(name = "success", location = "/annotation/success.jsp"),
        @Result(name="input", location = "/annotation/index.jsp")
})
//@Validation()
public class AnnotatedWorkerAction extends ActionSupport implements ModelDriven<AnnotatedWorker>{
 public AnnotatedWorker worker ;


    @Action("/annotatedWorkerAction")
    public String execute() {
        return SUCCESS;
    }


/*
    @Validations(
            requiredFields = {
                    @RequiredFieldValidator(fieldName = "id", message= "id is required"),
                    @RequiredFieldValidator(message = "name is required", fieldName = "name"),
                    @RequiredFieldValidator(message = "age is required", fieldName = "age"),
                    @RequiredFieldValidator(message = "wage is required", fieldName = "wage"),
                    @RequiredFieldValidator(message = "active is required", fieldName = "active")
            },
            regexFields =  {
                    @RegexFieldValidator(regex = "[a-zA-Z]+", message = "name must be in letters", fieldName= "name")
            },
            intRangeFields =  {
                    @IntRangeFieldValidator(min = "0" , max = "100", message = "id must be in [0,100]", fieldName = "id"),
                    @IntRangeFieldValidator(min = "1", max = "35", message = "age must be in [1, 35]", fieldName = "age")
            }

    )*/
    @VisitorFieldValidator
    public AnnotatedWorker getWorker() {
        return worker;
    }

    public void setWorker(AnnotatedWorker worker) {
        this.worker = worker;
    }

    @Override
    public AnnotatedWorker getModel() {
        return worker ;
    }
}
