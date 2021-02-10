package com.company.ccc;

import com.company.essentials.Input;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JoshBaconDeluxeTopDown {
    static int N;
    static int[] M;
    static HashMap<Integer, Double> probMap = new HashMap<Integer, Double>();

    public static void main(String[] args) throws IOException {
        readData();
        double prob = solve(M, 0);
        System.out.println(prob);
    }

    private static void readData() throws IOException{
        Input input = new Input("file/2020/s5/s5.2-02.in");
        N = input.readInt();
        M = new int[N];
        for (int i = 0; i < M.length; i++)
            M[i] = input.readInt();
    }

    private static double solve(int[] m, int startIndex) {
        if (m.length == 2) {
            if (m[0] == m[1])
                return 1;
            else
                return 0.5;
        }
        int coach = m[0];
        int josh = m[m.length -1];
        if (coach == josh) return 1;

        HashMap<Integer, Integer> countValueMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> lastPositionMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < m.length; i++) {
            if (countValueMap.containsKey(m[i])) {
                countValueMap.put(m[i], countValueMap.get(m[i])+1);
            }else {
                countValueMap.put(m[i], 1);
            }
            if (i < m.length -1) lastPositionMap.put(m[i], i);
        }

        double prob = 0.0;
        for (Map.Entry<Integer, Integer> entry: countValueMap.entrySet()) {

            if (entry.getKey() == coach) {
                prob += (double)entry.getValue() / m.length;
            } else if (entry.getKey() == josh && entry.getKey() != coach) {
                prob += 0;
            } else {
                int index = lastPositionMap.get(entry.getKey());
                int[] subarr = new int[m.length - index];
                System.arraycopy(m, index, subarr, 0, m.length - index);
                subarr[0] = coach;
                if (!probMap.containsKey(index + startIndex)) {
                    probMap.put(index + startIndex, solve(subarr, index + startIndex));
                }
                //prob += (double)entry.getValue()/m.length *  solve(subarr);
                prob += (double)entry.getValue()/m.length * probMap.get(index + startIndex);
            }
        }
        return prob;
    }
}
