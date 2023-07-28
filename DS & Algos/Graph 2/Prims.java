import java.util.*;

class Prims {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int noV = input.nextInt();
        int noE = input.nextInt();

        int adjMat[][] = new int[noV][noV];

        for (int i = 0; i < noE; i++) {
            int v1 = input.nextInt();
            int v2 = input.nextInt();
            int weight = input.nextInt();
            adjMat[v1][v2] = weight;
            adjMat[v2][v1] = weight;
        }
        prims(adjMat);
    }

    private static void prims(int[][] adjMat) {
        int noV = adjMat.length;
        boolean[] visited = new boolean[noV];
        int[] weight = new int[noV];
        int[] parent = new int[noV];

        weight[0] = 0;
        parent[0] = -1;

        // lets put the weight infinity
        for (int i = 1; i < noV; i++) {
            weight[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < noV; i++) {
            // pick vertex with min weight
            int minV = findMinVertex(weight , visited);

        }
    }

    private static int findMinVertex(int[] weight, boolean[] visited) {
        return 0;
    }
}
