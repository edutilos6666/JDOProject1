package com.edutilos.action;


import com.edutilos.jdbc.WorkerJDOHelper;
import com.edutilos.pojo.Worker;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class WorkerJDOAction extends ActionSupport{
  private Worker worker ;
    private List<Worker> workerList ;
    private static WorkerJDOHelper jdo ;
    private Logger logger = LogManager.getLogger(WorkerJDOAction.class);

    static {
        System.out.println("Inside static initializer!");
        jdo = new WorkerJDOHelper();
        jdo.connect();
    }

    public WorkerJDOAction() {

    }

    public String findAll() {
       workerList = jdo.findAll();
        return SUCCESS;
    }

    public String saveWorker() {
       jdo.saveWorker(worker);
        workerList = jdo.findAll();
        return SUCCESS;
    }

    public String updateWorker() {
        jdo.updateWorker(worker.getId(), worker);
        workerList = jdo.findAll();
        return SUCCESS;
    }

    public String deleteWorker() {
        jdo.deleteWorker(worker.getId());
        workerList = jdo.findAll();
        return SUCCESS;
    }

    public String findById() {
        worker = jdo.findById(worker.getId());
        return SUCCESS;
    }



    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }
}
