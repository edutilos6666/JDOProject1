package com.edutilos.decider;

import com.edutilos.pojo.Worker;
import org.apache.struts2.util.SubsetIteratorFilter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by edutilos on 30/08/2016.
 */
public class WorkerByNameDecider implements SubsetIteratorFilter.Decider {
    @Override
    public boolean decide(Object element) throws Exception {
        Worker worker = (Worker) element;
        List<String> names = Arrays.asList("foo", "newFoo", "oldFoo", "bar", "newBar", "oldBar");
        return names.contains(worker.getName());
    }
}
