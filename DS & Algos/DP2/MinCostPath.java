
class MinCostPath {

    // recursive soln

    public static int minCostPath(int[][] input) {
        return minCostPathHelper(input, 0, 0);
    }

    public static int minCostPathHelper(int[][] arr, int i, int j) {
        int row = arr.length;
        int col = arr[0].length;

        if (i == row - 1 && j == col - 1) {
            return arr[i][j];
        }
        if (i >= row || j >= col) {
            return Integer.MAX_VALUE;
        }

        int a = minCostPathHelper(arr, i, j + 1);
        int b = minCostPathHelper(arr, i + 1, j + 1);
        int c = minCostPathHelper(arr, i + 1, j);

        return arr[i][j] + Math.min(Math.min(a, b), c);

    }

    // memoization is easy

    // DP
    public static int minCostPathDP(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int[][] storage = new int[row][col];

        storage[row - 1][col - 1] = arr[row - 1][col - 1];

        // for last col
        for (int i = row - 2; i >= 0; i--) {
            storage[i][col - 1] = arr[i][col - 1] + storage[i + 1][col - 1];
        }

        // for last row
        for (int j = col - 2; j >= 0; j--) {
            storage[row - 1][j] = arr[row - 1][j] + storage[row - 1][j + 1];
            // System.out.println(storage[row - 1][j]);
        }

        // now for rest of the elem
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                storage[i][j] = arr[i][j]
                        + Math.min(Math.min(storage[i][j + 1], storage[i + 1][j + 1]), storage[i + 1][j]);
            }
        }

        return storage[0][0];

    }

    // main
    public static void main(String[] args) {
        int[][] arr = {
                { 10, 6, 9, 0 },
                { -223, 8, 22, 90 },
                { -200, 0, 89, 200 }
        };

        System.out.println(minCostPathDP(arr));
        System.out.println(minCostPath(arr));

        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 0; j < arr[i].length; j++) {
        // System.out.print(arr[i][j] + " ");
        // }
        // System.out.println();
        // }

    }
}