import java.io.*;
import java.util.*;

public class IsConnected {

    // easiest : just ek baar traverse kr le just ek node pr , pta chl jayega ki yeh
    // ek hi component hai ya multiple connected component ( iss case mein false
    // honge isvisited mein)

    public static void isConnected(boolean[][] edges, boolean[] isVisited, int sV) {
        if (sV > edges.length - 1) {
            return;
        }
        isVisited[sV] = true;

        for (int i = 0; i < edges.length; i++) {
            if (edges[sV][i] && !isVisited[i]) {
                isConnected(edges, isVisited, i);
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
        boolean[] isVisited = new boolean[edges.length];
        isConnected(edges, isVisited, 0); // any starting edge
        boolean ans = true;
        for (int i = 0; i < isVisited.length; i++) {
            if (!isVisited[i]) {
                ans = false;
            }
        }
        System.out.println(ans);
    }

}