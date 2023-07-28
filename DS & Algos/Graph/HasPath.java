
import java.util.*;

public class HasPath {

    // one testcase failing below
    // https://classroom.codingninjas.com/app/classroom/me/17895/content/352205/offering/4940264/problem/1693
    public static boolean hasPath(boolean[][] graph, boolean[] isVisited, int v1, int v2) { // DFS
        // v1 ko starting maano and v2 ko target
        if (v1 > graph.length - 1 || v2 > graph.length - 1) {
            return false;
        }

        if (graph[v1][v2]) {
            return true;
        }
        isVisited[v1] = true;

        for (int i = 0; i < graph.length; i++) {

            if (i == v1) {
                continue;
            }

            if (graph[i][v1] && !isVisited[i]) {
                return hasPath(graph, isVisited, i, v2);
            }
        }
        return false;
    }

    // bfs is completely correct
    public static boolean hasPath2(boolean[][] graph, boolean[] isVisited, int v1, int v2) { // BFS
        if (v1 > graph.length - 1 || v2 > graph.length - 1) {
            return false;
        }

        Queue<Integer> q = new LinkedList<>();

        if (graph[v1][v2]) {
            return true;
        }

        // taking v1 as starting index
        q.add(v1);
        isVisited[v1] = true;

        while (!q.isEmpty()) {
            int temp = q.remove();
            for (int i = 0; i < graph.length; i++) {
                if (!isVisited[i] && graph[i][temp]) {
                    q.add(i);
                    isVisited[i] = true;
                }
            }
        }
        return isVisited[v2];
    }

    public static void main(String[] args) throws NumberFormatException {
        /*
         * Write Your Code Here
         * Complete the Rest of the Program
         * You have to take input and print the output yourself
         */
        Scanner input = new Scanner(System.in);
        int nosVertices = input.nextInt();
        int nosEdges = input.nextInt();

        boolean[][] graph = new boolean[nosVertices][nosVertices];

        for (int i = 0; i < nosEdges; i++) {
            int v1 = input.nextInt();
            int v2 = input.nextInt();

            graph[v1][v2] = true;
            graph[v2][v1] = true;
        }

        int v1 = input.nextInt();
        int v2 = input.nextInt();

        // if (v2 > graph.length) {
        // System.out.println(false);
        // return;
        // }

        boolean[] isVisited = new boolean[nosVertices];

        System.out.print(hasPath(graph, isVisited, v1, v2));

    }

}
