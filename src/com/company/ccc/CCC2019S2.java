package com.company.ccc;

import java.util.Scanner;

public class CCC2019S2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int[] result = new int[2];
        int num;
        for (int i = 0; i < t; i++) {
            num = input.nextInt();
            result = findNumbers(num);
            System.out.println(result[0] + ' ' + result[1]);
        }
    }

    static int[] findNumbers(int result) {
        int[] numbers = new int[2];
        int currentNumber = 3;
        boolean done = false;
        while (!done) {
            while(!isPrime(currentNumber)) {
                currentNumber++;
            }
            for (int j = currentNumber; j <= (result * 2) - currentNumber; j++) {
                if ((currentNumber + j ) / 2 == result) {
                    numbers[0] = currentNumber;
                    numbers[1] = j;
                    done = true;
                }
            }
            currentNumber++;
        }
        return numbers;
    }

    static boolean isPrime(int number) {
        for (int i = 3; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
