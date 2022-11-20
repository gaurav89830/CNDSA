import java.util.*;

public class Q_MaxFreqNumber {
    public static int maxFreqNum(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int currentKey = arr[i];
            if (map.containsKey(currentKey)) {
                map.put(currentKey, map.get(currentKey) + 1);
            } else {
                map.put(currentKey, 1);
            }
        }

        // now instead of looping through the map
        // we are gonna loop through the array , so 1st max is saved easily
        int maxFreq = 0;
        int maxKey = Integer.MIN_VALUE; // ans
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) > maxFreq) {
                maxFreq = map.get(arr[i]);
                maxKey = arr[i];
            }
        }

        return maxKey;

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2,2,2, 2, 3, 4, 5, 6, 6, 6, 6, 68 };
        System.out.println(maxFreqNum(arr));

    }
}