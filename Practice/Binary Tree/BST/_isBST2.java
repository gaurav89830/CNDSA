public class _isBST2 {
    public static Answer isBST2(BinaryTreeNode<Integer> root){
        if(root == null){
             Answer ans = new Answer();
             ans.isbst = true;
             ans.max = Integer.MIN_VALUE;
             ans.min = Integer.MAX_VALUE;
             return ans;
        }

        Answer leftOutput = isBST2(root.left);
        Answer rightOutput = isBST2(root.right);

        int MIN = Math.min(root.data, Math.min(leftOutput.min, rightOutput.min));
        int MAX = Math.max(root.data, Math.max(leftOutput.max, rightOutput.max));

        boolean isBST = leftOutput.isbst && rightOutput.isbst
                        && root.data > leftOutput.max && root.data <= rightOutput.min; // this is imortant statement

        // now just return 
        Answer ans = new Answer();
        ans.isbst = isBST;
        ans.min = MIN;
        ans.max = MAX;

        return ans;
    }
}

class Answer {
    boolean isbst;
    int min;
    int max;
}