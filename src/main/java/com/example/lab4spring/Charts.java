package com.example.lab4spring;

import com.example.lab4spring.Solution.Function;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class Charts {
    public JFreeChart drawChart(double[][] points, double[][] resultOfSystem) {
        Function functions = new Function();

        XYSeries series = new XYSeries("Points");
        XYSeries series1 = new XYSeries("Func_1");
        XYSeries series2 = new XYSeries("Func_2");
        XYSeries series3 = new XYSeries("Func_3");
        XYSeries series4 = new XYSeries("Func_4");
        XYSeries series5 = new XYSeries("Func_5");

        XYSeriesCollection dataset = new XYSeriesCollection();

        for (int i = 0; i < points.length; i++) {
            series.add(points[0][i], points[1][i]);
            series1.add(points[0][i], functions.f(i, resultOfSystem[0][0], resultOfSystem[0][1], 0, 1));
            series2.add(points[0][i], functions.f(i, resultOfSystem[1][0], resultOfSystem[1][1], 0, 2));
            series3.add(points[0][i], functions.f(i, resultOfSystem[2][0], resultOfSystem[2][1], 0, 3));
            series4.add(points[0][i], functions.f(i, resultOfSystem[3][0], resultOfSystem[3][1], 0, 4));
            series5.add(points[0][i], functions.f(i, resultOfSystem[4][0], resultOfSystem[4][1], resultOfSystem[4][2], 5));
        }


//
//        int width = 1920;
//        int height = 1080;
        dataset.addSeries(series);
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        dataset.addSeries(series4);
        dataset.addSeries(series5);
        JFreeChart lineChart = ChartFactory.createXYLineChart("Fi(x)", "x",
                "Y", dataset, PlotOrientation.VERTICAL,
                true, true, false);

        return lineChart;
    }

}
