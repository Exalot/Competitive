package com.company.jdcc;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class JDCC2015C5P1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            int[] point1 = new int[2];
            int[] point2 = new int[2];
            point1[0] = input.nextInt();
            point1[1] = input.nextInt();
            point2[0] = input.nextInt();
            point2[1] = input.nextInt();
            if (isIntMultiple(point1, point2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean isIntMultiple(int[] point1, int[] point2) {
        if (point1[0] == 0 || point1[1] == 0 || point2[0] == 0 || point2[1] == 0) {
            if (point1[0] == 0 && point1[1] == 0 && point2[0] == 0 && point2[1] == 0) {
                return true;
            } else if (point1[0] == 0 && point2[0] == 0) {
                return point1[1] != 0 && point2[1] != 0;
            } else if (point1[1] == 0 && point2[1] == 0) {
                return point1[0] != 0 && point2[0] != 0;
            }
            return false;
        }
        double n1 = point2[0] / point1[0];
        double n2 = point2[1] / point1[1];
        if (n1 == n2) {
            if (n1 % 1 == 0) {
                return true;
            } else {
                n1 = point1[0] / point2[0];
                n2 = point1[1] / point2[1];
                return n1 % 1 == 0;
            }
        }
        return false;
    }
}
