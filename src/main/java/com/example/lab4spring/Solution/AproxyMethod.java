package com.example.lab4spring.Solution;

import java.util.ArrayList;

public class AproxyMethod {

    private double[] x;
    private double[] y;

    public AproxyMethod(double[] x, double[] y) {
        this.x = x;
        this.y = y;
    }

    public void lineApproximation() {
        double sx;
        double sy;
        double sxx;
        double sxy;
    }

    private double sumX(double[] x) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i];
        }
        return sum;
    }

    private double sumXX(double[] x) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += Math.pow(x[i], 2);
        }
        return sum;
    }

    private double sumY(double[] y) {
        double sum = 0;
        for (int i = 0; i < y.length; i++) {
            sum += y[i];
        }
        return sum;
    }

    private double sumXY(double[] x, double[] y) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i] * y[i];
        }
        return sum;
    }

}
