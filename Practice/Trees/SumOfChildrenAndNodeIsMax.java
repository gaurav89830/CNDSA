public class SumOfChildrenAndNodeIsMax {


    // important ques;
        
        public static int sum(TreeNode<Integer> root){ 
            if(root == null){
                return 0;
            }
            int sum = root.data;
            for(int i = 0 ; i < root.children.size();i++){
                sum += root.children.get(i).data;
            }
            return sum;
        }
        
        public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
        
            TreeNode<Integer> ansNode = root;
            
            int maxSum = sum(root);
            
            for(int i = 0; i < root.children.size(); i++) {
                TreeNode<Integer> child = maxSumNode(root.children.get(i));
                int tempSum = sum(child);
                
                if(tempSum > maxSum){
                    ansNode = child;
                    maxSum = tempSum;
                }
            }
            
            return ansNode;
            
        }
    
}
