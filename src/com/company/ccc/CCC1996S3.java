package com.company.ccc;

import javax.management.openmbean.ArrayType;
import java.io.BufferedInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CCC1996S3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int m = input.nextInt();
        int[][] patternInputs = new int[m][2];
        for (int i = 0; i < m; i++) {
            patternInputs[i][0] = input.nextInt();
            patternInputs[i][1] = input.nextInt();
        }
        for (int[] pattern: patternInputs) {
            processPattern(pattern[0], pattern[1]);
        }
    }
    public static void processPattern(int n, int k) {
        System.out.println("The bit patterns are");
        ArrayList<int[]> patterns = getPatterns(n, k);
        int[] pattern;
        for (int i = patterns.size()-1; i >= 0; i--) {
            pattern = patterns.get(i);
            for (int digit: pattern) {
                System.out.print(digit);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static ArrayList<int[]> getPatterns(int n, int k) {
        ArrayList<int[]> patterns = new ArrayList<>();
        int[] binary;
        for (int i = 0; i < Math.pow(2, n); i++) {
            binary = getBinary(i, n);
            if (isValid(binary, k)) {
                patterns.add(binary);
            }
        }
        return patterns;
    }

    public static boolean isValid(int[] binary, int k) {
        int onesCount = 0;
        for (int digit: binary) {
            if (digit == 1) {
                onesCount++;
            }
        }
        return onesCount == k;
    }

    public static int[] getBinary(int number, int length) {
        int power = 1;
        while (Math.pow(2, power) <= number) {
            power += 1;
        }
        power -= 1;
        int[] result = new int[length];
        int currentPower = power;
        int remainingNum = number;
        while (remainingNum != 0) {
            if (remainingNum >= Math.pow(2, currentPower)) {
                result[result.length - currentPower - 1] = 1;
                remainingNum -= Math.pow(2, currentPower);
            } else {
                result[result.length - currentPower - 1] = 0;
            }
            currentPower -= 1;
        }
        return result;
    }
}
