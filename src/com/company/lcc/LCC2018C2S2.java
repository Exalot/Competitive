package com.company.lcc;

import java.util.HashMap;
import java.util.Scanner;

public class LCC2018C2S2 {
    public static void main(String[] args) {
        int n, m;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        HashMap<String, Integer> traitMap = new HashMap<>();
        String currentTrait;
        int currentTraitWeight;
        for (int i = 0; i < m; i++) {
            currentTrait = input.next();
            currentTraitWeight = input.nextInt();
            traitMap.put(currentTrait, currentTraitWeight);
        }
        String[] currentTraits;
        boolean[] resultArray = new boolean[n];
        int currentReportCredibility;
        for (int i = 0; i < n; i++) {
            currentReportCredibility = 0;
            currentTraits = input.next().split(",");
            for (String trait: currentTraits) {
                if (traitMap.containsKey(trait))
                    currentReportCredibility += traitMap.get(trait);
            }
            resultArray[i] = currentReportCredibility >= 0;
        }
        for (boolean result: resultArray) {
            if (result)
                System.out.println("real");
            else
                System.out.println("false");
        }
    }
}
