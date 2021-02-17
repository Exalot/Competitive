package com.company.jdcc;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedSet;

public class JDCC2015C1P3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int t = input.nextInt();
        int n;
        ArrayList<double[]> candies = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            n = input.nextInt();
            double[] currentClass = new double[n];
            for (int j = 0; j < n; j++) {
                currentClass[j] = input.nextDouble();
            }
            candies.add(currentClass);
        }
        for (double[] classOfCandies: candies) {
            System.out.println(processClass(classOfCandies));
        }
    }

    public static int processClass(double[] classArray) {
        double classAverage = 0;
        for (int i = 0; i < classArray.length; i++) {
            classAverage += classArray[i];
        }
        classAverage = classAverage / classArray.length;
        double difference = 50 - classAverage;
        int result = 0;
        for (int i = 0; i < classArray.length; i++) {
            if (classArray[i] + difference >= 50) {
                result++;
            }
        }
        return result;
    }
}
