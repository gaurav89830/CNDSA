public class EditDistance {

    // recursive
    public static int editDistance(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) {
            return Math.abs(s1.length() - s2.length());
        }

        if (s1.charAt(0) == s2.charAt(0)) {
            return editDistance(s1.substring(1), s2.substring(1));
        } else {
            int opt1 = editDistance(s1, s2.substring(1));
            int opt2 = editDistance(s1.substring(1), s2);
            int opt3 = editDistance(s1.substring(1), s2.substring(1));
            return 1 + Math.min(opt1, Math.min(opt2, opt3));
        }
    }

    // memoization
    public static int editDistanceM(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] arr = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                arr[i][j] = -1;
            }
        }
        return editDistanceM(s1, s2, arr);
    }

    public static int editDistanceM(String s1, String s2, int[][] storage) {
        int m = s1.length();
        int n = s2.length();

        if (storage[m][n] != -1) {
            return storage[m][n];
        }

        // base cond
        if (m == 0 || n == 0) {
            storage[m][n] = m + n;
            return m + n;
        }
        // if (m == 0) {
        // storage[m][n] = n;
        // return n;
        // }
        // if (n == 0) {
        // storage[m][n] = m;
        // return m;
        // }

        if (s1.charAt(0) == s2.charAt(0)) {
            storage[m][n] = editDistanceM(s1.substring(1), s2.substring(1), storage);
        } else {
            int opt1 = editDistanceM(s1, s2.substring(1), storage);
            int opt2 = editDistanceM(s1.substring(1), s2, storage);
            int opt3 = editDistanceM(s1.substring(1), s2.substring(1), storage);
            storage[m][n] = 1 + Math.min(opt1, Math.min(opt2, opt3));
        }

        return storage[m][n];
    }

    public static int editDistanceDP(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int arr[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            arr[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            arr[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(m - i) == s2.charAt(n - j)) {
                    arr[i][j] = arr[i - 1][j - 1];
                } else {
                    arr[i][j] = 1 + Math.min(Math.min(arr[i - 1][j], arr[i][j - 1]), arr[i - 1][j - 1]);
                }
            }
        }
        return arr[m][n];
    }

    public static void main(String[] args) {
        System.out.println(editDistanceDP("nullsljd", "nullpointesdfdsr"));
        System.out.println(editDistanceM("nullsljd", "nullpointesdfdsr"));
        System.out.println(editDistance("nullsljd", "nullpointesdfdsr"));
    }
}
