package com.company.ccchk;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class CCCHK2015J3 {
    static boolean[][] matrix;
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int n = input.nextInt();
        int m = input.nextInt();
        matrix = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], true);
        }
        int x, y;
        for (int i = 0; i < m; i++) {
            x = input.nextInt();
            y = input.nextInt();
            processPiece(x, y);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public static void processPiece(int y, int x) {
        y -= 1;
        x -= 1;
        // Horizontal and Vertical
        for (int i = 0; i < matrix.length; i++) {
            matrix[y][i] = false;
            matrix[i][x] = false;
        }
        // Diagonals
        int yPrime = y;
        int xPrime = x;
        // Top Left
        while (yPrime >= 0 && xPrime >= 0) {
            matrix[yPrime][xPrime] = false;
            yPrime--;
            xPrime--;
        }
        // Bottom Right
        yPrime = y;
        xPrime = x;
        while (yPrime < matrix.length && xPrime < matrix.length) {
            matrix[yPrime][xPrime] = false;
            yPrime++;
            xPrime++;
        }
        // Top Right
        yPrime = y;
        xPrime = x;
        while (yPrime >= 0 && xPrime < matrix.length) {
            matrix[yPrime][xPrime] = false;
            yPrime--;
            xPrime++;
        }
        // Bottom Left
        yPrime = y;
        xPrime = x;
        while (xPrime >= 0 && yPrime < matrix.length) {
            matrix[yPrime][xPrime] = false;
            xPrime--;
            yPrime++;
        }
    }
}
