package com.company.ccc;

import com.company.essentials.Graph;
import java.util.*;

public class CCC2016S3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, m;
        n = input.nextInt();
        m = input.nextInt();
        int[] phoRestaurants = new int[m];
        Graph<Integer> graph = new Graph<>();
        for (int i = 0; i < n; i++) {
            graph.addVertex(i);
        }
        for (int i = 0; i < m; i++) {
            phoRestaurants[i] = input.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            graph.addEdge(input.nextInt(), input.nextInt(), 1);
        }
        Graph<Integer> finalGraph = new Graph<>();
        for (int i : phoRestaurants) {
            finalGraph.addVertex(i);
        }
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++)
                finalGraph.addEdge(phoRestaurants[i], phoRestaurants[j], Graph.getMinDistance(graph.minimumDistance(phoRestaurants[i], phoRestaurants[j])));
        }
        Graph<Integer> minimumDistanceGraph = finalGraph.minimum_spanning_tree();
        int weightSum = minimumDistanceGraph.EdgeWeightSum();
        System.out.println(weightSum);
    }
}
