import java.util.*;
import java.io.*;

class Insertion {
    public static Node<Integer> insert(Node<Integer> head, int elem, int pos) {

        if (head == null)
            return head;
            
        if (pos == 0) {
            Node<Integer> newelem = new Node<>(elem);
            newelem.next = head;
            return newelem;
        }

        head.next = insert(head.next, elem, pos - 1);
        // head.next pass bhi kra hai toh store bhi kro
        return head;
    }


	public static Node<Integer> deleteNodeRec(Node<Integer> head, int pos) {
    	if(head == null)
            return head;
        
        if(pos == 0){
            return head.next;
        }
        
        head.next = deleteNodeRec(head.next,pos-1);
        return head;
	}

    // public static Node<Integer> reverse(Node<Integer> head , Node<Integer> ans){
    //     if(head == null)
    //     re
    // }

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

        // a1 = insert(a1, 99, 3);
        Node<Integer> b = null;
        // a1 = reverse(a1 , b);

        Node.printLL(a1);
    }
}