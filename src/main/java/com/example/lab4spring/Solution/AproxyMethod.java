package com.example.lab4spring.Solution;

import java.util.ArrayList;

public class AproxyMethod {

    private final double[] x;
    private final double[] y;


    public AproxyMethod(double[] x, double[] y) {
        this.x = x;
        this.y = y;
    }

    public double[][] ABForAllFunctions() {
        GaussMethod gaussMethod = new GaussMethod();
        double[][] ABResults = new double[5][3];
        Function function = new Function();

        double sx = sumX(x);
        double sx_3 = sumX_3(x);
        double sx_4 = sumX_4(x);
        double sy = sumY(y);
        double sxx = sumXX(x);
        double sxy = sumXY(x, y);
        double sx_2y = sum_x_2_y(x, y);
        double sum_x_ln = sum_x_ln(x);
        double sum_x_2_ln = sum_x_2_ln(x);
        double sum_x_y_ln = sum_x_y_ln(x, y);
        double sum_y_ln = sum_y_ln(y);
        double sum_y_ln_x = sum_y_ln_x(x, y);
        double sum_x_ln_y = sum_x_ln_y(x, y);


        double[][] matrix5Func = new double[][]{{x.length, sx, sxx, sy},
                {sx, sxx, sx_3, sxy},
                {sxx, sx_3, sx_4, sx_2y}};
        double[][] matrix1Func = new double[][]{{sxx, sx, sxy},
                {sx, x.length, sy}};

        double[] resultOfSystem1Func = gaussMethod.startMethod(matrix1Func, 2);
        double[] resultOfSystem5Func = gaussMethod.startMethod(matrix5Func, 3);

        ABResults[0][0] = resultOfSystem1Func[0];
        ABResults[0][1] = resultOfSystem1Func[1];


        ABResults[4][0] = resultOfSystem5Func[0];
        ABResults[4][1] = resultOfSystem5Func[1];
        ABResults[4][2] = resultOfSystem5Func[2];

        ABResults[1][0] = function.getA(sx, sxx, sy, sxy, sum_x_ln, sum_y_ln,
                sum_x_2_ln, sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, x.length, 2);
        ABResults[1][1] = function.getB(sx, sxx, sy, sxy, sum_x_ln, sum_y_ln,
                sum_x_2_ln, sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, x.length, 2);

        ABResults[2][0] = function.getA(sx, sxx, sy, sxy, sum_x_ln, sum_y_ln,
                sum_x_2_ln, sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, x.length, 3);
        ABResults[2][1] = function.getB(sx, sxx, sy, sxy, sum_x_ln, sum_y_ln,
                sum_x_2_ln, sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, x.length, 3);

        ABResults[3][0] = function.getB(sx, sxx, sy, sxy, sum_x_ln, sum_y_ln,
                sum_x_2_ln, sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, x.length, 4);
        ABResults[3][1] = function.getB(sx, sxx, sy, sxy, sum_x_ln, sum_y_ln,
                sum_x_2_ln, sum_x_y_ln, sum_y_ln_x, sum_x_ln_y, x.length, 4);

        return ABResults;
    }


    public double[][] firstFunction(double[] x, double[] y, double[][] resultOfSystem) {
        double[][] result = new double[4][x.length];
        for (int i = 0; i < x.length; i++) {
            result[0][i] = x[i];
            result[1][i] = y[i];
        }
//        System.out.println(x[1]);
//        System.out.println(resultOfSystem[0][1]);
//        System.out.println(resultOfSystem[0][0]);
        for (int i = 0; i < y.length; i++) {
            result[2][i] = resultOfSystem[0][0] * x[i] + resultOfSystem[0][1];
            result[3][i] = result[2][i] - y[i];

            System.out.println(i + ": " + result[2][i]);

        }


        return result;
    }

    public double[][] fifthFunction(double[] x, double[] y, double[][] resultOfSystem) {
        double[][] result = new double[4][x.length];
        for (int i = 0; i < x.length; i++) {
            result[0][i] = x[i];
            result[1][i] = y[i];
        }
        System.out.println(resultOfSystem[4][2]);
        System.out.println(resultOfSystem[4][1]);
        System.out.println(resultOfSystem[4][0]);
        for (int i = 0; i < y.length; i++) {
            result[2][i] = resultOfSystem[4][0] * Math.pow(x[i], 2) + resultOfSystem[4][1] * x[i] + resultOfSystem[4][2];
            result[3][i] = result[2][i] - y[i];
        }


        return result;
    }

    public double[][] secondFunction(double[] x, double[] y, double[][] resultOfSystem) {
        double[][] result = new double[4][x.length];
        for (int i = 0; i < x.length; i++) {
            result[0][i] = x[i];
            result[1][i] = y[i];
        }
        for (int i = 0; i < y.length; i++) {
            result[2][i] = resultOfSystem[1][0] * Math.pow(x[i], resultOfSystem[1][1]);
            result[3][i] = result[2][i] - y[i];
        }


        return result;
    }

    public double[][] thirdFunction(double[] x, double[] y, double[][] resultOfSystem) {
        double[][] result = new double[4][x.length];
        for (int i = 0; i < x.length; i++) {
            result[0][i] = x[i];
            result[1][i] = y[i];
        }
        for (int i = 0; i < y.length; i++) {
            result[2][i] = resultOfSystem[2][0] * Math.pow(Math.E, resultOfSystem[2][1] * x[i]);
            result[3][i] = result[2][i] - y[i];
        }


        return result;
    }

    public double[][] fourthFunction(double[] x, double[] y, double[][] resultOfSystem) {
        double[][] result = new double[4][x.length];
        for (int i = 0; i < x.length; i++) {
            result[0][i] = x[i];
            result[1][i] = y[i];
        }
        for (int i = 0; i < y.length; i++) {
            result[2][i] = resultOfSystem[3][0] * Math.log(x[i]) + resultOfSystem[3][1];
            result[3][i] = result[2][i] - y[i];
        }

        return result;
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

    private double sumX_3(double[] x) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += Math.pow(x[i], 3);
        }
        return sum;
    }

    private double sumX_4(double[] x) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += Math.pow(x[i], 4);
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

    private static double sum_x_2_y(double[] x, double[] y) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += Math.pow(x[i], 2) * y[i];
        }
        return sum;
    }

    private static double sum_x_ln(double[] x) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] != 0)
                sum += Math.log(x[i]);
        }
        return sum;
    }

    private static double sum_x_2_ln(double[] x) {
        double sum = 0;
        for (double v : x) {
            if (v != 0)
                sum += Math.pow(Math.log(v), 2);
        }
        return sum;
    }

    private static double sum_x_y_ln(double[] x, double[] y) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] != 0 && y[i] != 0)
                sum += Math.log(x[i]) * Math.log(y[i]);
        }
        return sum;
    }

    private static double sum_y_ln(double[] y) {
        double sum = 0;
        for (int i = 0; i < y.length; i++) {
            if (y[i] != 0)
                sum += Math.log(y[i]);
        }
        return sum;
    }

    private static double sum_y_ln_x(double[] x, double[] y) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            if (y[i] != 0)
                sum += Math.log(y[i]) * x[i];
        }
        return sum;
    }

    private static double sum_x_ln_y(double[] x, double[] y) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] != 0)
                sum += Math.log(x[i]) * y[i];
        }
        return sum;
    }
}
