public class _LCABinaryTree {

    static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        if (root == null) {
            return -1;
        }
        if (root.data == a) {
            return a;
        }
        if (root.data == b) {
            return b;
        }

        int lo = getLCA(root.left, a, b);
        int ro = getLCA(root.right, a, b);

        if (lo == -1 && ro == -1) {
            return -1;
        } else if (lo == -1) {
            return ro;
        } else if (ro == -1) {
            return lo;
        } else {
            return root.data;
        }

    }

    // Below one is the correct solution.

    /*
     *     static BinaryTreeNode<Integer> getLCAHelper(BinaryTreeNode<Integer> root, int a, int b) {
        if (root==null) {
            return null;
        }
    
        if (root.data == a || root.data == b) {
            return root;
        }
        
        BinaryTreeNode<Integer> leftLCA = getLCAHelper(root.left, a, b);
        BinaryTreeNode<Integer> rightLCA = getLCAHelper(root.right, a, b);
    
        if ((leftLCA != null) && (rightLCA != null) ) {
            return root;
        }
    
        if (leftLCA != null) {
            return leftLCA;
        }
    
        return rightLCA;
    }
    
    static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        BinaryTreeNode<Integer> node = getLCAHelper(root, a, b);
        if (node != null) {
            return node.data;
        }
        else {
            return -1;
        }
    }

     */

}
