package com.company.ccc;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class CCC2013J4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int t = input.nextInt();
        int c = input.nextInt();
        int[] chores = new int[c];
        for (int i = 0; i < c; i++) {
            chores[i] = input.nextInt();
        }
        Arrays.sort(chores);
        int result = 0;
        for (int chore: chores) {
            if (result + chore <= t) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}
