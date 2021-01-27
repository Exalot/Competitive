package com.company.lcc;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class LCC2019C1J4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int n = input.nextInt();
        int s = input.nextInt();
        int q = input.nextInt();
        int secPerView;
        int[][] views = new int[n][2];
        for (int i = 0; i < n; i++) {
            views[i][0] = 0;
            views[i][1] = 0;
        }
        int t, v, x;
        for (int i = 0; i < q; i++) {
            t = input.nextInt();
            v = input.nextInt() - 1;
            x = input.nextInt();
            secPerView = t/x;
            views[v][0] += x;
            if (secPerView <= s) {
                views[v][1] += x;
            }
        }
        for (int i = 0; i < n; i++) {
            if (views[i][1] == 0)
                System.out.print(-1 + " ");
            else
                System.out.print(views[i][1] + " ");
        }
    }
}
