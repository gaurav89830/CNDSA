package temp;

import java.util.*;

public class main {
    public static void main(String[] args) {
        int arr[] = { 4, 4, 4, 4 };
        func(arr, 0);
    }

    public static int func(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
                continue;
            }
            map.put(arr[i], 1);
        }

        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            if (k == 0) {
                int temp = map.get(arr[i]);
                ans += temp * (temp - 1) / 2;
                map.remove(arr[i]);
                continue;
            }
            if (map.containsKey(arr[i] + k)) {
                ans += map.get(arr[i]) * map.get(arr[i] + k);
                // map.put(arr[i] +k , 0);
            }
            if (map.containsKey(arr[i] - k)) {
                ans += map.get(arr[i]) * map.get(arr[i] - k);
                // map.put(arr[i] -k , 0);
            }
            map.remove(arr[i]);
        }
        return ans;
    }
}
