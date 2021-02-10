package com.company.lcc;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class LCC2020C3S2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int n = input.nextInt();
        int k = input.nextInt();
        int q =     input.nextInt();
        boolean[] bucketsFull = new boolean[n];
        for (int i = 0; i < n; i++) {
            bucketsFull[i] = false;
        }
        int[] buckets = new int[n];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = 0;
        }
        int a, b, c;
        for (int i = 0; i < q; i++) {
            a = input.nextInt();
            b = input.nextInt();
            c = input.nextInt();
            for (int j = a-1; j <= b-1; j++) {
                if (!bucketsFull[j]) {
                    buckets[j] += c;
                    if (buckets[j] >= k) {
                        bucketsFull[j] = true;
                        buckets[j] = i+1;
                    }
                }
            }
        }
        for (int i = 0; i < buckets.length; i++) {
            if (!bucketsFull[i]) {
                buckets[i] = -1;
            }
        }
        System.out.print(buckets[0]);
        for (int i = 1; i < buckets.length; i++) {
            System.out.print(" " + buckets[i]);
        }
    }
}
