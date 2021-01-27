package com.company.lcc;

import java.util.Scanner;

public class LCC2018C2S3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][i] = input.nextInt();
            }
        }
    }
}
