import java.util.*;

// import javax.swing.tree.TreeNode;

public class Main {

    public static BinaryTreeNode<Integer> takeInput(Scanner input) {

        System.out.print("Enter Root Data : ");
        int rootData = input.nextInt();
        if (rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        root.left = takeInput(input);
        root.right = takeInput(input);

        return root;
    }

    public static BinaryTreeNode<Integer> takeInputLevelWise() {
        Scanner input = new Scanner(System.in);
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();

        System.out.print("Enter Node Data : ");
        int nodeData = input.nextInt();

        if (nodeData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(nodeData);

        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingNodes.poll();

            System.out.println("Enter left child of : " + front.data);
            int leftChild = input.nextInt();

            if (leftChild != -1) {
                BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<Integer>(leftChild);
                pendingNodes.add(leftNode);
                front.left = leftNode;
            }

            System.out.println("Enter right child of : " + front.data);
            int rightChild = input.nextInt();

            if (rightChild != -1) {
                BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<Integer>(rightChild);
                pendingNodes.add(rightNode);
                front.right = rightNode;
            }
        }

        return root;

    }

    public static void printBT(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        String output = new String();

        output = root.data + " : ";
        if (root.left != null) {
            output += "L" + root.left.data + " , ";
        }
        if (root.right != null) {
            output += "R" + root.right.data + " , ";
        }

        System.out.println(output);

        printBT(root.left);
        printBT(root.right);
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {

        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> childNode = pendingNodes.poll();
            if (childNode == null)
                return;
            String print;
            print = childNode.data + ":";
            if (childNode.left != null) {
                print += "L:" + childNode.left.data + ",";
                pendingNodes.add(childNode.left);
            } else {
                print += "L:" + "-1,";
            }
            if (childNode.right != null) {
                print += "R:" + childNode.right.data;
                pendingNodes.add(childNode.right);
            } else {
                print += "R:-1";
            }
            System.out.println(print);
        }
    }

    public static int countNodes(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;

        int sum = 0;

        return sum = 1 + countNodes(root.right) + countNodes(root.left);
        // yeh 1 toh node ke khud ka hai , func call toh 0 return krega null nodes mein.
    }

    public static int getSumOfAllNodes(BinaryTreeNode<Integer> root) {
        // Your code goes here.
        if (root == null)
            return 0;

        return root.data + getSumOfAllNodes(root.right) + getSumOfAllNodes(root.left);
    }

    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
        if (root == null)
            return false;

        if (root.data == x) {
            return true;
        }

        return isNodePresent(root.right, x) || isNodePresent(root.left, x);
    }

    public static int largestData(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;

        return Math.max(root.data, Math.max(largestData(root.right), largestData(root.left)));
    }

    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;

        return 1 + Math.max(height(root.right), height(root.left));
    }

    public static int numLeaves(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null)
            return 1;

        return numLeaves(root.left) + numLeaves(root.right);
    }

    // change to depth tree
    public static void helper(BinaryTreeNode<Integer> root, int depth) {
        if (root == null)
            return;

        root.data = depth;

        helper(root.right, depth + 1);
        helper(root.left, depth + 1);
    }

    public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
        helper(root, 0);
    }

    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        if (root.left == null && root.right != null) {
            System.out.print(root.right.data + " ");
        }

        if (root.left != null && root.right == null) {
            System.out.print(root.left.data + " ");
        }

        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
    }

    // ------------------------------------------
    public static void main(String[] args) {
        // BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(10);
        // BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(20);
        // BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(30);
        // root.right = node1;
        // root.left = node2;
        // Scanner input = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printBT(root);
        System.out.println("NO of NOdes : " + countNodes(root));
        System.out.println("No. of leaves : " + numLeaves(root));
        System.out.println("Largest Data : " + largestData(root));
        if(_ifBalanced.ifBalancedBetter(root)){
            System.out.println("Tree is balanced");
        }else{
            System.out.println("Tree is not Balanced");
        }

        System.out.println("Diameter = "+_diameter.diameter(root));


        System.out.println();
        _PrintLevelWise.printLevelWise(root);

    }
}
