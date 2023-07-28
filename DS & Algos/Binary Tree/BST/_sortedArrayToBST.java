public class _sortedArrayToBST {
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n) {
        if (n == 0)
            return null;

        return helper(arr, 0, arr.length - 1);
    }

    public static BinaryTreeNode<Integer> helper(int[] arr, int sI, int eI) {
        if (eI < sI) {
            return null;
        }
        int mid = (sI + eI) / 2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[mid]);

        BinaryTreeNode<Integer> leftOutput = helper(arr, sI, mid - 1);
        BinaryTreeNode<Integer> rightOutput = helper(arr, mid + 1, eI);

        root.left = leftOutput;
        root.right = rightOutput;

        return root;

    }
}
