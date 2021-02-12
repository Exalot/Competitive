package com.company.ccc;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;
import java.lang.Math;

public class CCC2020S1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<Float, Float> values = new HashMap<>();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            values.put(input.nextFloat(), input.nextFloat());
        }
        System.out.println(proccess(values));
    }

    public static double proccess(HashMap<Float, Float> values) {
        double fastestVelocity = 0;
        double velocity;
        Float[] times = new Float[values.size()];
        values.keySet().toArray(times);
        Arrays.sort(times);
        for (int index = 0; index < times.length - 1; index++) {
            velocity = Math.abs((values.get(times[index + 1]) - values.get(times[index])) / (times[index + 1] - times[index]));
            if (velocity > fastestVelocity)
                fastestVelocity = velocity;
        }
        return fastestVelocity;
    }
}
