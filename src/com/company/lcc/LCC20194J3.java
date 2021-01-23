package com.company.lcc;

import java.util.Arrays;
import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;

public class LCC20194J3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int DerekPos = 1;
        double[][] times = new double[n][6];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                times[i][j] = input.nextDouble();
            }
            times[i][5] = Double.MAX_VALUE;
            Arrays.sort(times[i]);
            times[i][5] = (times[i][1] + times[i][2] + times[i][3]) / 3;
            if (times[i][5] < times[0][5] - 1)
                DerekPos += 1;
        }
        System.out.println(DerekPos);
    }
}
