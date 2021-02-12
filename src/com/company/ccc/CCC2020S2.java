package com.company.ccc;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;

public class CCC2020S2 {
    static int m;
    static int n;
    static int[][] matrix;
    static HashMap<Integer, ArrayList<int[]>> map;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        m = input.nextInt();
        n = input.nextInt();
        matrix = new int[m][n];
        map = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i-1][j-1] = input.nextInt();
                if (!map.containsKey(i*j)) {
                    ArrayList<int[]> values = new ArrayList<>();
                    values.add(new int[] {i, j});
                    map.put(i*j, values);
                }
                else {
                    map.get(i*j).add(new int[] {i, j});
                }
            }
        }
        if (check()) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }
    }

    public static boolean check() {
        boolean done = false;
        int[] currentVertex = {1, 1};
        int currentValue = matrix[0][0];
        ArrayList<int[]> list = new ArrayList<>();
        if (map.containsKey(currentValue)) {
            for (int[] vertex : map.get(currentValue)) {
                if (!list.contains(vertex)) {
                    list.add(vertex);
                    if (check(vertex, list)) {
                        return true;
                    }
                    list.remove(vertex);
                }
            }
        }
        return false;
    }
    
    public static boolean check(int[] currentVertex, ArrayList<int[]> list) {
        if (currentVertex[0] == m && currentVertex[1] == n) {
            return true;
        }
        int currentValue = matrix[currentVertex[0]-1][currentVertex[1]-1];
        if (map.containsKey(currentValue)) {
            for (int[] vertex : map.get(currentValue)) {
                if (!list.contains(vertex)) {
                    list.add(vertex);
                    if (check(vertex, list)) {
                        return true;
                    }
                }
                list.remove(vertex);
            }
        }
        return false;
    }
}
