import java.util.ArrayList;

// this is important question.
public class _CheckCousin {
    static int qLevel = 0;
    static int pLevel = 0;

    static int qParent = 0;
    static int pParent = 0;
    static int LastParent = 0;

    private static void helper(BinaryTreeNode<Integer> root, int p, int q, int level, int LastParent) {
        if (root == null) {
            return;
        }

        if (root.data == p) {
            pParent = LastParent;
            qLevel = level;
        }
        if (root.data == q) {
            qParent = LastParent;
            pLevel = level;
        }

        LastParent = root.data;

        helper(root.left, p, q, level + 1, LastParent);
        helper(root.right, p, q, level + 1, LastParent);
    }

    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
        helper(root, p, q, 0, root.data);

        if (pLevel == qLevel && pParent != qParent) {
            return true;
        }
        return false;
    }
}
