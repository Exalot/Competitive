package com.company.ccc;

import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class CCC2016S2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int question = input.nextInt();
        int n = input.nextInt();
        int[] speed1 = new int[n];
        int[] speed2 = new int[n];
        for (int i = 0; i < n; i++) {
            speed1[i] = input.nextInt();
        }
        for (int i = 0; i < n; i++) {
            speed2[i] = input.nextInt();
        }
        Arrays.sort(speed1);
        Arrays.sort(speed2);
        if (question == 1) {
            System.out.println(getMinSpeed(speed1, speed2));
        }
        else {
            System.out.println(getMaxSpeed(speed1, speed2));
        }
    }

    public static int getMinSpeed(int[] speed1, int[] speed2) {
        int totalSpeed = 0;
        for (int i = 0; i < speed1.length; i++) {
            totalSpeed += Math.max(speed1[i], speed2[i]);
        }
        return totalSpeed;
    }

    public static int getMaxSpeed(int[] speed1, int[] speed2) {
        int totalSpeed = 0;
        for (int i = 0; i < speed1.length; i++) {
            totalSpeed += Math.max(speed1[i], speed2[speed2.length-1-i]);
        }
        return totalSpeed;
    }
}
