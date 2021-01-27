package com.company.lcc;

import java.util.Scanner;

public class LCC2018C1J4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        if (getResult(num))
            System.out.println("You will win!");
        else
            System.out.println("You will lose!");
    }

    public static boolean getResult(int num) {
        if (num % 5 == 1 || num % 5 == 2 || num % 5 == 3) {
            return true;
        }
        return false;
    }
}
