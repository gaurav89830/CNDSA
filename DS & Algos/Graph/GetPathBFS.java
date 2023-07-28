import java.util.*;

public class GetPathBFS {

    public static ArrayList<Integer> getPathBFS(boolean[][] edges, boolean[] isVisited, int sV, int target) {
        if (target > edges.length - 1 || sV > edges.length - 1) {
            return null;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(sV);
        isVisited[sV] = true;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(sV, -1);

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < edges.length; i++) {
                if (edges[i][temp] && !isVisited[i]) {
                    q.add(i);
                    isVisited[i] = true;
                    map.put(i, temp);

                    // if( i == target){
                    // found
                    // isVisited[target] = true;
                    // }
                }
            }
        }

        // bhai easy hai yeh bohot , tune khud hi kr dia tha, rasta yaad hai map ko ,
        // just apne path ko trace krta chal
        if (!isVisited[target]) {
            return null;
        } else {
            ArrayList<Integer> ans = new ArrayList<>();
            int key = target;
            int value = 0;
            while (value != -1) {
                ans.add(key);
                value = map.get(key);
                key = value;
            }
            return ans;
        }

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

        ArrayList<Integer> list = getPathBFS(edges, isVisited, sV, target);
        if (list != null) {
            for (int i : list) {
                System.out.print(i + " ");
            }
        }

    }
}