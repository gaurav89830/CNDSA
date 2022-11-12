public class swap2nodesLL {

	public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {
        // base cases
        if(j==i)
            return head;
        if(j < i){
            int temp = j;
            j = i ;
            i = temp;
        }
        if(j<0 || i < 0)
            return head;

        Node<Integer> temphead = head;
        Node<Integer> p1 = null;
        Node<Integer> p2 = null;
        Node<Integer> c1 = null;
        Node<Integer> c2 = null;
        

        int count = 0;
        while(temphead!=null){
            if(count + 1 == i){
                p1 = temphead;
            }
            if(count+1 == j){
                p2 = temphead;
            }
            if(count == i)
                c1 = temphead;
            
            if(count == j)
                c2 = temphead;
            
            temphead = temphead.next;
            count++;
        }
        
        
        if(j - i == 1 && i!=0){
            p1.next = c2;
            c1.next = c2.next;
            c2.next = c1;
        }
        else if( i == 0 && (j - i) != 1){
            p2.next = c1;
            c1.next = c2.next;
            c2.next = p2;
            return c2;
        }
        else if ( i == 0 && j - i == 1){
            c1.next = c2.next;
            c2.next = c1;
            return c2;
        }
        else{
            p1.next = c2;
            p2.next = c1;
            Node<Integer> temp = c1.next;
            c1.next = c2.next;
            c2.next = temp;
        }
        
        return head;
        
	}

}