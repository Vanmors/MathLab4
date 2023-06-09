package com.example.lab4spring.Solution;

public class GaussMethod {
    public double[] startMethod(double[][] a, int n) {

        double[] answer = new double[n];

        for (int x_del = 0; x_del < n - 1; x_del++) {
            for (int i = x_del + 1; i < n; i++) {
                double coefficient = (-1) * (a[i][x_del] / a[x_del][x_del]);
                for (int j = x_del; j < n + 1; j++) {
                    a[i][j] += a[x_del][j] * coefficient;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            double asw = a[i][n];
            for (int j = n - 1; j >= 0; j--) {
                if (i != j) {
                    asw = asw - a[i][j] * answer[j];
                } else {
                    asw = asw / a[i][j];
                    answer[j] = asw;
                    break;
                }
            }
        }
//        if (n == 4){
//            answer[0] = 1;
//            answer[1] = 1;
//            answer[2] = 1;
//            answer[3] = 1;
//            return answer;
//        }
        return answer;
    }
}
