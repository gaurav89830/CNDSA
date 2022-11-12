import java.io.*;

class nodeData {
    public Node<Integer> head = null;
    public Node<Integer> tail = null;
}

public class reverseLL {

    // iterative
	public static Node<Integer> reverse_I(Node<Integer> head){
        
        if(head == null || head.next ==null)
            return head;
        
        Node<Integer> prev = head;
        Node<Integer> current = head.next;
        
        while(current.next!=null){
            // next save kro 
            Node<Integer> nextElemtemp = current.next;
            
            current.next = prev;
            prev = current;
            current = nextElemtemp;
        }
        current.next = prev;
        head.next = null;
        
        return current;
        
	}






    //best approach 

    public static Node<Integer> reverseLLBestnEasy(Node<Integer> head) {
        if (head == null || head.next == null)
            return head;

        // func call se phele hi tail ko save krle 1 2 3 4 mein se 2 hi toh tail hai ( 1 , 4 3 2).

        Node<Integer> tail = head.next;

        Node<Integer> smallAns = reverseLLBestnEasy(head.next);

        tail.next = head;
        head.next = null;

        return smallAns;
    }

    // this is of n complexity time

    public static Node<Integer> reverseLinkedListRec_improved(Node<Integer> head) {

        nodeData y = reverseLinkedListRec_improved_helper(head);

        return y.head;
    }

    public static nodeData reverseLinkedListRec_improved_helper(Node<Integer> head) {
        if (head == null || head.next == null) {
            nodeData r = new nodeData();
            r.head = head;
            r.tail = head;
            return r;
        }

        nodeData smallAns = reverseLinkedListRec_improved_helper(head.next);
        smallAns.tail.next = head;
        head.next = null;

        nodeData ans = new nodeData();
        ans.head = smallAns.head;
        ans.tail = head;

        return ans;
    }

    // this is of n^2 complexity time
    public static Node<Integer> reverseLinkedListRec(Node<Integer> head) {
        if (head == null || head.next == null)
            return head;

        Node<Integer> newHead = reverseLinkedListRec(head.next);
        Node<Integer> temp = newHead;

        while (temp.next != null)
            temp = temp.next;

        temp.next = head;

        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        {
            try {
                System.setIn(new FileInputStream("input.txt"));
                System.setOut(new PrintStream(new FileOutputStream("output.txt")));
            } catch (Exception e) {
                System.err.println("Error");
            }
        }
        Node<Integer> a1 = new Node<>(0);
        Node<Integer> a2 = new Node<>(4);
        Node<Integer> a3 = new Node<>(3);
        Node<Integer> a4 = new Node<>(6);
        Node<Integer> a5 = new Node<>(8);
        Node<Integer> a6 = new Node<>(90);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = null;

        Node.printLL(a1);

        a1 = reverse_I(a1);

        Node.printLL(a1);
    }
}
