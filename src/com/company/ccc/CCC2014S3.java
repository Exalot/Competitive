package com.company.ccc;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.util.*;

public class CCC2014S3 {
    static Scanner input;
    public static void main(String[] args) {
        input = new Scanner(new BufferedInputStream(System.in));
        int t = input.nextInt();
        boolean result;
        for (int i = 0; i < t; i++) {
            result = processRails();
            if (result) {
                System.out.println("\nY");
            } else {
                System.out.println("\nN");
            }
        }
    }

    public static boolean processRails() {
        int n = input.nextInt();
        Deque<Integer> mountain = new ArrayDeque<>();
        Stack<Integer> branch = new Stack<>();
        Deque<Integer> lake = new ArrayDeque<>();
        int currentCar = 1;
        int inputCar;
        for (int j = 0; j < n; j++) {
            inputCar = input.nextInt();
            mountain.add(inputCar);
        }
        while (currentCar <= n) {
            if (mountain.contains(currentCar)) {
                while (mountain.getLast() != currentCar) {
                    branch.push(mountain.pollLast());
                }
                lake.push(mountain.pollLast());
            } else if (branch.contains(currentCar)) {
                if (branch.peek() != currentCar) {
                    return false;
                } else {
                    lake.push(branch.pop());
                }
            }
            currentCar++;
        }
        return true;
    }
}
