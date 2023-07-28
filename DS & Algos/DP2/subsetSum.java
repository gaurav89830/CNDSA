public class subsetSum {

    static boolean isSubsetPresentR(int[] arr, int i, int sum) {
        if (sum == 0) {
            return true;
        }

        if (i <= 0) {
            return false;
        }

        boolean ans1 = isSubsetPresentR(arr, i - 1, sum);
        boolean ans2 = isSubsetPresentR(arr, i - 1, sum - arr[i]);

        return ans1 || ans2;

    }

    static boolean isSubsetPresentDP(int[] ar, int ii, int sum) {
        int row = ar.length;
        int col = sum;
        boolean[][] arr = new boolean[row + 1][col + 1];

        for (int i = 0; i <= row; i++)
            arr[i][0] = true;
        for (int i = 0; i <= col; i++)
            arr[0][i] = false;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {

                if (ar[i - 1] > j) {// number bada hai to select
                    arr[i][j] = arr[i - 1][j];
                } else {
                    boolean ans1 = arr[i - 1][j];
                    boolean ans2 = arr[i - 1][j - ar[i - 1]];
                    arr[i][j] = ans1 || ans2;
                }
            }
        }
        return arr[row][col];
    }

}
