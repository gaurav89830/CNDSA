import java.util.*;
// this is imp question

/*
 * Given a binary tree, return the longest path from leaf to root. Longest means, a path which contain maximum number of nodes from leaf to root.
Input format :
Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 1 : Binary Tree 1 (separated by space)
Sample Input 1 :
 5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1 :
9
3
6
5
 */
public class _longtestLeafToRootPath {
    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root) {
        if (root == null) {
            ArrayList<Integer> ans = new ArrayList<>();
            return ans;
        }

        ArrayList<Integer> lo = longestRootToLeafPath(root.left);
        ArrayList<Integer> ro = longestRootToLeafPath(root.right);

        if (lo.size() > ro.size()) {
            lo.add(root.data);
        } else {
            ro.add(root.data);
        }

        return (lo.size() > ro.size() ? lo : ro);
    }
}
