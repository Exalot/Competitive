package com.company.ccc;

import java.util.Scanner;
import java.util.HashMap;

public class CCC2016S1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String input1 = input.next();
        String input2 = input.next();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        Character currentChar;
        for (int i = 0; i < input1.length(); i++) {
            currentChar = input1.charAt(i);
            if (map1.containsKey(currentChar)) {
                map1.put(currentChar, map1.get(currentChar) + 1);
            }
            else {
                map1.put(currentChar, 1);
            }
            currentChar = input2.charAt(i);
            if (map2.containsKey(currentChar)) {
                map2.put(currentChar, map2.get(currentChar) + 1);
            }
            else {
                map2.put(currentChar, 1);
            }
        }
        int charDifference = 0;
        int starsNum = map2.getOrDefault('*', 0);
        for (Character c: map1.keySet()) {
            if (c != '*') {
                charDifference += map1.get(c) - map2.get(c);
            }
        }
        if (charDifference == starsNum)
            System.out.println("A");
        else {
            System.out.println("N");
        }
    }
}
