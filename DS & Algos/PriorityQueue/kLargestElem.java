import java.util.*;

// nlogk approach hai yeh 
public class kLargestElem {
    public static ArrayList<Integer> kLargest(int arr[], int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (pq.peek() < arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
        }
        ArrayList<Integer> ar = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            ar.add(pq.remove());
        }
        return ar;
    }
}
