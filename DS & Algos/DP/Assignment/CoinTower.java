package Assignment;
// itna sar dard kr dia ques na but ques aassaan tha

// simply , yeh scene hai n coins hai toh agar n - 1, ya n-x,n-y pr kisi mein bhi apponet jeeta ya kho ki aap haare toh mtlb hai ki ab next aap jeetoge

class CoinTower {
    public static String findWinner(int n, int x, int y) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[x] = 1;
        arr[y] = 1;

        for (int i = 2; i < arr.length; i++) {
            if (i == x || i == y) {
                continue;
            } // yeh kyu hua ??
            int j = 0, k = 0;
            int ii = 0;

            ii = arr[i - 1] ^ 1;
            // if 1 we got then win , else fail
            if (i - x >= 1) {
                j = arr[i - x] ^ 1;
            }
            if (i - y >= 1) {
                k = arr[i - y] ^ 1;
            }

            arr[i] = Math.max(k, Math.max(ii, j)); // 1 or 0 hi hai yha , kisi mein bhi 1 toh win

        }

        if (arr[n] == 1) {
            return "Beerus";
        } else {
            return "Whis";
        }
    }

}