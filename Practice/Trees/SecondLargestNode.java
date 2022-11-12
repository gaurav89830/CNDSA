public class SecondLargestNode {

    /*
     * TreeNode structure
     * 
     * class TreeNode<T> {
     * T data;
     * ArrayList<TreeNode<T>> children;
     * 
     * TreeNode(T data){
     * this.data = data;
     * children = new ArrayList<TreeNode<T>>();
     * }
     * }
     */
    public static TreeNode<Integer> smax = new TreeNode<Integer>(Integer.MIN_VALUE);
    public static TreeNode<Integer> max = smax;

    public static void helper(TreeNode<Integer> root) {

        if (root == null)
            return;

        if (root.data > max.data) {
            smax = max;
            max = root;
        } else if (root.data > smax.data && root.data != max.data) {
            smax = root;
        }

        for (int i = 0; i < root.children.size(); i++) {
            helper(root.children.get(i));
        }
    }

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root) {
        helper(root);
        return smax;
    }

}
