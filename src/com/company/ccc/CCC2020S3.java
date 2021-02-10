package com.company.ccc;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class CCC2020S3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String n = input.nextLine();
        String h = input.nextLine();
        ArrayList<String> permutations = new ArrayList<>();
        HashMap<Character, Integer> charMapN = getCharMap(n);
        HashMap<Character, Integer> charMapI;
        String currentPermutation;
        for (int i = 0; i <= h.length() - n.length(); i++) {
            currentPermutation = h.substring(i, i + n.length());
            charMapI = getCharMap(currentPermutation);
            if (charMapI.equals(charMapN)) {
                if (!permutations.contains(currentPermutation)) {
                    permutations.add(currentPermutation);
                }
            }
        }
        System.out.println(permutations.size());
    }

    public static HashMap<Character, Integer> getCharMap(String n) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < n.length(); i++) {
            if (!charMap.containsKey(n.charAt(i))) {
                charMap.put(n.charAt(i), 1);
            }
            else {
                charMap.put(n.charAt(i), charMap.get(n.charAt(i)) + 1);
            }
        }
        return charMap;
    }
}