import java.util.*;

public class _PrintLevelWise {
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        Queue<BinaryTreeNode<Integer>> NodesLeft = new LinkedList<>();
        NodesLeft.add(root);
        NodesLeft.add(null);

        while (!NodesLeft.isEmpty()) {
            BinaryTreeNode<Integer> node = NodesLeft.poll();

            if (node == null) {
                if (NodesLeft.isEmpty()) { // null aa gya + queue khali hai
                    break;
                }
                System.out.println();
                NodesLeft.add(null);
            } else {
                System.out.print(node.data + " ");
                if (node.left != null)
                    NodesLeft.add(node.left);
                if (node.right != null)
                    NodesLeft.add(node.right);
            }
        }

    }
}
