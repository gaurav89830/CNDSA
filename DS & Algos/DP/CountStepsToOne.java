public class CountStepsToOne {

    // this is basic recursive approach.
    public static int countMinStepsToOne(int n) {
        if (n <= 1) {
            return 0;
        }

        int a = countMinStepsToOne(n - 1);
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;

        if (n % 2.0 == 0)
            b = countMinStepsToOne(n / 2);
        if (n % 3.0 == 0)
            c = countMinStepsToOne(n / 3);

        return Math.min(Math.min(a, b), c) + 1;
    }

    //

    // Memoization Approach

    public static int countMinStepsToOneM(int n) {
        int[] arr = new int[n + 1];
        // here calls are n only but 0th index is of no use ,
        // to make it simpler we are gonna ignoring the 0th index

        return countMinStepsToOneM_helper(arr, n);
    }

    public static int countMinStepsToOneM_helper(int[] arr, int n) {

        if (n == 1) {
            arr[n] = 0;
            return arr[n];
        }

        if (arr[n] != 0) {
            return arr[n];
        }

        int a = countMinStepsToOneM_helper(arr ,n - 1); 
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;

        if (n % 2.0 == 0)
            b = countMinStepsToOneM_helper(arr ,n / 2);
        if (n % 3.0 == 0)
            c = countMinStepsToOneM_helper(arr ,n / 3);

        arr[n] = Math.min(Math.min(a, b), c) + 1;
        return arr[n];
    }

    // DP Approach now

    public static int countStepsDP(int n) {
        
        int arr[] = new int[n + 1];

        arr[1] = 0;
        // akele upr wale se bhi kaam chl jayega
        // arr[2] = 1;
        // arr[3] = 1;

        for (int i = 2; i < arr.length; i++) {

            int a = arr[ i - 1 ]; // i hai n nhi dhyan rakhna
            int b = Integer.MAX_VALUE;
            int c = Integer.MAX_VALUE;

            if (i % 2 == 0) { // yha i hai n nhi dhyan rakhna 
                b = arr[i / 2];
            }

            if (i % 3 == 0) {
                c = arr[i / 3];
            }

            arr[i] = Math.min(Math.min(a, b), c) + 1;
        }

        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(countMinStepsToOne(103));
        System.out.println(countMinStepsToOneM(103));
        System.out.println(countStepsDP(103));
    }

}
