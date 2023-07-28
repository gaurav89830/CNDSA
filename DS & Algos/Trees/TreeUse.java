import java.util.*;

public class TreeUse {

    public static TreeNode<Integer> takeInput(Scanner input) {
        // Scanner input = new Scanner(System.in);
        // this func is recursive so scanner reset ho jata hai so one line input kaam
        // nhi krta kyuki wo old ata access hi nhi kr pata
        int n;
        System.out.println("Enter Next Node Data : ");
        n = input.nextInt();
        TreeNode<Integer> root = new TreeNode<>(n);
        System.out.println("Enter total Children");
        int childCount = input.nextInt();

        for (int i = 0; i < childCount; i++) {
            TreeNode<Integer> child = takeInput(input);
            root.children.add(child);
        }

        return root;

    }

    public static TreeNode<Integer> takeInputLevelwise() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter root data : ");
        int rootData = input.nextInt();
        TreeNode<Integer> root = new TreeNode<>(rootData);

        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        pendingNodes.enqueue(root);

        while (!pendingNodes.isEmpty()) {
            try {
                TreeNode<Integer> frontNode = pendingNodes.dequeue();
                System.out.println("Enter the number of children of " + frontNode.data);
                int totalChild = input.nextInt();
                for (int i = 0; i < totalChild; i++) {
                    System.out.println("Enter " + (i + 1) + "th children of " + frontNode.data);
                    TreeNode<Integer> child = new TreeNode<Integer>(input.nextInt());
                    frontNode.children.add(child);
                    pendingNodes.enqueue(child);
                }
            } catch (QueueEmptyException e) {
                // this will never execute
                e.printStackTrace();
                return null;
            }

        }

        return root;

    }

    public static void print(TreeNode<Integer> root) {
        String ans = root.data + ":";
        for (int i = 0; i < root.children.size(); i++) {
            ans = ans + root.children.get(i).data + ",";
        }
        System.out.println(ans);
        for (int i = 0; i < root.children.size(); i++) {
            print(root.children.get(i));
        }

    }

    public static void printLevelWise(TreeNode<Integer> root) { // ITERATIVE
        /*
         * Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Print output and don't return it.
         * Taking input is handled automatically.
         */
        if (root == null)
            return;

        Queue<TreeNode<Integer>> pendingChildren = new LinkedList<TreeNode<Integer>>();
        pendingChildren.add(root);
        pendingChildren.add(null);
        while (!pendingChildren.isEmpty()) {
            TreeNode<Integer> frontNode = pendingChildren.poll();
            if (frontNode == null) {
                if (pendingChildren.isEmpty()) {
                    break;
                }
                System.out.println();
                pendingChildren.add(null);
            } else {
                System.out.print(frontNode.data + " ");
                for (int i = 0; i < frontNode.children.size(); i++) {
                    // note in BT check if these are not null then add
                    pendingChildren.add(frontNode.children.get(i));
                }
            }
        }
    }

    public static int numofNodes(TreeNode<Integer> root) {
        if (root == null)
            return 0;
        int count = 1;
        for (int i = 0; i < root.children.size(); i++) {
            count += numofNodes(root.children.get(i));
        }
        return count;
    }

    public static int sumOfAllNode(TreeNode<Integer> root) {
        if (root == null)
            return Integer.MIN_VALUE;
        int total = 0;
        for (int i = 0; i < root.children.size(); i++) {
            total = total + sumOfAllNode(root.children.get(i));
        }
        return total + root.data;
    }

    public static int largestNum(TreeNode<Integer> root) {
        if (root == null)
            return Integer.MIN_VALUE;

        int largest = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            int x = largestNum(root.children.get(i));
            if (largest < x) {
                largest = x;
            }
        }
        return largest;
    }

    public static int numNodeGreater(TreeNode<Integer> root, int x) {
        int count = 0;
        if (root.data > x) {
            count = count + 1;
        }
        for (int i = 0; i < root.children.size(); i++) {
            count += numNodeGreater(root.children.get(i), x);
        }
        return count;

    }

    public static int getHeight(TreeNode<Integer> root) {
        if (root == null)
            return 0;

        int height = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int num = getHeight(root.children.get(i));
            if (height < num) {
                height = num;
            }
        }
        return height + 1;
    }

    public static void depthOfNode(TreeNode<Integer> root, int depth) {
        if (depth < 0)
            return;

        if (depth == 0) {
            System.out.print(root.data + " ");
            return;
        }

        for (int i = 0; i < root.children.size(); i++) {
            depthOfNode(root.children.get(i), depth - 1);
        }
    }

    public static int countLeafNodes(TreeNode<Integer> root) { // answer not confirmed with testcases
        if (root == null) {
            return 0;
        }
        if (root.children.size() == 0) {
            return 1;
        }
        int ans = 0;

        for (int i = 0; i < root.children.size(); i++) {
            ans += countLeafNodes(root.children.get(i));
        }

        return ans;
    }

    // traversals
    public static void printPostOrder(TreeNode<Integer> root) {
        if (root == null)
            return;
        for (int i = 0; i < root.children.size(); i++) {
            printPostOrder(root.children.get(i));
        }
        System.out.print(root.data + " ");
    }

    public static void printPreOrder(TreeNode<Integer> root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");

        for (int i = 0; i < root.children.size(); i++) {
            printPreOrder(root.children.get(i));
        }
    }

    public static void levelOrder(TreeNode<Integer> root) { // wrong
        if (root == null)
            return;
        System.out.println(root.data + " ");
        // for(int i = 0 ; i < root.children.size();i++){
        // System.out.println(root.children.get(i).data);
        // }
        for (int i = 0; i < root.children.size(); i++) {
            levelOrder(root.children.get(i));
        }

    }

    // checks if 2 Trees are identical

    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1.data != root2.data)
            return false;
        for (int i = 0; i < root1.children.size(); i++) {
            if (root1.children.size() != root2.children.size())
                return false;
            return checkIdentical(root1.children.get(i), root2.children.get(i));
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // TreeNode<Integer> root = new TreeNode<>(4);
        // TreeNode<Integer> node1 = new TreeNode<>(2);
        // TreeNode<Integer> node2 = new TreeNode<>(3);
        // TreeNode<Integer> node3 = new TreeNode<>(5);
        // TreeNode<Integer> node21 = new TreeNode<>(6);

        // root.children.add(node1);
        // root.children.add(node2);
        // root.children.add(node3);

        // node2.children.add(node21);
        // System.out.println("hello");

        TreeNode<Integer> root = takeInputLevelwise();
        printPreOrder(root);
        System.out.println();
        printPostOrder(root);
        System.out.println();
        levelOrder(root);
        System.out.println("\nNumber of Nodes: " + numofNodes(root));
        System.out.println("Sum of Nodes: " + sumOfAllNode(root));
        System.out.println("Largest of Nodes: " + largestNum(root));
        System.out.println(" Nodes greater than x " + numNodeGreater(root, 10));
        System.out.println(" Tree Height " + getHeight(root));
        System.out.println(" Total Leaf Nodes " + countLeafNodes(root));

        System.out.println(" Nodes @ Depth k ");
        depthOfNode(root, 2);

    }
}

// 10 3 20 30 40 2 40 50 0 0 0 0