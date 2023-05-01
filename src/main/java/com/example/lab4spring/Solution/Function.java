package com.example.lab4spring.Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Function {

    public double[] convertXToArray(ArrayList<Double> points) {
        double[] x = new double[points.size() / 2];
        for (int i = 0; i < points.size() / 2; i++) {
            x[i] = points.get(i);
        }
        return x;
    }

    public double[] convertYToArray(ArrayList<Double> points) {
        double[] y = new double[points.size() / 2];
        int counter = 0;
        for (int i = points.size() / 2; i < points.size(); i++) {
            y[counter] = points.get(i);
            counter++;
        }
        return y;
    }

    public double f(double x, double a, double b, double c, int functionNumber) {
        switch (functionNumber) {
            case (1) -> {
                return a * x + b;
            }
            case (2) -> {
                return a * Math.pow(x, b);
            }
            case (3) -> {
                return a * Math.pow(Math.E, b * x);
            }
            case (4) -> {
                if (x != 0)
                    return a * Math.log(x) + b;
                else
                    return b;
            }
            default -> {
                return a * Math.pow(x, 2) + b * x + c;
            }
        }
    }


    public double getA(double sum_x, double sum_xx, double sum_y, double sum_xy,
                       double sum_x_ln, double sum_y_ln, double sum_xx_ln, double sum_xy_ln,
                       double sum_y_ln_x, double sum_x_ln_y, int n, int functionNumber) {
        double v = n * sum_xx_ln - Math.pow(sum_x_ln, 2);

        switch (functionNumber) {
            case (1) -> {
                return (sum_xy * n - sum_x * sum_y) / (sum_xx * n - sum_x * sum_x);
            }
            case (2) -> {
                return Math.pow(Math.E, (sum_y_ln * sum_xx_ln - sum_xy_ln * sum_x_ln) / v);
            }
            case (3) -> {
                return Math.pow(Math.E, (sum_y_ln * sum_xx - sum_y_ln_x * sum_x) / (n * sum_xx - Math.pow(sum_x, 2)));
            }
            default -> {
                return (n * sum_x_ln_y - sum_y * sum_x_ln) / v;
            }
        }
    }

    public double getB(double sum_x, double sum_xx, double sum_y, double sum_xy,
                       double sum_x_ln, double sum_y_ln, double sum_xx_ln, double sum_xy_ln,
                       double sum_y_ln_x, double sum_x_ln_y, int n, int functionNumber) {
        double v = n * sum_xx_ln - Math.pow(sum_x_ln, 2);

        switch (functionNumber) {
            case (1) -> {
                return (sum_xy * sum_x - sum_xx * sum_y) / (Math.pow(sum_x, 2) - n * sum_xx);
            }
            case (2) -> {
                return (n * sum_xy_ln - sum_y_ln * sum_x_ln) / v;
            }
            case (3) -> {
                return (n * sum_y_ln_x - sum_y_ln * sum_x) / (n * sum_xx - Math.pow(sum_x, 2));
            }
            default -> {
                return (sum_y * sum_xx_ln - sum_x_ln_y * sum_x_ln) / v;
            }
        }
    }


    public double[] getQ(double[][] Func1, double[][] Func2, double[][] Func3, double[][] Func4, double[][] Func5) {
        double[] q = new double[5];
        double[] res = new double[2];

        for (int i = 0; i < Func1.length; i++) {
            q[0] += Math.pow(Func1[2][i] - Func1[1][i], 2);
            q[1] += Math.pow(Func1[2][i] - Func1[1][i], 2);
            q[2] += Math.pow(Func1[2][i] - Func1[1][i], 2);
            q[3] += Math.pow(Func1[2][i] - Func1[1][i], 2);
            q[4] += Math.pow(Func1[2][i] - Func1[1][i], 2);
        }

        q[0] = Math.sqrt(q[0] / Func1.length);
        q[1] = Math.sqrt(q[1] / Func1.length);
        q[2] = Math.sqrt(q[2] / Func1.length);
        q[3] = Math.sqrt(q[3] / Func1.length);
        q[4] = Math.sqrt(q[4] / Func1.length);

        double minValue = q[0];
        double numberOfFunc = 1;
        for (int i = 1; i < q.length; i++) {
            if (q[i] < minValue) {
                minValue = q[i];
                numberOfFunc = i + 1;
            }
        }
        res[0] = numberOfFunc;
        res[1] = minValue;

        return res;
    }
}
