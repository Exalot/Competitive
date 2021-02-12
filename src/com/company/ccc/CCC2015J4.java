package com.company.ccc;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CCC2015J4 {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> messegesMap = new HashMap<>();
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int m = input.nextInt();
        int currentTime = 0;
        String type;
        int friend;
        for (int i = 0; i < m; i++) {
            type = input.next();
            friend = input.nextInt();
            switch (type) {
                case "R":
                    if (!messegesMap.containsKey(friend)) {
                        messegesMap.put(friend, new ArrayList<>());
                    }
                    messegesMap.get(friend).add(currentTime);
                    currentTime += 1;
                    break;
                case "S":
                    messegesMap.get(friend).add(-currentTime);
                    currentTime += 1;
                    break;
                case "W":
                    currentTime += friend - 1;
                    break;
            }
        }
        int sentTime = 0;
        int recievedTime = 0;
        int delayTime = 0;
        boolean isWaiting = true;
        ArrayList<Integer> currentArray;
        for (int friendNum: messegesMap.keySet()) {
            currentArray = messegesMap.get(friendNum);
            for (int i = 0; i < currentArray.size(); i++) {
                if (i == 0) {
                    recievedTime = currentArray.get(i);
                    isWaiting = true;
                }
                else {
                    if (currentArray.get(i) >= 0 && !isWaiting) {
                        recievedTime = currentArray.get(i);
                        isWaiting = true;
                    } else if (currentArray.get(i) < 0 && isWaiting) {
                        sentTime = Math.abs(currentArray.get(i));
                        delayTime += sentTime - recievedTime;
                        isWaiting = false;
                    }
                }
            }
            if (isWaiting) {
                delayTime = -1;
            }
            System.out.println(friendNum + " " + delayTime);
        }
    }
}