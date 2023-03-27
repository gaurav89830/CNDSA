import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

    // DFS Traversal ---------------------------------------------
    public static void print(int[][] edges) {
        boolean[] isVisited = new boolean[edges.length];

        // we did this coz , agar disconnected graph hua toh , ie multiple connected
        // components
        for (int i = 0; i < edges.length; i++) {
            if (!isVisited[i]) {
                // printDFS(edges, isVisited, i);
                printBFS(edges, isVisited, i);
            }

        }
    }

    private static void printDFS(int[][] edges, boolean[] isVisited, int startingVertex) {
        // DFS Depth First Search
        System.out.print(startingVertex + " ");
        isVisited[startingVertex] = true;

        for (int i = 0; i < edges.length; i++) {
            if (edges[startingVertex][i] == 1 && !isVisited[i]) {
                printDFS(edges, isVisited, i);
            }
        }
    }
    // ------------------------------------------------------------

    private static void printBFS(int[][] edges, boolean[] isVisited, int startingVertex) {
        Queue<Integer> storage = new LinkedList<>();
        storage.add(startingVertex);
        isVisited[startingVertex] = true;

        while (!storage.isEmpty()) {
            int front = storage.poll();
            System.out.print(front + " ");
            for (int i = 0; i < edges.length; i++) {
                if (edges[front][i] == 1 && !isVisited[i]) {
                    storage.add(i);
                    isVisited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int nosEdges, nosVertices; // no of
        Scanner input = new Scanner(System.in);
        nosVertices = input.nextInt();
        nosEdges = input.nextInt();

        int edges[][] = new int[nosVertices][nosVertices];

        for (int i = 0; i < nosEdges; i++) {
            int vertex1 = input.nextInt();
            int vertex2 = input.nextInt();

            edges[vertex1][vertex2] = 1;
            edges[vertex2][vertex1] = 1;
        }

        print(edges);
    }
}