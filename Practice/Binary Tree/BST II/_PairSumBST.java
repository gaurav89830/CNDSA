import java.util.*;

public class _PairSumBST {
    public static ArrayList<Integer> arr = new ArrayList<>();

    private static void BSTtoAL(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        arr.add(root.data);
        BSTtoAL(root.right);
        BSTtoAL(root.left);
        return;
    }

    static void pairSum(BinaryTreeNode<Integer> root, int target) {
        BSTtoAL(root);
        Collections.sort(arr);
        // System.out.println(arr);

        int sI = 0, eI = arr.size() - 1;

        while (sI < eI) {
            if (arr.get(sI) + arr.get(eI) == target) {
                System.out.println(arr.get(sI) + " " + arr.get(eI));
                eI--;
                sI++;
            } else if (arr.get(sI) + arr.get(eI) > target) {
                eI--;
            } else {
                sI++;
            }

        }
    }

}
