package com.company.ccc;
import java.util.Scanner;

public class CCC2019S1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] matrix = new int[2][2];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[1][0] = 3;
        matrix[1][1] = 4;

        String commands = input.next();
        int hCount = 0;
        int vCount = 0;

        for (int i = 0; i < commands.length(); i++) {
            if (commands.charAt(i) == 'H') {
                hCount++;
            }
            else {
                vCount++;
            }
        }

        int[][] newMatrix = new int[2][2];
        int[][] finalMatrix = new int[2][2];

        /*
        if (hCount % 2 == 1) {
        }
         */
    }
}