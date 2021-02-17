package com.company.ccc;

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;

public class CCC2020S4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        String str = input.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('B', 0);
        map.put('C', 0);
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
        }
        int[] results = new int[6];
        char[][] possibilities = {{'A','B','C'}, {'A', 'C', 'B'}, {'B', 'A', 'C'}};
        int index = 0;
        for (char[] possibility: possibilities) {
            results[index] = findTotalSwaps(possibility, map, str, true);
            index++;
            results[index] = findTotalSwaps(possibility, map, str, false);
            index++;
        }
        Arrays.sort(results);
        System.out.println(results[0]);

    }

    public static int findMismatched(char desiredChar, char[] charArray) {
        int mismatched = 0;
        for (char character: charArray) {
            if (character != desiredChar)
                mismatched++;
        }
        return mismatched;
    }

    public static int findTotalSwaps(char[] setups, HashMap<Character, Integer> map, String seats, boolean lastModified) {
        if (!lastModified) {
            char[] char1setUp = new char[map.get(setups[0])];
            for (int i = 0; i < map.get(setups[0]); i++) {
                char1setUp[i] = seats.charAt(i);
            }
            char[] char2setUp = new char[map.get(setups[1])];
            int j = 0;
            for (int i = map.get(setups[0]); i < map.get(setups[0]) + map.get(setups[1]); i++) {
                char2setUp[j] = seats.charAt(i);
                j++;
            }
            j = 0;
            char[] char3setUp = new char[map.get(setups[2])];
            for (int i = map.get(setups[0]) + map.get(setups[1]); i < map.get(setups[0]) + map.get(setups[1]) + map.get(setups[2]); i++) {
                char3setUp[j] = seats.charAt(i);
                j++;
            }
            return (findMismatched(setups[0], char1setUp) + findMismatched(setups[1], char2setUp) + findMismatched(setups[2], char3setUp)) / 2;
        }
        else {
            char[] char1setUp = new char[map.get(setups[0]) + 1];
            char1setUp[0] = seats.charAt(seats.length() - 1);
            for (int i = 0; i < map.get(setups[0]) - 1; i++) {
                char1setUp[i+1] = seats.charAt(i);
            }
            char[] char2setUp = new char[map.get(setups[1])];
            int j = 0;
            for (int i = map.get(setups[0]) - 1; i < map.get(setups[0]) + map.get(setups[1]) - 1; i++) {
                char2setUp[j] = seats.charAt(i);
                j++;
            }
            j = 0;
            char[] char3setUp = new char[map.get(setups[2])];
            for (int i = map.get(setups[0]) + map.get(setups[1]) - 1; i < map.get(setups[0]) + map.get(setups[1]) + map.get(setups[2]) - 1; i++) {
                char3setUp[j] = seats.charAt(i);
                j++;
            }
            return (findMismatched(setups[0], char1setUp) + findMismatched(setups[1], char2setUp) + findMismatched(setups[2], char3setUp)) / 2;
        }
    }

}
