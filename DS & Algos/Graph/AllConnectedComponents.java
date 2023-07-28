
// yeh question ajeeb sa hai , mene solve toh sahi kia hai lg rha hai but pta nhi kyu galat aa rha hai testcase kuch , 
import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AllConnectedComponents {

    public static void getConnectedComponents(boolean[][] edges) {
        boolean[] isVisited = new boolean[edges.length];

        for (int i = 0; i < edges.length; i++) {
            if (!isVisited[i]) {
                ArrayList<Integer> ans = new ArrayList<>();
                printBFS(edges, isVisited, i, ans);
                printArraylist(ans);
            }
        }
    }

    public static void printArraylist(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    private static void printDFS(boolean[][] edges, boolean[] isVisited, int startingVertex, ArrayList<Integer> list) {
        // DFS Depth First Search
        System.out.print(startingVertex + " ");
        isVisited[startingVertex] = true;
        list.add(startingVertex);

        for (int i = 0; i < edges.length; i++) {
            if (edges[startingVertex][i] && !isVisited[i]) {
                printDFS(edges, isVisited, i);
            }
        }
    }

    private static void printBFS(boolean[][] edges, boolean[] isVisited, int startingVertex, ArrayList<Integer> list) {
        Queue<Integer> storage = new LinkedList<>();
        storage.add(startingVertex);
        isVisited[startingVertex] = true;
        list.add(startingVertex);

        while (!storage.isEmpty()) {
            int front = storage.poll();
            System.out.print(front + " ");
            for (int i = 0; i < edges.length; i++) {
                if (edges[front][i] && !isVisited[i]) {
                    storage.add(i);
                    isVisited[i] = true;
                }
            }
        }
    }

    public static void print(boolean[][] edges) {
        boolean[] isVisited = new boolean[edges.length];

        // we did this coz , agar disconnected graph hua toh , ie multiple connected
        // components
        for (int i = 0; i < edges.length; i++) {
            if (!isVisited[i]) {
                // printDFS(edges, isVisited, i);
                printDFS(edges, isVisited, i);
                System.out.println();
            }

        }
    }

    private static void printDFS(boolean[][] edges, boolean[] isVisited, int startingVertex) {
        // DFS Depth First Search
        System.out.print(startingVertex + " ");
        isVisited[startingVertex] = true;

        for (int i = 0; i < edges.length; i++) {
            if (edges[startingVertex][i] && !isVisited[i]) {
                printDFS(edges, isVisited, i);
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner input = new Scanner(System.in);
        int nosVertices = input.nextInt();
        int nosEdges = input.nextInt();
        boolean[][] edges = new boolean[nosVertices][nosVertices];
        for (int i = 0; i < nosEdges; i++) {
            int v1 = input.nextInt();
            int v2 = input.nextInt();

            edges[v1][v2] = true;
            edges[v2][v1] = true;
        }

        // getConnectedComponents(edges);
        print(edges);
    }
}