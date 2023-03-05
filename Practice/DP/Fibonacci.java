public class Fibonacci {

    // basic fib with recursion
    static int FibR(int i) {
        if (i == 1 || i == 0) {
            return i;
        }
        return FibR(i - 1) + FibR(i - 2);
    }

    // now solve this with Dynamic Programming

    // In recursive code the repeated func calls are made
    // to solve this we store the Fib(n) result in an array of
    // size n + 1 as this the no. of unique calls are made.

    // THIS TECHINIQUE IS CALLED MEMOIZATION

    // TOTAL Calls here is 2n - 1 , Therefore O(n) Complexity.

    static int FibM(int n) {
        int[] arr = new int[n + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        return FibMH(arr, n); // MH Memoization Helper
    }

    static int FibMH(int[] arr, int n) {
        if (n == 0 || n == 1) {
            arr[n] = n;
        }

        if (arr[n] != -1) {
            return arr[n];
        }
        // else
        arr[n] = FibMH(arr, n - 1) + FibMH(arr, n - 2);
        return arr[n];
    }

    // now we gonnna do this Iteratively... Ig yeh hai Dynamic Prog

    public static int FibDP(int n) {
        // its follows bottoms up approach ,
        // Aim is to base case ki value hume pta hai,
        // usse use krke aage ki value find kro
        int[] arr = new int[n + 1];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(FibR(20));
        System.out.println(FibM(20));
        System.out.println(FibDP(20));
    }
}