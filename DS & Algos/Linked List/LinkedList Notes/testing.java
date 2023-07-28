public class testing {
    public static Node<Integer> evenAfterOdd(Node<Integer> head) {
		Node<Integer> evenList = null;
		Node<Integer> evenListHead = null;
		Node<Integer> oddListHead = null;
		Node<Integer> oddList = null;
        
        while(head!=null){
            if(head.data % 2 != 0){ // odd case
                if(oddList == null){
                	oddList = head;
                    oddListHead = head;
                }
                else{
                	oddList.next = head;
                    oddList = oddList.next;
                    oddList.next = null;
                }
            }else{
                if(evenList == null){
               		evenList = head;
                    evenListHead = head;
                }
                else{
                	evenList.next = head;
                    evenList = evenList.next;
                    evenList.next = null;
                }
            }
            head = head.next;
        }
            // now one of evenList or OddList has no null
  
        
            // evenList.next = null;
            // oddList.next = evenListHead;
        
        
    	if(oddListHead == null)
            return evenListHead;
        else // flag
            return oddListHead;
            
            // evenList = evenListHead;
            // oddList = oddListHead;
			// now join both
            
            
//             while(oddList!=null){
                
//             }
            
            // return oddListHead;
//         

        
        
	}
}
