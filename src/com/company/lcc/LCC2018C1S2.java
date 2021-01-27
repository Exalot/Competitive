package com.company.lcc;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class LCC2018C1S2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int result = 0;
        int n = input.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = input.nextInt();
        }
        Arrays.sort(values);
        if (n % 2 == 0) {
            for (int i = 0; i < n; i+=2) {
                result += values[i] * values[i+1];
            }
        }
        else {
            for (int i = 1; i < n; i+=2) {
                result += values[i] * values[i+1];
            }
        }
        System.out.println(result);
    }
}
