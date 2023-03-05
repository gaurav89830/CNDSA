import java.util.PriorityQueue;

public class kSort {

    public static void ksort(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        // lets first add k elements in the array
        for (; i < k; i++) {
            pq.add(arr[i]);
        }
        // now lets one by one remove the min elem(it will be in correct order because,
        // the elemnts will be present withn k positions) and add new elem
        for (; i < arr.length; i++) {
            arr[i - k] = pq.remove();
            pq.add(arr[i]);
        }
        // now all the elements are added to pq and some are even in sorted from in
        // array but , still k no of last elemnts are still remainign , as we only set
        // arr[i - k ]
        for (i = arr.length - k; i < arr.length; i++) {
            arr[i] = pq.remove();
        }

    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 8, 6, 90 };
        int k = 2;
        // ksort(arr, k);

        // for (int i = 0; i < arr.length; i++)
        // System.out.print(arr[i] + " ");
        System.out.println(findKthLargest(arr, k));
    }

    public static int findKthLargest(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            System.out.println(pq.add(arr[i]));
        }
        for (int i = k; i < arr.length; i++) {
            if (pq.peek() < arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
        }
        // for (int i = 0; i < k - 1; i++) {
        //     System.out.println(pq.remove());
        // }
        return pq.peek();
    }

}
