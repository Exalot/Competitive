package com.company.ccc;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CCC2007J5 {
    static int A;
    static int B;
    static long[] locations;
    static long greatestDistance;
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        A = input.nextInt();
        B = input.nextInt();
        final int N = input.nextInt();
        String[] stringItems = "0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000".split(", ");
        locations = new long[stringItems.length+N];
        greatestDistance = 0;
        for (int i = 0; i < stringItems.length; i++) {
            locations[i] = Integer.parseInt(stringItems[i]);
        }
        if (N != 0) {
            for (int i = 0; i < N; i++) {
                locations[stringItems.length+i] = input.nextInt();
            }
        }
        Arrays.sort(locations);
        System.out.println(Arrays.toString(locations));
        for (int i = 1; i < locations.length; i++) {
            long distance = locations[i] - locations[i - 1];
            if (distance > greatestDistance) {
                greatestDistance = distance;
            }
        }
        if (greatestDistance > B) {
            System.out.println(0);
        } else {
            System.out.println(getResults(0));
        }
    }

    public static int getResults(int initIndex) {
        int result = 0;
        boolean doneIteration = false;
        ArrayList<Integer> possibleEndLocations = new ArrayList<>();
        for (int i = initIndex; i < locations.length - 1 && !doneIteration; i++) {
            /*
            int j = i + 1;
            boolean isInValidRange = locations[j] - locations[i] <= A;
            while ((locations[j] - locations[i] <= B && locations[j] - locations[i] >= A) || (locations[j] - locations[i] <= A && !isInValidRange)) {
                if (locations[j] - locations[i] >= A) {
                    possibleEndLocations.add(j);
                    // System.out.println(possibleEndLocations);
                }
                j++;
                if (j == locations.length) {
                    break;
                }
                if (j >= 1 && !isInValidRange) {
                    if (locations[j] - locations[j-1] <= A) {
                        isInValidRange = true;
                    }
                }
            }
            */
            possibleEndLocations = getEndLocations(initIndex);
            if (possibleEndLocations.size() == 0) {
                return 0;
            } else if (possibleEndLocations.size() == 1) {
                possibleEndLocations.clear();
            } else {
                doneIteration = true;
            }
        }
        if (possibleEndLocations.size() > 1) {
            for (int possiblePath: possibleEndLocations) {
                int pathResult = getResults(possiblePath);
                result += pathResult;
                System.out.println(possiblePath + " " + pathResult);
            }
        } else {
            result = 1;
        }
        return result;
    }

    public static ArrayList<Integer> getEndLocations(int currentIndex) {
        ArrayList<Integer> possibleEndLocations = new ArrayList<>();
        int firstValidIndex = -1, lastValidIndex = -1;
        boolean done = false;
        int currentEndIndex = currentIndex + 1;
        while (!done) {
            long distance = locations[currentEndIndex] - locations[currentIndex];
            if (distance <= B && distance >= A) {
                if (firstValidIndex == -1) {
                    firstValidIndex = currentEndIndex;
                }
            } else if (distance >= A && lastValidIndex == -1) {
                lastValidIndex = currentEndIndex - 1;
                done = true;
            }
            currentEndIndex++;
            if (currentEndIndex == locations.length) {
                done = true;
                if (lastValidIndex == -1) {
                    if (firstValidIndex != -1) {
                        lastValidIndex = currentEndIndex-1;
                    }
                }
            }
        }
        if (firstValidIndex == -1) {
            return possibleEndLocations;
        }
        else {
            for (int i = firstValidIndex; i <= lastValidIndex; i++) {
                possibleEndLocations.add(i);
            }
        }
        return possibleEndLocations;
    }
}
