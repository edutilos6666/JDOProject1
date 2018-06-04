package com.edutilos.action;

import com.opensymphony.xwork2.ActionSupport;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Created by edutilos on 01/09/2016.
 */
public class JFreeChartAction extends ActionSupport {
    private JFreeChart chart ;

    private String PIE_CHART = "pieChart";
    private String RING_CHART = "ringChart";

    public String generatePieChart() {
        String title = "PieChart example";
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Chrome", 100);
        dataset.setValue("Firefox", 70);
        dataset.setValue("Opera", 50);
        dataset.setValue("Edge", 30);
        dataset.setValue("IE", 10);
        chart = ChartFactory.createPieChart(title, dataset, true, true, true);
        return PIE_CHART;
    }



    public String generateRingChart() {
        String title = "RingChart example";
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Chrome", 100);
        dataset.setValue("Firefox", 70);
        dataset.setValue("Opera", 50);
        dataset.setValue("Edge", 30);
        dataset.setValue("IE", 10);
        chart = ChartFactory.createRingChart(title, dataset, true, true, true);
        return RING_CHART ;
    }

    public JFreeChart getChart() {
        return chart;
    }

    public void setChart(JFreeChart chart) {
        this.chart = chart;
    }
}
