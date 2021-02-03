package com.company.ccc;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class CCC2004J4 {
    public static void main(String[] args) {
        HashMap<Character, Integer> valuesMap = new HashMap<>();
        HashMap<Integer, Character> numbersMap = new HashMap<>();
        char[] keys = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int i = 0; i < keys.length; i++) {
            valuesMap.put(keys[i], i);
            numbersMap.put(i, keys[i]);
        }

        Scanner input = new Scanner(new BufferedInputStream(System.in));
        String keyword = input.next();
        input.nextLine();
        String originalMessege = input.nextLine();
        String modifiedMessege = "";
        for (int i = 0; i < originalMessege.length(); i++) {
            if (Character.isAlphabetic(originalMessege.charAt(i))) {
                modifiedMessege += originalMessege.charAt(i);
            }
        }
        char keywordChar, messegeChar;
        int keywordNum, messegeNum;
        String encryptedMessege = "";
        for (int i = 0; i < modifiedMessege.length(); i++) {
            keywordChar = keyword.charAt(i%keyword.length());
            messegeChar = modifiedMessege.charAt(i);
            keywordNum = valuesMap.get(keywordChar);
            messegeNum = (keywordNum + valuesMap.get(messegeChar)) % 26;
            encryptedMessege += numbersMap.get(messegeNum);
        }
        System.out.println(encryptedMessege);
    }
}
