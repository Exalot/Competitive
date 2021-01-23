package com.company.ccc;

import java.util.Scanner;

public class CCC2016S5 {
    static int n;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        int t = input.nextInt();
        int[][] cycles = new int[t+1][n];
        String str = input.next();
        for (int i = 0; i < n; i++) {
            cycles[0][i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        for (int i = 1; i < t; i++) {
            cycles[i] = nextCycle(cycles[i-1]);
        }
        int[] result = cycles[cycles.length - 1];
        for (int i : result) {
            System.out.print(i);
        }
    }

    public static int[] nextCycle(int[] currentCycle) {
        int[] result = new int[n];

        // Processing index = 0
        if (currentCycle[1] + currentCycle[currentCycle.length - 1] == 2)
            result[0] = 0;
        else if (currentCycle[1] == 1 ^ currentCycle[currentCycle.length - 1] == 1) {
            if (currentCycle[0] == 1) {
                result[0] = 1;
                if (currentCycle[1] == 1)
                    result[currentCycle.length - 1] = 1;
                else
                    result[1] = 1;
            }
            else
                result[0] = 0;
        }
        else {
            result[0] = 0;
            if (currentCycle[0] == 1) {
                result[1] = 1;
                result[result.length - 1] = 1;
            }
        }

        // Processing index = currentCycle.length - 1
        if (currentCycle[currentCycle.length - 2] + currentCycle[0] == 2)
            result[currentCycle.length - 1] = 0;
        else if (currentCycle[currentCycle.length - 2] + currentCycle[0] == 1) {
            if (currentCycle[currentCycle.length - 1] == 1) {
                result[currentCycle.length - 1] = 1;
                if (currentCycle[currentCycle.length - 2] == 1)
                    result[0] = 1;
                else
                    result[currentCycle.length - 2] = 1;
            }
            else
                result[result.length-1] = 0;
        }
        else {
            result[0] = 0;
            if (currentCycle[currentCycle.length-1] == 1) {
                result[0] = 1;
                result[result.length - 2] = 1;
            }
        }

        // Processing Index 1 - currentCycle.length - 2;
        for (int i = 1; i < currentCycle.length - 1; i++) {
            if (currentCycle[i - 1] + currentCycle[i + 1] == 2)
                result[i] = 0;
            else if (currentCycle[i - 1] + currentCycle[i + 1] == 1) {
                if (currentCycle[i] == 1) {
                    result[i] = 1;
                    if (currentCycle[i - 1] == 1)
                        result[i + 1] = 1;
                    else
                        result[i - 1] = 1;
                }
                else
                    result[i] = 0;
            }
            else {
                result[i] = 0;
                if (currentCycle[i] == 1) {
                    result[i + 1] = 1;
                    result[i - 1] = 1;
                }
            }
        }

        return result;
    }
}
