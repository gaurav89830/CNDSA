import java.net.Inet4Address;
import java.util.*;

public class Q_RemoveDuplicates {
    public static ArrayList<Integer> RemoveDuplicates(int[] arr) {
        HashMap<Integer, Boolean> seen = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (seen.containsKey(arr[i])) {
                continue;
            }
            seen.put(arr[i], true);
            ans.add(arr[i]);
        }
        return ans;
    }

    // public static void main(String[] args) {
    //     int arr[] = {1,1,2,3,4,3,4444,5,6,33,7,9,9,9,9};
    //     ArrayList<Integer> ans = RemoveDuplicates(arr);

    //     System.out.println(ans);
    // }
}
