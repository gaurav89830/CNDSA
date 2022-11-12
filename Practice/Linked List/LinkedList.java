
import java.util.*;
import java.io.*;

public class LinkedList{

    public static Node<Integer> deleteNode(Node<Integer> head, int pos) {
        Node<Integer> temp = head;


        if(head == null)
            return head;
        if(pos == 0){
            head = head.next;
            return head;
        }
        
        int count = 0 ;
        while(temp!=null && count < pos - 1){
            count++; 
            temp = temp.next;
        }
        
        if(temp == null || temp.next == null)
            return head;
        
        temp.next = temp.next.next;
        
        return head;
        
	}

    public static Node<Integer> insert(Node<Integer> input , int index , int value){
        Node<Integer> original = input;
        //  boolean ifzeroindex  = false; 
        // if( index == 0){
        //     ifzeroindex = true;
        //     index = 1;
        // }

        if(index == 0){
            Node<Integer> newElem = new Node<Integer>(value);
            newElem.next = input;
            return newElem;
        }

        for( int i = 0 ; i < index - 1; i++){
            input = input.next;

        }
        Node<Integer> newElem = new Node<Integer>(value);
        newElem.next = input.next;

        input.next = newElem;
        // if(ifzeroindex){
        //     int temp = original.data;
        //     Node<Integer> hehe = original;
        //     hehe = hehe.next;
        //     original.data = hehe.data;
        //     hehe.data = temp; 
        // }

        return original;
    }

    public static Node<Integer> input(){
        Scanner in = new Scanner(System.in);

        Node<Integer> head = null;
        Node<Integer> tail = null;
        int data = in.nextInt();

        while(data!=-1){
            Node<Integer> newNode = new Node<>(data);
            if(head == null){
                head = newNode;
                tail = newNode;
            }else{
                tail.next = newNode; 
                tail = newNode;
            }
            data = in.nextInt();
        }

        return head;
    }

    public static<T> void printLL(Node<T> Head ){
        Node<T> tempHead = Head;

        while(tempHead!=null){
            System.out.print(tempHead.data + " ");
            tempHead = tempHead.next;
        }
        System.out.println();
    }


    // public static void increment(Node<Integer> head){
    //     Node<Integer> temp = head;
    //     while(temp != null){
    //         temp.data++;
    //         temp = temp.next;
    //     }
    // }

    // public static void reverseLL2(Node<Integer> head , Node<Integer> prevaddr,int len , Node<Integer> newerhead){

    //     if(head == null)
    //     return;

    //     if(len <= 0){
    //         newerhead = head;
    //         return;
    //     }
    //     reverseLL2(head.next , head , len-1,newerhead);

    //     head.next = prevaddr;

    //     if(len==5)
    //     return;
    // }

    // public static Node<Integer> reverseLL(Node<Integer> head){
    //     Node<Integer> newhead = head;

    //     while(newhead.next!=null){
    //         newhead=newhead.next;
    //     }
    //     Node<Integer> newerhead = head;
    //     reverseLL2(head.next , head , 6 , newerhead); // next elem , apna addr
    //     Node<Integer> newerhead2 = head;

    //     int a = 6;

    //     while(a>0){
    //         a--;
    //         newerhead = newerhead.next;
    //     }
    //     newerhead.next = null;
    //     return newerhead2;
    // }



        // public static boolean isPalindrome(Node<Integer> head) {
         
        //     Node<Integer> temphead = head;
        //     int len =0; // null bhi count ho jayega isliye 
            
        //     while(temphead!=null){
        //         len++;
        //         temphead=temphead.next;
        //     }
            
        //     int mid;
        //     if(len%2==0){
        //         mid = len/2;
        //     }
        //     else
        //         mid = len/2+1;
            
        //     temphead = head;
        //     ArrayList<Integer> ans = new ArrayList<>();
        //     int count=0;
        //     while(temphead!=null){
        //         if(count>=mid){
        //             ans.add(temphead.data);
        //         }
        //         temphead= temphead.next;
        //         count++;
        //     }
            
        //     temphead = head;
            
        //     // boolean flag = false;
        //     System.out.println(ans);
        //     for( int i = 0 ; i < len/2;i++){
        //         if(temphead.data.equals(ans.get(i)) == false){
        //             return false;
        //         }
        //         temphead = temphead.next;
        //     }
        //     return true;
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


    // Node<Integer> n1 = new Node<>(10);
    // Node<Integer> n2 = new Node<>(20);
    // Node<Integer> n3 = new Node<>(30);
    // n1.next = n2;
    // n2.next = n3;

    // Node<Integer> Head = n1;
    // increment(Head);

    Node<Integer> Head = input();  // to take input.

    printLL(Head);  // array mein refference pass hota hai , isme copy send hogi 
    // Head = insert(Head, 1, 70);
    // printLL(Head);

    // Head = reverseLL(Head);

    // printLL(Head);
    // System.out.println(isPalindrome(Head));

    }
}