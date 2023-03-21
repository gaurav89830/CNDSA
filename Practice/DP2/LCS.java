class LongestCommonSubsequence {

    public static int lcs(String s, String t) {
        if (s.length() <= 0 || t.length() <= 0) {
            return 0;
        }

        if (s.charAt(0) == t.charAt(0)) {
            return 1 + lcs(s.substring(1), t.substring(1));
        } else {
            int opt1 = lcs(s, t.substring(1));
            int opt2 = lcs(s.substring(1), t);
            // int opt3 = lcs(s.substring(1), t.substring(1));
            // return Math.max(Math.max(opt1, opt2), opt3);
            return Math.max(opt1, opt2);

            // we don't have to consider the last case ( dono nhi hai (both mein subs kra
            // hai )) as that call will be
            // already handeled ( overlapped ) in the calls before.
        }
    }

    // Memoization approach
    public static int lcsM(String s, String t) {
        int[][] arr = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                arr[i][j] = -1;
            }
        }

        return lcsM(s, t, arr);
    }

    public static int lcsM(String s, String t, int[][] arr) {
        int row = s.length();
        int col = t.length();

        if (arr[row][col] != -1) {
            return arr[row][col];
        }
        if (row == 0 || col == 0) {
            arr[row][col] = 0;
            return 0;
        }

        if (s.charAt(0) == t.charAt(0)) {
            arr[row][col] = 1 + lcsM(s.substring(1), t.substring(1), arr);
        } else {
            int opt1 = lcsM(s.substring(1), t, arr);
            int opt2 = lcsM(s, t.substring(1), arr);
            arr[row][col] = Math.max(opt1, opt2);
        }

        return arr[row][col];

    }

    // DP Approach

    public static int lcsDP(String s, String t) {

        // do not use row and col , use m , n instead for easier understanding
        int row = s.length();
        int col = t.length();
        int[][] arr = new int[row + 1][col + 1];

        // set 1st row and 1st col to zero;
        for (int i = 0; i <= row; i++) {
            arr[i][0] = 0;
        }
        for (int i = 0; i <= col; i++) {
            arr[0][i] = 0;
        }

        // now
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                // imp
                if (s.charAt(row - i) == t.charAt(col - j)) {
                    // above condition is imp,
                    // lets say ki agar dono str ki len 1 hoti(not literally in dp , as in i j
                    // pointer) toh kya hum 1st chrc ko compare krte , nhi last se 1st chrc ko krte
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }

        return arr[row][col];

    }

}
