public class _removeLeafNodes {

    public static BinaryTreeNode<Integer> removeLeafNodes(BinaryTreeNode<Integer> root) {
        if (root == null)
            return null;

        if (root.right == null && root.left == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left);
        root.right = removeLeafNodes(root.right);

        return root;
    }

}