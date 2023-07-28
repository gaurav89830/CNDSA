import java.util.*;

public class FindPathInBST {

    public static ArrayList<Integer> LL = new ArrayList<>();

    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data) {
        /*
         * Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if (helper(root, data)) {
            return LL;
        } else {
            return new ArrayList<>();
        }
    }

    public static boolean helper(BinaryTreeNode<Integer> root, int data) {
        if (root == null) {
            return false;
        }

        if (root.data == data) {
            LL.add(root.data);
            return true;
        }

        boolean leftOutput = helper(root.left, data);
        boolean rightOutput = helper(root.right, data);

        if (leftOutput || rightOutput) {
            LL.add(root.data);
            return true;
        } else {
            return false;
        }

    }

}
