package com.company;

import com.company.essentials.Input;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//Dynamic programming bottom to top
public class JoshBaconDeluxe2 {
    static int N;
    static int[] M;
    static HashMap<Integer, Integer> lastPositionMap = new HashMap<Integer, Integer>(); //store last index of value
    static HashMap<Integer, Integer> countValueMap = new HashMap<Integer, Integer>(); //store number of each value
    static double[] prob; //store the probability in each position

    public static void main(String[] args) throws IOException {
        readData();
        System.out.println("Reading Data is Done!!!");
        solve();
        System.out.println(prob[0]);
    }

    private static void readData() throws IOException{
        Input input = new Input("file/2020/s5/s5.3-02.in");
        N = input.readInt();
        M = new int[N];
        for (int i = 0; i < N; i++) {
            M[i] = input.readInt();
            if (i < N -1) lastPositionMap.put(M[i], i);
        }
        prob = new double[N];
        //System.out.println(lastPositionMap);
    }

    private static void solve() {
        int coach = M[0];
        int josh = M[M.length - 1];

        if (coach == josh) {
            prob[0]= 1;
            return;
        }

        //calculating probability for each i
        for (int i = N -1; i >= 0; i--) {
            int currentValue = M[i];

            if (countValueMap.containsKey(coach)) {
                countValueMap.put(coach, countValueMap.get(coach) + 1);
            } else {
                countValueMap.put(coach, 1);
            }
            //calculate probability at i => prob[i]
            if (i == N-1) {
                prob[i] = 1;
            } else {
                int denominator = N - i;
                double probability = 0;
                int lastIndex = 0;
                //System.out.println(countValueMap + " " + denominator);
                for (Map.Entry<Integer, Integer> entry: countValueMap.entrySet()) {
                    //System.out.println(entry.getKey() + " : " + entry.getValue());
                    if (entry.getKey() == coach) {
                        probability += (double)entry.getValue() / denominator;
                    } else if (entry.getKey() == josh)
                        probability += 0;
                    else {
                        lastIndex = lastPositionMap.get(entry.getKey());
                        //System.out.println("LastIndex = "  + lastIndex );
                        //System.out.println("LastIndex = "  +  prob[lastIndex] );
                        probability += (double)entry.getValue()/denominator * prob[lastIndex];
                    }
                    //System.out.println("individual probability = " + probability);
                }

                prob[i] = probability;


            }

            countValueMap.put(coach, countValueMap.get(coach) - 1);
            if (countValueMap.containsKey(currentValue)) {
                countValueMap.put(currentValue, countValueMap.get(currentValue) + 1);
            } else {
                countValueMap.put(currentValue, 1);
            }
            //System.out.println(i + " = " + prob[i]);
        }
    }

}
