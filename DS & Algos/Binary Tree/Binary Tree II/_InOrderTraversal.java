public class _InOrderTraversal {
    public static void InOrderTraversal(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        InOrderTraversal(root.left);
        System.out.println(root + " ");
        InOrderTraversal(root.right);
    }
}
