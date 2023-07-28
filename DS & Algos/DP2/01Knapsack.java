// this ques is really imp to understand...

class Knapsack01 {
    public static int knapsackR(int[] weights, int[] values, int maxWeight, int i) {
        if (i == weights.length || maxWeight == 0) {
            return 0;
        }

        if (weights[i] > maxWeight) {
            return knapsackR(weights, values, maxWeight, i + 1);
        } else {
            // included
            int opt1 = values[i] + knapsackR(weights, values, maxWeight - weights[i], i + 1);
            // not included
            int opt2 = knapsackR(weights, values, maxWeight, i + 1);

            return Math.max(opt1, opt2);
        }
    }

    public static int knapsackDP(int[] weights, int[] values, int maxWeight) {
        int n = values.length;
        int[][] storage = new int[n + 1][maxWeight + 1];
        int ans;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= maxWeight; j++) {
                if (weights[i] > j) { // okk , this means agar w[i] current bag k weight se zyada hai kya
                    ans = storage[i + 1][j];
                } else {
                    int ans1 = storage[i + 1][j];
                    int ans2 = values[i] + storage[i + 1][j - weights[i]];
                    ans = Math.max(ans1, ans2);
                }
                storage[i][j] = ans;
            }
        }
        return storage[0][maxWeight];
    }

    // there;s just the reverse way of doing this , ie the table is filled from the
    // top to bottom
    public static int knapsackR2(int[] weights, int[] values, int maxWeight, int i) {
        if (i == 0 || maxWeight == 0) {
            return 0;
        }

        if (weights[i - 1] > maxWeight) {
            return knapsackR(weights, values, maxWeight, i - 1);
        } else {
            // included
            int opt1 = values[i - 1] + knapsackR(weights, values, maxWeight - weights[i - 1], i - 1);
            // not included
            int opt2 = knapsackR(weights, values, maxWeight, i - 1);

            return Math.max(opt1, opt2);
        }
    }

    public static int knapsackDP2(int[] weights, int[] values, int maxWeight) {
        int row = values.length;
        int col = maxWeight;
        int arr[][] = new int[row + 1][col + 1];

        for (int i = 0; i <= row; i++)
            arr[i][0] = 0;
        for (int i = 0; i <= col; i++)
            arr[0][i] = 0;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (weights[i - 1] > j) {
                    arr[i][j] = arr[i - 1][j];
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], values[i - 1] + arr[i - 1][j - weights[i - 1]]);
                }
            }
        }
        return arr[row][col];
    }

    public static void main(String[] args) {

    }
}
