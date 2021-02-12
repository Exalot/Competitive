package com.company.ccc;

import java.util.*;

public class CCC2016J {
    public static void main(String[] args) {
        //s1();
        //s2();
    }

    static void s1(){
        Scanner input = new Scanner(System.in);
        String s;
        int winCount = 0;
        for (int i = 0; i < 6; i++){
            s = input.nextLine();
            if (s.equals("W"))
                winCount++;
        }

        if (winCount == 0)
            System.out.println(-1);

        else if (winCount <= 2)
            System.out.println(3);

        else if (winCount <= 4)
            System.out.println(2);

        else
            System.out.println(1);
    }

    static void s2() {
        Scanner input = new Scanner(System.in);
        String[] s;
        int num;
        int[][] square = new int[4][4];
        for (int i = 0; i < 4; i++){
            s = input.nextLine().split(" ");
            for (int k = 0; k < 4; k++){
                square[i][k] = Integer.parseInt(s[k]);
            }
        }

        int[] rowSum = getRowsSum(square);
        int[] colSum = getColumnsSum(square);
        if (isMagicSquare(rowSum, colSum)){
            System.out.println("magic");
        }
        else
            System.out.println("not magic");
    }


    static int[] getRowsSum(int[][] square) {
        int rowSum;
        int[] result = new int[4];
        for (int i = 0; i < 4; i++){
            int[] row = square[i];
            rowSum = 0;
            for (int num: row){
                rowSum += num;
            }
            result[i] = rowSum;
        }
        return result;
    }

    static int[] getColumnsSum(int[][] square) {
        int colSum;
        int[] result = new int[4];
        for (int i = 0; i < 4; i++) {
            colSum = 0;
            for (int j = 0; j < 4; j++) {
                colSum += square[j][i];
            }
            result[i] = colSum;
        }
        return result;
    }

    static boolean isMagicSquare(int[] rows, int[] cols){
        for (int row: rows) {
            for (int col: cols) {
                if (rows != cols)
                    return false;
            }
        }
        return true;
    }

    static void s4(){
        Scanner input = new Scanner(System.in);
        String[] s = input.nextLine().split(":");
        int hour = Integer.parseInt(s[0]);
        int min = Integer.parseInt(s[1]);
        System.out.println(calculateArriveTime(hour, min));
    }

    static String calculateArriveTime(int hour, int min){
        if (!encountersTraffic(hour, min)) {
            return Integer.toString(hour + 2) + ":" + Integer.toString(min);
        }
        int timeInMins = calcTimeInMins(hour, min);
        int timeInTraffic;
        if ((timeInMins < calcTimeInMins(10, 0))) {
            if (hour >= 7 && hour <= 8)
                timeInTraffic = calcTimeInMins(2, 0);
            else if (hour > 8)
                timeInTraffic = calcTimeInMins(10,0) - calcTimeInMins(8, 0);
            else
                timeInTraffic = calcTimeInMins(hour + 2, min) - calcTimeInMins(7, 0);
        }
        else{
            if (hour > 15 && hour <= 17)
                timeInTraffic = calcTimeInMins(2, 0);
            else if (hour > 17)
                timeInTraffic = calcTimeInMins(10,0) - calcTimeInMins(8, 0);
            else
                timeInTraffic = calcTimeInMins(hour + 2, min) - calcTimeInMins(7, 0);
        }
        timeInMins += 2 * 60 + timeInTraffic * 0.5;
        return Integer.toString(timeInMins / 60) + ":" + Integer.toString(timeInMins % 60);
    }

    static int calcTimeInMins(int hour, int mins){
        return hour * 60 + mins;
    }

    static boolean encountersTraffic(int hour, int min){
        if (isInTraffic(calcTimeInMins(hour, min)) || isInTraffic(calcTimeInMins(hour + 2, min)))
            return true;
        else
            return false;
    }

    static boolean isInTraffic(int timeInMins){
        if ((timeInMins <= calcTimeInMins(10, 0) && timeInMins > calcTimeInMins(7, 0)) ||
        (timeInMins <= calcTimeInMins(19, 0) && timeInMins > calcTimeInMins(15, 0))){
            return true;
        }
        return false;
    }
}
