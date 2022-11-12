// insertion and deletion is both O(n) 
public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree root = new BinarySearchTree();
        root.insertData(2);
        root.insertData(3);
        root.insertData(1);
        // root.print();
        root.hasData(2);
        root.print();
    }

    private BinaryTreeNode<Integer> root;

    // insertDATA implementation

    public void insertData(int data) {
        root = insertData(data, root);
    }

    public BinaryTreeNode<Integer> insertData(int data, BinaryTreeNode<Integer> root) {
        if (root == null) {
            BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<Integer>(data);
            return newRoot;
        }
        if (data < root.data) {
            root.left = insertData(data, root.left);
        } else {
            root.right = insertData(data, root.right);
        }
        return root;
    }

    // deleteDATA implementation

    public void deleteData(int data) {
        root = deleteData(data, root);
    }

    private BinaryTreeNode<Integer> deleteData(int data, BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null; // not found
        }

        if (data < root.data) {
            root.left = deleteData(data, root.left);
            return root;
        } else if (data > root.data) {
            root.right = deleteData(data, root.right);
            return root;
        } else {
            // yeh wala case hai jisme data root k equal hai .
            // so spproach is this
            // 1. Find the min of right node
            // 2. then root.data = newNode.data ,
            // 3. Now delte newNode.

            // but if either side of root is null then just return the not null side .

            if (root.right == null && root.left == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // now finding the min element in the root.right
                BinaryTreeNode<Integer> minNode = root.right;
                while (minNode.left != null) {// coz right wale tree mein left wala hi toh small hoga na simple
                    minNode = minNode.left;
                }
                root.data = minNode.data;
                root.right = deleteData(minNode.data, root.right);
                return root;
            }
        }
    }

    // hasDATA implementation
    public boolean hasData(int data) {
        return hasData(data, root);
    }

    private boolean hasData(int data, BinaryTreeNode<Integer> root) {
        if (root == null) {
            return false;
        }

        if (root.data == data) {
            return true;
        } else if (root.data > data) {
            return hasData(data, root.left);
        } else {
            return hasData(data, root.right);
        }
    }

    // print implementation
    public void print() {
        printBT(root);
    }

    private void printBT(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        String output = new String();

        output = root.data + ":";
        if (root.left != null) {
            output += "L:" + root.left.data + ",";
        }
        if (root.right != null) {
            output += "R:" + root.right.data;
        }

        System.out.println(output);

        printBT(root.left);
        printBT(root.right);
    }

}
