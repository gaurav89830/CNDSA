public class _LCA_BST {

    // previus soln for BT works here but this one is more optimised , but i didn't understood it.

    
    public static BinaryTreeNode<Integer> getLCAUtil(BinaryTreeNode<Integer> root, int a, int b) {
        if (root == null || root.data == a || root.data == b) {
            return root;
        }
        if (root.data < a && root.data < b) {
            return getLCAUtil(root.right, a, b);
        } else if (root.data > a && root.data > b) {
            return getLCAUtil(root.left, a, b);
        }
        BinaryTreeNode<Integer> leftLCA = getLCAUtil(root.left, a, b);
        BinaryTreeNode<Integer> rightLCA = getLCAUtil(root.right, a, b);
        if (leftLCA != null && rightLCA != null) {
            return root;
        } else if (leftLCA != null) {
            return leftLCA;
        }
        return rightLCA;
    }

    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        BinaryTreeNode<Integer> node = getLCAUtil(root, a, b);
        return (node == null) ? -1 : node.data;
    }

}
