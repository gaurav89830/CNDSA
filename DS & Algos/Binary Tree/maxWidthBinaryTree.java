/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode , Integer>> Q = new LinkedList<>();
        Q.add(new Pair<>(root , 1));
        int maxW = 0 ;
        while(!Q.isEmpty()){
            int totalNodes = Q.size();
            int startID = Q.peek().getValue();
            int endID = 0; // startID - endID at same level

            for(int i = 0 ; i < totalNodes ; i++){
                TreeNode node = Q.peek().getKey();
                int parentID = Q.peek().getValue();
                Q.poll();

                if(node.left!=null){
                    Q.add(new Pair<>(node.left , (parentID - 1)*2 + 1));
                }
                if(node.right!=null){
                    Q.add(new Pair<>(node.right , (parentID - 1)*2 + 2));
                }
                endID = parentID;
            }
            maxW = Math.max(maxW , endID - startID + 1);
        }

        return maxW;
    }
}
