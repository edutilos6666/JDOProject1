package com.edutilos.comparator;

import com.edutilos.pojo.Worker;

import java.util.Comparator;

/**
 * Created by edutilos on 30/08/2016.
 */
public class WorkerByWageComparator implements Comparator<Worker>{
    @Override
    public int compare(Worker o1, Worker o2) {
        Double w1 = o1.getWage(),
                w2 = o2.getWage();
        return w2.compareTo(w1);
    }
}
