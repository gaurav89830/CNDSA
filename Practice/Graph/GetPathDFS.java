import java.util.*;

public class GetPathDFS {

    public static ArrayList<Integer> getPathDFS(boolean[][] edges, boolean[] isVisited, int sV, int target) {
        isVisited[sV] = true;
        if (sV == target) { // imp
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(sV);
            return ans;
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[sV][i] && !isVisited[i]) {
                ArrayList<Integer> temp = getPathDFS(edges, isVisited, i, target);
                if (temp != null) {
                    temp.add(sV); // imp , not i
                    return temp;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws NumberFormatException {
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

        int sV = input.nextInt();
        int target = input.nextInt();
        boolean[] isVisited = new boolean[edges.length];

        ArrayList<Integer> list = getPathDFS(edges, isVisited, sV, target);
        if (list != null) {
            for (int i : list) {
                System.out.print(i + " ");
            }
        }
    }
}