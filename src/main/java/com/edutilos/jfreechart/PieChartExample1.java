package com.edutilos.jfreechart;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYStepAreaRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Locale;
import java.util.Random;
import java.util.StringTokenizer;

public class PieChartExample1 extends ApplicationFrame {
    /**
     * Constructs a new application frame.
     *
     * @param title the frame title.
     */
    public PieChartExample1(String title) {
        super(title);
        setContentPane(createContentPane());
    }

    private JPanel createContentPane() {
      return createRingChartFromDb();
    }




    private ChartPanel createRingChartFromDb() {
        ChartPanel panel = null ;
        Connection conn = null ;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            DefaultPieDataset dataset = new DefaultPieDataset();
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root",
                    password = "";
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

            rs = stmt.executeQuery("select * from browsers");
            while(rs.next()) {
                String name = rs.getString(2);
                double  value = rs.getDouble(3);
                dataset.setValue(name, value);
            }

            String title = "Ring Chart from DB";
            JFreeChart chart = ChartFactory.createRingChart(title, dataset, true, true, true);
            panel = new ChartPanel(chart);
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if(rs!= null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return panel ;
    }

    private ChartPanel createRingChartFromFile() {
        ChartPanel panel = null ;
        try {
            DefaultPieDataset dataset = new DefaultPieDataset();
            BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\edutilos\\IdeaProjects\\JDOProject1\\pieDataSource.txt")));
            for(String line = reader.readLine(); line != null && !line.equals(""); ) {
                StringTokenizer tokenizer = new StringTokenizer(line, "=");
                String name = tokenizer.nextToken().trim();
                double value = Double.parseDouble(tokenizer.nextToken().trim());
                dataset.setValue(name, value);
                line = reader.readLine();
            }

            String title = "RingChart from File";
            JFreeChart chart = ChartFactory.createRingChart(title, dataset , true, true, true);
            panel = new ChartPanel(chart);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return panel ;
    }

    private ChartPanel createRingChart() {
        String title = "ring chart";
        DefaultPieDataset dataset = new DefaultPieDataset();
        Random rand = new Random();
        dataset.setValue("Chrome", rand.nextDouble()* 100);
        dataset.setValue("Firefox", rand.nextDouble()* 100);
        dataset.setValue("Edge", rand.nextDouble()*100);
        dataset.setValue("Opera", rand.nextDouble()* 100);
        JFreeChart chart = ChartFactory.createRingChart(title, dataset, true, true, true);
       return new ChartPanel(chart);
    }


    private ChartPanel createTimeSeriesChart() {
        String title = "Computing Test Values";
        String timeAxisLabel = "Seconds";
        String valueAxisLabel = "Value";
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        TimeSeries series1 = new TimeSeries("Series1");
        TimeSeries series2 = new TimeSeries("Series2");
        TimeSeries series3 = new TimeSeries("Series3");
        Second current = new Second();
        double value = 100,
                value2 = 200 ,
                value3 = 300;
         for(int i=0 ; i< 4000; ++i) {
             value = value + Math.random() - 0.5 ;
             series1.add(current, value);
             value2 = value2 + Math.random() - 0.5 ;
             series2.add(current , value2);
             value3 = value3 + Math.random() - 0.5 ;
             series3.add(current, value3);
             current = (Second) current.next();
         }
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(title, timeAxisLabel, valueAxisLabel, dataset , true, true, true);
         return new ChartPanel(chart);
    }

    private ChartPanel createBubbleChart() {
        String title = "Age vs Weight vs Work";
        String xAxisLabel = "Age";
        String yAxisLabel = "Weight";
        DefaultXYZDataset dataset = new DefaultXYZDataset();
        Random rand = new Random();

        double [][] series1 = {generateRandom6Doubles(100), generateRandom6Doubles(100), generateRandom6Doubles(30)};
        double [][] series2 = {generateRandom6Doubles(100), generateRandom6Doubles(100), generateRandom6Doubles(30)};
        double [][] series3 = {generateRandom6Doubles(100), generateRandom6Doubles(100), generateRandom6Doubles(30)};
        dataset.addSeries("Series1", series1);
        dataset.addSeries("Series2", series2);
        dataset.addSeries("Series3", series3);
        PlotOrientation plotOrientation = PlotOrientation.VERTICAL;
        JFreeChart chart = ChartFactory.createBubbleChart(title, xAxisLabel , yAxisLabel , dataset, plotOrientation , true, true, true);
        ChartPanel panel =  new ChartPanel(chart);
        panel.setMouseZoomable(true , false);
        return panel ;
    }

    private double [] generateRandom6Doubles(int f) {
       // long f = 10;
        Random rand = new Random();
        double [] d = {
                rand.nextDouble()* f ,
                rand.nextDouble()* f ,
                rand.nextDouble()* f ,
                rand.nextDouble()* f ,
                rand.nextDouble()* f ,
                rand.nextDouble()* f
        };
        return d ;
    }



    private ChartPanel createXYChart() {
        String title = "XYChart";
        String xAxisLabel = "Phone Models";
        String yAxisLabel = "Market share";
        XYSeriesCollection coll = new XYSeriesCollection();
        XYSeries iphoneSeries = new XYSeries("IPhone");
        Random rand = new Random();
        iphoneSeries.add(1.0 , rand.nextDouble()*100);
        iphoneSeries.add(2.0 , rand.nextDouble()* 100);
        iphoneSeries.add(3.0 , rand.nextDouble()*100);
        XYSeries samsungSeries = new XYSeries("Samsung");
        samsungSeries.add(2.0, rand.nextDouble()* 100);
        samsungSeries.add(3.0, rand.nextDouble()*100);
        samsungSeries.add(4.0, rand.nextDouble()* 100);
        XYSeries zteSeries = new XYSeries("ZTE");
        zteSeries.add(5.0 , rand.nextDouble()* 100);
        zteSeries.add(6.0, rand.nextDouble()* 100);
        coll.addSeries(iphoneSeries);
        coll.addSeries(samsungSeries);
        coll.addSeries(zteSeries);
        PlotOrientation plotOrientation = PlotOrientation.VERTICAL;
        JFreeChart chart = ChartFactory.createXYStepChart(title, xAxisLabel , yAxisLabel , coll , plotOrientation , true, true, true);
        XYPlot plot = chart.getXYPlot();

        XYStepAreaRenderer renderer = new XYStepAreaRenderer();
        renderer.setSeriesPaint(0 , Color.RED);
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesPaint(2, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(3.0f));
        renderer.setSeriesStroke(1, new BasicStroke(3.0f));
        renderer.setSeriesStroke(2, new BasicStroke(3.0f));
        plot.setRenderer(renderer);
        return new ChartPanel(chart);
    }


    private ChartPanel  createLineChart() {
        String title = "lineChart";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String rowName = "IPhone";
        String [] colNames  = {"1970", "1980", "1990", "2000", "2010", "2020"};
        Random rand = new Random();
        for(String col: colNames) {
            Double val = rand.nextDouble()* 100 ;
            dataset.addValue(val , rowName, col);
        }

        String categoryLabel = "IPhone Model";
        String valueLabel = "Years";
        PlotOrientation plotOrientation = PlotOrientation.VERTICAL;
        JFreeChart chart = ChartFactory.createLineChart3D(title, categoryLabel , valueLabel , dataset , plotOrientation , true, true, true);
       return new ChartPanel(chart);
    }


    private ChartPanel createBarChart() {
        String title = "barChart";
        String categoryLabel = "Phone models";
        String valueLabel = "Years";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String [] rowKeys = {"Year 2013", "Year 2014", "Year 2015", "Year 2016"};
        String [] colKeys  = {"IPhone", "Samsung Galaxy", "ZTO"};
        Random rand = new Random() ;
        for(int i= 0 ; i <rowKeys.length; ++i) {
            for(int j=0 ; j< colKeys.length; ++j) {
                double val = rand.nextDouble()* 100 ;
                dataset.addValue(val , colKeys[j], rowKeys[i]);
            }
        }

        PlotOrientation plotOrientation = PlotOrientation.VERTICAL;
        JFreeChart chart = ChartFactory.createStackedBarChart3D(title, categoryLabel , valueLabel, dataset , plotOrientation , true, true, true);
         String fileName = "barChart3d.jpeg";
    /*    try {
            ChartUtilities.saveChartAsJPEG(new File(fileName), chart, 500 , 500);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return new ChartPanel(chart);
    }

    private ChartPanel createPieChart() {
        String title = "PieChartExample1";
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("IPhone", new Double(100));
        dataset.setValue("Samsung Galaxy", new Double(150));
        dataset.setValue("ZTO", new Double(50));
        JFreeChart chart  = ChartFactory.createPieChart(title, dataset , true , true, Locale.US);
        return new ChartPanel(chart);
    }

    private ChartPanel createPieChart3D() {
        String title = "PieChart3D";
        DefaultPieDataset dataset = new DefaultPieDataset() ;
        dataset.setValue("IPhone", new Double(100));
        dataset.setValue("Samsung Galaxy", new Double(150));
        dataset.setValue("ZTO", new Double(50));
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true , true, true);
        return new ChartPanel(chart);
    }

   private ChartPanel createMultipieChart() {
       String title = "MultipieChart";
       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       String[] rowKeys= {"Year 2013", "Year 2014", "Year 2015", "Year 2016"};
       String[] colKeys = {"IPhone", "Samsung Galaxy", "ZTO"};

       Random rand = new Random();
       for(int i =0 ; i< rowKeys.length; ++i) {
           for(int j=0 ; j< colKeys.length; ++j) {
               Double val = rand.nextDouble()* 100 ;
               dataset.setValue(val , rowKeys[i], colKeys[j]);
           }
       }
       TableOrder tableOrder = TableOrder.BY_ROW;
       JFreeChart chart = ChartFactory.createMultiplePieChart(title, dataset , tableOrder, true , true , true);
       return new ChartPanel(chart);
   }



    public static void main(String[] args) {
        PieChartExample1 ex = new PieChartExample1("PieChartExample1 title");
        ex.setSize(new Dimension(500, 500));
        RefineryUtilities.centerFrameOnScreen(ex);
        ex.setVisible(true);
    }
}
