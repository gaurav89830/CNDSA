import javax.swing.InputMap;

public class mergeSort {
    public static Node<Integer> midpt(Node<Integer> head){
        Node<Integer> slow =head;
        Node<Integer> fast = head.next;

        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    private static Node<Integer> merge2LL(Node<Integer> part1 , Node<Integer> part2){
        Node<Integer> ansHead = null;

        if(part1==null)
            return part2;
        if(part2==null)
            return part1;
        
        if(part1.data < part2.data){
            ansHead = part1;
            part1 = part1.next;
        }
        else{
            ansHead = part2;
            part2 = part2.next;
        }

        Node<Integer> ans = ansHead;
        while(part1!=null && part2!=null){
            if(part1.data < part2.data){
                ans.next = part1;

                ans = ans.next;
                part1 = part1.next;
            }else{
                ans.next = part2;

                ans = ans.next;
                part2 = part2.next;
            }
        }

        if(part1!=null)
        ans.next = part1;

        if(part2!=null)
        ans.next = part2;

        return ansHead;
    }
    public static Node<Integer> mergeSortLL(Node<Integer> head){
        if(head==null || head.next==null)
            return head;
        
        Node<Integer> midNode = midpt(head);
        Node<Integer> LL2 = midNode.next;
        midNode.next = null;

        Node<Integer> part1 = mergeSortLL(head);
        Node<Integer> part2 = mergeSortLL(LL2);

        Node<Integer> ans = merge2LL(part1 , part2);

        return ans;
    }

    public static void main(String[] args) {
        Node<Integer> n1 = new Node<Integer>(5);
        Node<Integer> n2 = new Node<Integer>(4);
        Node<Integer> n3 = new Node<Integer>(2);
        Node<Integer> n4 = new Node<Integer>(3);
        Node<Integer> n5 = new Node<Integer>(1);
        Node<Integer> n6 = new Node<Integer>(1000);
        Node<Integer> n7 = new Node<Integer>(-1);
        Node<Integer> n8 = new Node<Integer>(45);
        
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = null;

        n1 = mergeSortLL(n1);

        Node.printLL(n1);

    }
}
