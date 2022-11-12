public class _ifBalanced {

    // this is n(log n) approach , multiple(first height then itself) left right
    // recursive calls making it slow.
    public static boolean ifBalanced(BinaryTreeNode<Integer> root) {
        /*
         * Whats Balanced Tree ??
         * 
         * Height(right) - Height(left) =< 1
         * & above should be true in each and every node not just root.
         */

        if (root == null)
            return true;

        if (Math.abs(Main.height(root.right) - Main.height(root.left)) > 1) {
            return false;
        }

        return (ifBalanced(root.left) && ifBalanced(root.right)); // dono true toh tree balanced
    }

    // better approach, easy hai , padh ek baar;

    

    public static boolean ifBalancedBetter(BinaryTreeNode<Integer> root) {
        return ifBalancedBetterHelper(root).isbalanced;
    }

    public static balancedTreeReturn ifBalancedBetterHelper(BinaryTreeNode<Integer> root) {

        if (root == null) {
            balancedTreeReturn ans = new balancedTreeReturn();
            ans.height = 0;
            ans.isbalanced = true;
            return ans;
        }

        balancedTreeReturn leftOutput = ifBalancedBetterHelper(root.left);
        balancedTreeReturn rightOutput = ifBalancedBetterHelper(root.right);

        boolean isbalanced = true;

        int height = 1 + Math.max(leftOutput.height, rightOutput.height);

        if (Math.abs(leftOutput.height - rightOutput.height) > 1) {
            isbalanced = false;
        }

        if (leftOutput.isbalanced == false || rightOutput.isbalanced == false) {
            isbalanced = false;
        }

        balancedTreeReturn ans = new balancedTreeReturn();
        ans.height = height;
        ans.isbalanced = isbalanced;

        return ans;
    }

}

class balancedTreeReturn {
    public int height;
    public boolean isbalanced;
}
