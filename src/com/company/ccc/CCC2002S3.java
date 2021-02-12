package com.company.ccc;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class CCC2002S3 {
    static int[][] matrix;
    static char[] commands;
    static int[][] forwardValues = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int r, c;
        r = input.nextInt();
        c = input.nextInt();
        matrix = new int[r][c];
        String row;
        for (int i = 0; i < r; i++) {
            row = input.next();
            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == '.') {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 1;
                }
            }
        }
        int m = input.nextInt();
        commands = new char[m];
        for (int i = 0; i < m; i++) {
            commands[i] = input.next().charAt(0);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                processPosition(i, j);
            }
        }

        for (int[] currentRow: matrix) {
            for (int num: currentRow) {
                switch (num) {
                    case 0:
                        System.out.print(".");
                        break;
                    case 1:
                        System.out.print("X");
                        break;
                    case 2:
                        System.out.print("*");
                        break;
                }
            }
            System.out.println();
        }
    }

    static void processPosition(int i, int j) {
        if (matrix[i][j] == 1) {
            return;
        } else {
            for (int forwardValuesIndex = 0; forwardValuesIndex < forwardValues.length; forwardValuesIndex++) {
                processPosition(i, j, forwardValuesIndex);
            }
        }
    }

    static void processPosition(int i, int j, int forwardIndex) {
        int xPrime = j;
        int yPrime = i;
        for (int k = 0; k < commands.length; k++) {
            switch (commands[k]) {
                case 'F':
                    yPrime += forwardValues[forwardIndex][1];
                    xPrime += forwardValues[forwardIndex][0];
                    break;
                case 'R':
                    forwardIndex = (forwardIndex + 1) % forwardValues.length;
                    break;
                case 'L':
                    if (forwardIndex - 1 >= 0) {
                        forwardIndex = (forwardIndex - 1) % forwardValues.length;
                    } else {
                        forwardIndex = forwardValues.length - 1;
                    }
                    break;
            }
            if (yPrime > matrix.length - 1 || xPrime > matrix[0].length - 1 || yPrime < 0 || xPrime < 0 || matrix[yPrime][xPrime] == 1) {
                return;
            }
        }
        matrix[yPrime][xPrime] = 2;
    }
}
