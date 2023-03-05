package SeparateChaining;

import java.util.*;

// this can be shortened more
public class _pairsWithKdifference {

    public static int getPairsWithDifferenceK(int arr[], int k) {
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
            if (k == 0 && map.containsKey(arr[i])) {
                int temp = map.get(arr[i]);
                ans += temp * (temp - 1) / 2;
                map.put(arr[i], 0);
                continue;
            }
            if (map.containsKey(arr[i] + k)) {
                ans += map.get(arr[i]) * map.get(arr[i] + k);
            }
            if (map.containsKey(arr[i] - k)) {
                ans += map.get(arr[i]) * map.get(arr[i] - k);
            }
            map.put(arr[i], 0);

        }
        return ans;
    }
}
