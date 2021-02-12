package com.company.ccc;

import java.util.Scanner;
import java.util.LinkedList;

public class CCC2016S4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        LinkedList<Integer> riceBalls = new LinkedList<>();
        int maxRiceBall = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            riceBalls.add(input.nextInt());
            if (riceBalls.getLast() > maxRiceBall)
                maxRiceBall = riceBalls.getLast();
        }
        while (!EndOfCombining(riceBalls)) {
            if (riceBalls.size() >= 3) {
                for (int i = 0; i < riceBalls.size() - 2; i++) {
                    if (riceBalls.get(i).equals(riceBalls.get(i + 1))) {
                        riceBalls.add(i, riceBalls.get(i) * 2);
                        riceBalls.remove(i + 1);
                        riceBalls.remove(i + 1);
                        if (riceBalls.get(i) > maxRiceBall)
                            maxRiceBall = riceBalls.get(i);
                    } else if (riceBalls.get(i + 1).equals(riceBalls.get(i + 2))) {
                        riceBalls.add(i + 1, riceBalls.get(i + 1) * 2);
                        riceBalls.remove(i + 2);
                        riceBalls.remove(i + 2);
                        if (riceBalls.get(i + 1) > maxRiceBall)
                            maxRiceBall = riceBalls.get(i + 1);
                    } else if (riceBalls.get(i).equals(riceBalls.get(i + 2))) {
                        riceBalls.add(i, riceBalls.get(i) * 2 + riceBalls.get(i + 1));
                        if (riceBalls.get(i) > maxRiceBall)
                            maxRiceBall = riceBalls.get(i);
                        riceBalls.remove(i + 1);
                        riceBalls.remove(i + 1);
                        riceBalls.remove(i + 1);
                    }
                }
            }
            else {
                riceBalls.add(0, riceBalls.getFirst() * 2);
                riceBalls.removeLast();
                riceBalls.removeLast();
                maxRiceBall = riceBalls.getFirst();
            }
        }
        System.out.println(maxRiceBall);
    }

    public static boolean EndOfCombining(LinkedList<Integer> riceBalls) {
        if (riceBalls.size() >= 3) {
            for (int i = 0; i < riceBalls.size() - 2; i++) {
                if (riceBalls.get(i).equals(riceBalls.get(i + 1)) || riceBalls.get(i).equals(riceBalls.get(i + 2)) || riceBalls.get(i + 1).equals(riceBalls.get(i + 2))) {
                    return false;
                }
            }
        }
        else if (riceBalls.size() == 2) {
            return !riceBalls.get(0).equals(riceBalls.get(1));
        }
        return true;
    }
}
