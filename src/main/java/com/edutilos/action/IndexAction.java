package com.edutilos.action;


import com.edutilos.pojo.Worker;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.util.SubsetIteratorFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Results({
@Result(name = "success", location="/index.jsp"),
        @Result(name = "input", location="/index.jsp"),
        @Result(name = "error", location = "/index.jsp")
})
public class IndexAction extends ActionSupport {
  private String name;
    private List<Worker> workerList;


    @Action("/indexAction")
    public String execute() {
        workerList = Arrays.asList(
           new Worker(1L , "foo", 10 , 100.0, true),
                new Worker(2L, "bar", 20 , 200.0 , false),
                new Worker(3L , "bim", 30, 300.0, true),
                new Worker(4L , "foo", 26 , 400.0, true),
                new Worker(5L, "bar", 15 , 500.0 , false),
                new Worker(6L , "bim", 11, 600.0, false)
        );
        return SUCCESS;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }


    public Comparator<Worker> getWorkerComparator() {
        return new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        //return workerComparator;
    }

    public SubsetIteratorFilter.Decider getWorkerDecider() {
       return new SubsetIteratorFilter.Decider() {
            @Override
            public boolean decide(Object element) throws Exception {
                Worker worker = (Worker)element;
                if(worker.getAge()< 20) return true ;
                return false;
            }
        };
        //return workerDecider;
    }

    public List<String> getList1() {
        return Arrays.asList("foo", "bar", "bim");
    }
    public List<String> getList2() {
        return Arrays.asList("oldFoo", "oldBar", "oldBim");
    }
    public List<String> getList3() {
        return Arrays.asList("newFoo", "newBar", "newBim");
    }



}
