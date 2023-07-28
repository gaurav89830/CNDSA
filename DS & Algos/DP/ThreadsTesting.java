import java.sql.Time;

class Fib1 extends Thread {

    // basic fib with recursion
    @Override
    public void run() {
        long t1 = System.currentTimeMillis();
        System.out.println("Fib R : " + FibR(ThreadTesting.Num) + "\tms:" + (System.currentTimeMillis() - t1));
    }

    int FibR(int i) {
        if (i == 1 || i == 0) {
            return i;
        }
        return FibR(i - 1) + FibR(i - 2);
    }
}

class Fib2 extends Thread {

    // basic fib with recursion
    @Override
    public void run() {
        long t1 = System.currentTimeMillis();

        System.out.println("Fib M : " + FibM(ThreadTesting.Num) + "\tms:" + (System.currentTimeMillis() - t1));
    }

    int FibM(int n) {
        int[] arr = new int[n + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        return FibMH(arr, n); // MH Memoization Helper
    }

    int FibMH(int[] arr, int n) {
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
}

class Fib3 extends Thread {

    // basic fib with recursion
    @Override
    public void run() {
        long t1 = System.currentTimeMillis();

        System.out.println("Fib DP : " + FibDP(ThreadTesting.Num) + "\tms:" + (System.currentTimeMillis() - t1));
    }

    int FibDP(int n) {
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

}

class ThreadTesting {

    // now we gonnna do this Iteratively... Ig yeh hai Dynamic Prog
    public static int Num = 45;

    public static void main(String[] args) {
        Fib1 f1 = new Fib1();
        Fib2 f2 = new Fib2();
        Fib3 f3 = new Fib3();

        f1.start();
        f2.start();
        f3.start();

    }
}