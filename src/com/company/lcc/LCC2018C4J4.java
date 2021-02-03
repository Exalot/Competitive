package com.company.lcc;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class LCC2018C4J4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int n = input.nextInt();
        String[] codes = new String[n];
        int results = 0;
        for (int i = 0; i < n; i++) {
            codes[i] = input.next();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (conflictsPrefix(codes[i], codes[j]) || codes[i].equals(codes[j])) {
                        results += 1;
                    }
                }
            }
        }
        System.out.println(results);
    }

    public static boolean conflictsPrefix(String code1, String code2) {
        for (int i = 2; i <= Math.min(19, Math.min(code1.length(), code2.length())); i++) {
            if (code1.startsWith(code2.substring(0, i))) {
                return true;
            }
        }
        return false;
    }
}
