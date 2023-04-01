import java.util.*;

class Edge implements Comparable<Edge> {
    int source;
    int destination;
    int weight;

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight; // Accending
    }
}

class Kruskals {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noV = in.nextInt(); // no of nodes / vertices
        int noE = in.nextInt(); // no of edges

        Edge[] input = new Edge[noE];

        for (int i = 0; i < noE; i++) {
            input[i] = new Edge();
            input[i].source = in.nextInt();
            input[i].destination = in.nextInt();
            input[i].weight = in.nextInt();
        }
        // input done

        kruskals(input, noV);
    }

    private static void kruskals(Edge[] input, int noV) {
        Arrays.sort(input);

        Edge[] output = new Edge[noV - 1];
        int[] parent = new int[noV];// for the union find to store parents of vertices
        for (int i = 0; i < noV; i++) {
            parent[i] = i;
        }
        int count = 0; // this will help to store in output
        int i = 0;// this will rep current edge

        while (count != noV - 1) {
            Edge currEdge = input[i];

            // now cycle detection
            // union find

            int sourceParent = UnionFind(currEdge.source, parent);
            int DestinationParent = UnionFind(currEdge.destination, parent);

            if (sourceParent != DestinationParent) {
                output[count] = currEdge;
                count++;

                // now kisi ko bhi kisi ka child bna do
                parent[sourceParent] = DestinationParent;
            }
            i++;
        }

        // done
        // now lets print it
        for (int j = 0; j < noV - 1; j++) {
            if (output[j].source < output[j].destination) {
                System.out.println(output[j].source + " " + output[j].destination + " " + output[j].weight);
            } else {
                System.out.println(output[j].destination + " " + output[j].source + " " + output[j].weight);
            }
        }
    }

    private static int UnionFind(int v, int[] parent) {
        if (v == parent[v]) {
            return v;
        }
        return UnionFind(parent[v], parent);
    }
}
