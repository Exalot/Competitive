package com.company.ccc;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

public class CCC2020S5 {
    static int[] burgers;
    static int uniqueBurgersNum;
    static double[][] probabilityResults;
    static int josh;
    public static void main(String[] args) throws IOException {
        processInput();
        System.out.println(processAllCycles());
        for (double[] row: probabilityResults) {
            for (double num: row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void processInput() throws IOException {
        //Input input = new Input("s5\\s5.1-01.in");
        //int n = input.readInt();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        burgers = new int[n];
        ArrayList<Integer> uniqueBurgers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            burgers[i] = input.nextInt();
            if (!uniqueBurgers.contains(burgers[i]))
                uniqueBurgers.add(burgers[i]);
            //burgers[i] = input.nextInt();
        }
        uniqueBurgersNum = uniqueBurgers.size();
        probabilityResults = new double[n][uniqueBurgersNum];
        josh = burgers[burgers.length - 1];
    }

    public static double processAllCycles() {
        for (int i = burgers.length - 2; i >= 0; i--) {
            for (int j = 0; j < uniqueBurgersNum; j++)
                findProbability(i,j);
        }
        return probabilityResults[0][burgers[0]];
    }

    public static void findProbability(int index, int coach) {
        double probability;
        if (index == burgers.length - 1)
            probability = 1;
        else if (index == burgers.length - 2)
            probability = 0.5;
        else {
            probability = 0;
            int burgersLeft = burgers.length - index;
            HashMap<Integer, Integer> frequencyMap = getFrequencyMap(index);
            HashMap<Integer, Integer> lastIndexMap = getLastIndexMap(index);
            int nextIndex;
            for (Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()) {
                if (entry.getKey() == coach) {
                    probability += (double)entry.getValue() / burgersLeft;
                } else if (entry.getKey() == josh)
                    probability += 0;
                else {
                    nextIndex = lastIndexMap.get(entry.getKey());

                    probability += (double)entry.getValue()/burgersLeft * probabilityResults[nextIndex][entry.getKey()];
                }
            }
        }
        probabilityResults[index][coach] = probability;
    }

    public static HashMap<Integer, Integer> getFrequencyMap(int index) {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = index; i < burgers.length; i++) {
            if (!result.containsKey(burgers[i])) {
                result.put(burgers[i], 1);
            }
            else {
                result.put(burgers[i], result.get(burgers[i]) + 1);
            }
        }
        return result;
    }

    public static HashMap<Integer, Integer> getLastIndexMap(int index) {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = burgers.length-1; i >= index; i--) {
            if (!result.containsKey(burgers[i])) {
                result.put(burgers[i], i);
            }
        }
        return result;
    }

}
