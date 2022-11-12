public class _isBST1 {
    // Code 1 : not optimised 

    public static int maximum(BinaryTreeNode<Integer> root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data,Math.max(maximum(root.left),maximum(root.right)));
    }
    
    public static int minimum(BinaryTreeNode<Integer> root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        return Math.min(root.data,Math.min(minimum(root.left),minimum(root.right)));
    }

	public static boolean isBST(BinaryTreeNode<Integer> root) {
        if(root==null){
            return true;
        }
        int min=maximum(root.left);
        int max=minimum(root.right);
        if(root.data<=min){
            return false;
        }
        if(root.data>max){
            return false;
        }
        boolean lans=isBST(root.left);
        boolean rans=isBST(root.right);

		return lans && rans ;
	}

}
