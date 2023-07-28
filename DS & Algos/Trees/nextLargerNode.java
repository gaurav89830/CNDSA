// star problem 

public class nextLargerNode {

    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {
        if (root == null) {
            return null;
        }

        TreeNode<Integer> nextLargerNode = null;
        if (root.data > n) {
            nextLargerNode = root;
        }

        for (TreeNode<Integer> child : root.children) {
            TreeNode<Integer> nextLargerInChild = findNextLargerNode(child, n);
            if (nextLargerInChild != null) {
                if (nextLargerNode == null || nextLargerNode.data > nextLargerInChild.data) {
                    nextLargerNode = nextLargerInChild;
                }
            }
        }
        return nextLargerNode;
    }

}





// my hacked approach  aka chutiya approach
//     public static void helper(TreeNode<Integer> root , ArrayList<TreeNode<Integer>> list){
    //         if(root == null)
    //             return;
            
    //         for(int i = 0 ; i < root.children.size();i++){
    //             list.add(root.children.get(i));
    //             helper(root.children.get(i) , list);
    //         }
    //     }   
        
    // 	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
            
    //         ArrayList<TreeNode<Integer>> list = new ArrayList<TreeNode<Integer>>();
    //         list.add(root);
    //         helper(root , list);
            
    //         int minMax = Integer.MAX_VALUE , x = 0;
    //         for(int i = 0; i < list.size();i++){
    //             int num = list.get(i).data;
                
    //             if(num > n && num < minMax){
    //                 minMax = num;
    //                 x = i;
    //             }
    //             // if(num > n && max < num){
    //             //     smax = num;
    //             //     smaxi = i;
    //             // }
    //         }
            
    //         return list.get(x);
            
    
    // 	}