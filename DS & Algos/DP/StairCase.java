public class StairCase {

    // Recursive
    public static long staircase(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }

        long a = staircase(n - 1);
        long b = 0;
        long c = 0;

        if (n - 2 >= 1)
            b = staircase(n - 2);

        if (n - 3 >= 1)
            c = staircase(n - 3);

        return a + b + c;

    }

    // Memoization
    public static long staircaseM(int n) {
        long arr[] = new long[n + 1];
        return staircaseMH(arr, n);
    }

    public static long staircaseMH(long[] arr, int n) {

        if (n < 1) {
            arr[n] = 0;
            return arr[n];
        }
        if (n == 1) {
            arr[n] = 1;
            return arr[n];
        }
        if (n == 2) {
            arr[n] = 2;
            return arr[n];
        }
        if (n == 3) {
            arr[n] = 4;
            return arr[n];
        }

        long a = staircase(n - 1);
        long b = 0;
        long c = 0;

        if (n - 2 >= 1)
            b = staircase(n - 2);

        if (n - 3 >= 1)
            c = staircase(n - 3);

        arr[n] = a + b + c;
        return arr[n];
    }

    // DP
    public static long staircaseDP(int n) {
        long[] arr = new long[n + 1];

        if (n == 0)
            return 1;
        if (n == 1 || n == 2)
            return n;

        arr[0] = 1; // ?? pta nhi soln mein de rakha tha, merko 0 lga
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < arr.length; i++) {

            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }

        return arr[n];
    }

}
