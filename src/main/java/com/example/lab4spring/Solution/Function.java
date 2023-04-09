package com.example.lab4spring.Solution;

import java.util.ArrayList;

public class Function {

    public double[] convertXToArray(ArrayList<Integer> points) {
        double[] x = new double[points.size() / 2];
        for (int i = 0; i < points.size() / 2; i++) {
            x[i] = points.get(i);
        }
        return x;
    }

    public double[] convertYToArray(ArrayList<Integer> points) {
        double[] y = new double[points.size() / 2];
        int counter = 0;
        for (int i = points.size() / 2; i < points.size(); i++) {
            y[counter] = points.get(i);
            counter++;
        }
        return y;
    }
}
