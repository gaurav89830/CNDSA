/*

	Following is the Node class already written for the Linked List

	class Node<T> {
    	T data;
    	Node<T> next;
    
    	public Node(T data) {
        	this.data = data;
    	}
	}

*/

public class bubbleSort {

	public static Node<Integer> bubbleSort(Node<Integer> head) {
        
        if(head == null || head.next == null)
            return head;
        
        
        Node<Integer> prev = head;
        Node<Integer> next = head.next;
        Node<Integer> tempHead = head;
        
        int len = 1;
        while(tempHead!=null){
            len++;
            tempHead = tempHead.next;
        }
        
        // user a better approach , instead of going to the end of LL again n again, decrease the last one each step ??????
        
        while(len!=0){
        next = head.next;
        prev = head;
        while(next!=null){
            if(prev.data > next.data){
                int temp = prev.data;
                prev.data = next.data;
                next.data = temp;
            }
            prev = prev.next;
            next = next.next;
        }
            len--;
        }
        return head;
	}
}