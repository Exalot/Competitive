package com.company.lcc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class LCC20181S3 {
    static char[] characters;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        characters = input.next().toCharArray();
        ArrayList<Character> arrayList = new ArrayList<>();
        int largestNum = 0;
        char[] half1, half2;
        HashMap<Character, Integer> map1, map2;
        if (n % 2 == 0) {
            for (int size = n; size > 0; size -= 2) {
                for (int start = 0; start + size <= n; start++) {
                    half1 = getCharArray(start, start + size/2);
                    half2 = getCharArray(start + size/2, start + size);
                    /*
                    map1 = getCharacterMap(half1);
                    map2 = getCharacterMap(half2);
                    if (map1.equals(map2) && half1.length * 2 > largestNum)
                        largestNum = half1.length + half2.length;
                     */
                    Arrays.sort(half1);
                    Arrays.sort(half2);
                    System.out.println(Arrays.toString(half1) + " " + Arrays.toString(half2) + " " + Arrays.equals(half1, half2));
                    if (Arrays.equals(half1, half2) && half1.length * 2 > largestNum)
                        largestNum = half1.length + half2.length;
                }
            }
        }
        else {
            for (int size = n-1; size > 0; size -= 2) {
                for (int start = 0; start + size <= n; start++) {
                    half1 = getCharArray(start, start + size/2);
                    half2 = getCharArray(start + size/2, start + size);
                    /*
                    map1 = getCharacterMap(half1);
                    map2 = getCharacterMap(half2);
                    if (map1.equals(map2) && half1.length * 2 > largestNum)
                        largestNum = half1.length + half2.length;
                     */
                    Arrays.sort(half1);
                    Arrays.sort(half2);
                    System.out.println(Arrays.toString(half1) + " " + Arrays.toString(half2) + " " + Arrays.equals(half1, half2));
                    if (Arrays.equals(half1, half2) && half1.length * 2 > largestNum)
                        largestNum = half1.length + half2.length;
                }
            }
        }
        System.out.println(largestNum);
    }

    public static char[] getCharArray(int start, int finish) {
        char[] subValues = new char[finish - start];
        for (int i = start; i < finish; i++) {
            subValues[i - start] = characters[i];
        }
        return subValues;
    }

    public static HashMap<Character, Integer> getCharacterMap(char[] characters) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: characters) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        return map;
    }
}
