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
        double[][] ABResults = new double[6][4];
        Function function = new Function();

        double sx = sumX(x);
        double sx_3 = sumX_3(x);
        double sx_4 = sumX_4(x);
        double sx_5 = sumX_5(x);
        double sx_6 = sumX_6(x);
        double sy = sumY(y);
        double sxx = sumXX(x);
        double sxy = sumXY(x, y);
        double sx_2y = sum_x_2_y(x, y);
        double sx_3y = sum_x_3_y(x, y);
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
        double[][] matrix6Func = new double[][]{{x.length, sx, sxx, sx_4, sy},
                {sx, sxx, sx_3, sx_4, sxy},
                {sxx, sx_3, sx_4, sx_5, sx_2y},
                {sx_3, sx_4, sx_5, sx_6, sx_3y}};

        double[] resultOfSystem1Func = gaussMethod.startMethod(matrix1Func, 2);
        double[] resultOfSystem5Func = gaussMethod.startMethod(matrix5Func, 3);
        double[] resultOfSystem6Func = gaussMethod.startMethod(matrix6Func, 4);

        ABResults[0][0] = resultOfSystem1Func[0];
        ABResults[0][1] = resultOfSystem1Func[1];


        ABResults[4][0] = resultOfSystem5Func[0];
        ABResults[4][1] = resultOfSystem5Func[1];
        ABResults[4][2] = resultOfSystem5Func[2];


        ABResults[5][0] = resultOfSystem6Func[0];
        ABResults[5][1] = resultOfSystem6Func[1];
        ABResults[5][2] = resultOfSystem6Func[2];
        ABResults[5][3] = resultOfSystem6Func[3];


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
        Function function = new Function();


        if (function.checkMinus(x, y) && function.checkDuplicates(x)) {
            double[][] result = new double[5][x.length];

            double XAverage = 0;
            double YAverage = 0;
            double xx = 0;
            double yy = 0;
            double x2 = 0;
            double y2 = 0;

            for (int i = 0; i < x.length; i++) {
                XAverage += x[i];
                YAverage += y[i];
            }
            XAverage /= x.length;
            YAverage /= y.length;

            for (int i = 0; i < x.length; i++) {
                xx += x[i] - XAverage;
                yy += y[i] - YAverage;
                x2 += Math.pow(x[i] - XAverage, 2);
                y2 += Math.pow(y[i] - YAverage, 2);
            }
            result[4][0] = (xx * yy) / (Math.sqrt(x2 * y2));
            System.out.println(result[4][0]);

            for (int i = 0; i < x.length; i++) {
                result[0][i] = x[i];
                result[1][i] = y[i];
            }
            for (int i = 0; i < y.length; i++) {
                result[2][i] = resultOfSystem[0][0] * x[i] + resultOfSystem[0][1];
                result[3][i] = result[2][i] - y[i];
            }
            if (function.checkNan(result)) {
                return result;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public double[][] fifthFunction(double[] x, double[] y, double[][] resultOfSystem) {
        Function function = new Function();
        double[][] result = new double[4][x.length];
        for (int i = 0; i < x.length; i++) {
            result[0][i] = x[i];
            result[1][i] = y[i];
        }
        for (int i = 0; i < y.length; i++) {
            result[2][i] = resultOfSystem[4][0] * Math.pow(x[i], 2) + resultOfSystem[4][1] * x[i] + resultOfSystem[4][2];
            result[3][i] = result[2][i] - y[i];

        }
        if (function.checkNan(result)) {
            return result;
        } else {
            return null;
        }
    }

    public double[][] secondFunction(double[] x, double[] y, double[][] resultOfSystem) {
        Function function = new Function();
        double[][] result = new double[4][x.length];
        for (int i = 0; i < x.length; i++) {
            result[0][i] = x[i];
            result[1][i] = y[i];
        }
        for (int i = 0; i < y.length; i++) {
            result[2][i] = resultOfSystem[1][0] * Math.pow(x[i], resultOfSystem[1][1]);
            result[3][i] = result[2][i] - y[i];
        }
        if (function.checkNan(result)) {
            return result;
        } else {
            return null;
        }
    }

    public double[][] thirdFunction(double[] x, double[] y, double[][] resultOfSystem) {
        Function function = new Function();
        double[][] result = new double[4][x.length];
        for (int i = 0; i < x.length; i++) {
            result[0][i] = x[i];
            result[1][i] = y[i];
        }
        for (int i = 0; i < y.length; i++) {
            result[2][i] = resultOfSystem[2][0] * Math.pow(Math.E, resultOfSystem[2][1] * x[i]);
            result[3][i] = result[2][i] - y[i];
        }
        if (function.checkNan(result)) {
            return result;
        } else {
            return null;
        }
    }

    public double[][] fourthFunction(double[] x, double[] y, double[][] resultOfSystem) {
        Function function = new Function();
        double[][] result = new double[4][x.length];
        for (int i = 0; i < x.length; i++) {
            result[0][i] = x[i];
            result[1][i] = y[i];
        }
        for (int i = 0; i < y.length; i++) {
            result[2][i] = resultOfSystem[3][0] * Math.log(x[i]) + resultOfSystem[3][1];
            result[3][i] = result[2][i] - y[i];
        }
        if (function.checkNan(result)) {
            return result;
        } else {
            return null;
        }
    }

    public double[][] sixthFunction(double[] x, double[] y, double[][] resultOfSystem) {
        Function function = new Function();
        double[][] result = new double[4][x.length];
        for (int i = 0; i < x.length; i++) {
            result[0][i] = x[i];
            result[1][i] = y[i];
        }
        for (int i = 0; i < y.length; i++) {
            result[2][i] = resultOfSystem[5][0] * Math.pow(x[i], 3) + resultOfSystem[5][1] * Math.pow(x[i], 2)
                    + resultOfSystem[5][2] * x[i] + resultOfSystem[5][3];
            result[3][i] = result[2][i] - y[i];
        }
        if (function.checkNan(result)) {
            return result;
        } else {
            return null;
        }
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

    private double sumX_5(double[] x) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += Math.pow(x[i], 5);
        }
        return sum;
    }

    private double sumX_6(double[] x) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += Math.pow(x[i], 6);
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

    private static double sum_x_3_y(double[] x, double[] y) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += Math.pow(x[i], 3) * y[i];
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
