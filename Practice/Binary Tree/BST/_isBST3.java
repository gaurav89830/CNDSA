public class _isBST3 {
    public static boolean isBST3(BinaryTreeNode<Integer> root) {
        return isBST3(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBST3(BinaryTreeNode<Integer> root, int min, int max) {
        if (root == null)
            return true;

        // max ≠ Left max
        // min ≠ right min
        // this is different logic,

        if (root.data > max || root.data < min) {
            return false;
        }

        boolean leftOutput = isBST3(root.left, min, root.data - 1);
        boolean rightOutput = isBST3(root.right, root.data, max);

        return leftOutput && rightOutput;
    }
}
