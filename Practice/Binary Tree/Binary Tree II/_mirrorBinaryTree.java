public class _mirrorBinaryTree {

    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
        BinaryTreeNode<Integer> templeft = root.left;
        root.left = root.right;
        root.right = templeft;
    }
}
