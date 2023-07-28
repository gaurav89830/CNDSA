public class BSTtoSortedLinkedList {
    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        Answer ans = helper(root);
        return ans.head;
    }

    public static Answer helper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            Answer ans = new Answer();
            ans.head = null;
            ans.tail = null;
            return ans;
        }

        Answer leftOutput = helper(root.left);
        LinkedListNode<Integer> newNode = new LinkedListNode<>(root.data);
        Answer rightOutput = helper(root.right);

        Answer ans = new Answer();

        // this is the important logic
        if (leftOutput.head != null) {
            ans.head = leftOutput.head; // left daal dia
            leftOutput.tail.next = newNode;
        } else {
            ans.head = newNode; // agar left hai hi nhi toh root dalo ab
        }

        newNode.next = rightOutput.head; // left ho gya tha then root bhi , ab right ki baari

        if (rightOutput.head == null) {
            ans.tail = newNode;
        } else {
            ans.tail = rightOutput.tail;
        }

        return ans;
    }
}

class Answer {
    LinkedListNode<Integer> head;
    LinkedListNode<Integer> tail;
}

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    LinkedListNode(T elem) {
        data = elem;
    }
}
