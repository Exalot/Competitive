package com.company.dmoj;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class CCCHK2015J4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int L = input.nextInt();
        int N = input.nextInt();
        boolean[] river = new boolean[L];
        Arrays.fill(river, false);
        int s, t;
        for (int i = 0; i < N; i++) {
            s = input.nextInt();
            t = input.nextInt();
            for (int j = s; j < t; j++) {
                river[j] = true;
            }
        }
        int longestSeg = 0;
        int currentSeg = 0;
        for (int i = 0; i < river.length; i++) {
            if (!river[i]) {
                currentSeg++;
            } else {
                if (currentSeg > longestSeg) {
                    longestSeg = currentSeg;
                }
                currentSeg = 0;
            }
        }
        System.out.println(Math.max(longestSeg, currentSeg));
    }
}
