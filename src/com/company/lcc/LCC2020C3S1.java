package com.company.lcc;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class LCC2020C3S1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int n = input.nextInt();
        String voteStr = input.next();
        HashMap<Character, Integer> votes = new HashMap<>();
        Character currentVote = voteStr.charAt(0);
        if (!votes.containsKey(currentVote)) {
            votes.put(currentVote, 1);
        }
        for (int i = 1; i < n; i++) {
            currentVote = voteStr.charAt(i);
            if (!currentVote.equals(voteStr.charAt(i-1))) {
                if (!votes.containsKey(currentVote)) {
                    votes.put(currentVote, 0);
                }
                votes.put(currentVote, votes.get(currentVote) + 1);
            }
        }
        for (char candidate: votes.keySet()) {
            System.out.println(candidate + " " + votes.get(candidate));
        }
    }
}
