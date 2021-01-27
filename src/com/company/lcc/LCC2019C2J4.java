package com.company.lcc;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class LCC2019C2J4 {
    public static void main(String[] args) {
        HashMap<String, Integer> relativeMap = new HashMap<>();
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        String currentInput;
        int n = input.nextInt();
        for (String s: new String[]{"U", "D", "L", "R"}) {
            relativeMap.put(s, 0);
        }
        for (int i = 0; i < n; i++) {
            currentInput = input.next();
            relativeMap.put(currentInput, relativeMap.get(currentInput) + 1);
        }
        int xSum = relativeMap.get("L") + relativeMap.get("R");
        int ySum = relativeMap.get("U") + relativeMap.get("D");
        double x, y;
        x = 100.0 * (-relativeMap.get("R") + relativeMap.get("L"))/xSum;
        y = 100.0 * (-relativeMap.get("U") + relativeMap.get("D"))/ySum;
        System.out.println(x);
        System.out.println(y);
    }
}
