
/*
 * 
 * For a given Binary Tree of type integer and a number K, print out all root-to-leaf paths where the sum of all the node data along the path is equal to K.
Example:
alt txt
If you see in the above-depicted picture of Binary Tree, we see that there are a total of two paths, starting from the root and ending at the leaves which sum up to a value of K = 13.

The paths are:
a. 2 3 4 4
b. 2 3 8

One thing to note here is, there is another path in the right sub-tree in reference to the root, which sums up to 13 but since it doesn't end at the leaf, we discard it.
The path is: 2 9 2(not a leaf

 */

public class _rootToLeafPathSum {
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {

        String path = "";
        helper(root, k, 0, path);
    }

    public static void helper(BinaryTreeNode<Integer> root, int k, int sum, String path) {
        if (root == null)
            return;

        path += root.data + " ";
        sum += root.data;

        if (sum == k && root.right == null && root.left == null) { // leaf bhi honi chiye
            System.out.println(path);
            return;
        }
        helper(root.left, k, sum, path);
        helper(root.right, k, sum, path);
    }

}
