package com.company.mcpt;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class DifferenceArray {
    static int[][] matrix;
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int n = input.nextInt();
        int q = input.nextInt();
        matrix = new int[n][n];
        for (int[] row : matrix) {
            Arrays.fill(row, 0);
        }
        int[] inputArray;
        int type, x1, y1, x2, y2, v;
        for (int i = 0; i < q; i++) {
            type = input.nextInt();
            if (type == 1) {
                x1 = input.nextInt();
                y1 = input.nextInt();
                x2 = input.nextInt();
                y2 = input.nextInt();
                v = input.nextInt();
                updateMatrix(x1, y1, x2, y2, v);
            } else {
                x1 = input.nextInt();
                y1 = input.nextInt();
                System.out.println(matrix[y1 - 1][x1 - 1]);
            }
        }
    }

    public static void updateMatrix(int x1, int y1, int x2, int y2, int v) {
        for (int i = Math.min(y1, y2) - 1; i <= Math.max(y1, y2) - 1; i++) {
            for (int j = Math.min(x1, x2) - 1; j <= Math.max(x1, x2) - 1; j++) {
                matrix[i][j] += v;
                //
            }
        }
    }
}
