// this one is important question

class CountBalancedTrees {

    public static long mod = (long) Math.pow(10, 9) + 7;

    // Recursive Code...
    // but here is a problem
    // for num > 5 this program fails
    // Integer Overflow , too big nums multiply
    // so we mod it with the given requirement in ques
    // store it in a long & then cast it to int ...

    public static int countBT(int h) {
        if (h == 0 || h == 1) {
            return 1;
        }

        int x = countBT(h - 1);
        int y = countBT(h - 2);

        return x * x + 2 * x * y;
    }

    // improved version of this
    public static int countBTimproved(int h) {
        int mod = (int) Math.pow(10, 9) + 7;
        return countBTimproved(mod, h);
    }

    private static int countBTimproved(int mod, int h) {
        if (h == 0 || h == 1) {
            return 1;
        }

        int x = countBTimproved(h - 1);
        int y = countBTimproved(h - 2);

        long res1 = (long) x * x;
        long res2 = (long) x * y * 2;

        int value1 = (int) (res1 % mod);
        int value2 = (int) (res2 % mod);

        return (value1 + value2) % mod;
    }

    // for long return type

    public static long countBTimproved(long h) {
        long mod = (long) Math.pow(10, 9) + 7;
        return countBTimprovedHelper(mod, h);
    }

    private static long countBTimprovedHelper(long mod, long h) {
        if (h == 0 || h == 1) {
            return 1;
        }

        long x = countBTimproved(h - 1);
        long y = countBTimproved(h - 2);

        long res1 = x * x;
        long res2 = x * y * 2;

        // int value1 = (int) (res1 % mod);
        // int value2 = (int) (res2 % mod);

        return (long) (res1 + res2) % mod;
    }

    // done
    // -----------------------------------------------------
    // DP approach
    private static long countBTDP(int h) {

        long arr[] = new long[h + 1];

        if (h == 0 || h == 1) {
            arr[h] = 1;
            return arr[h];
        }

        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < arr.length; i++) {

            long x = arr[i - 1];
            long y = arr[i - 2];

            long res1 = x * x;
            long res2 = x * y * 2;

            arr[i] = (res1 + res2) % mod;

        }

        return arr[h];
    }

    // for int return type
    public static long countBTDPlong(int h) {
        int mod = (int) Math.pow(10, 9) + 7;

        int arr[] = new int[h + 1];

        if (h == 0 || h == 1) {
            arr[h] = 1;
            return arr[h];
        }

        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < arr.length; i++) {

            int x = arr[i - 1];
            int y = arr[i - 2];

            long res1 = (long) x * x;
            long res2 = (long) x * y * 2;

            int value1 = (int) (res1 % mod);
            int value2 = (int) (res2 % mod);

            arr[i] = (value1 + value2) % mod;

        }

        return arr[h];

    }

    public static void main(String[] args) {
        long h = 9;
        System.out.println(countBTimproved(9));
        System.out.println(countBTDP(9));
        System.out.println(countBTimproved(h));
        System.out.println(countBTDPlong(9));
    }
}