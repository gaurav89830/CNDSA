public class _insertDuplicateNode {
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {

        if (root == null)
            return;
        // Your code goes here

        BinaryTreeNode<Integer> newroot = new BinaryTreeNode<>(root.data);

        BinaryTreeNode<Integer> save = root.left;

        root.left = newroot;
        newroot.left = save;

        insertDuplicateNode(newroot.left); // ;this is the actual logic
        insertDuplicateNode(root.right);

    }

}
