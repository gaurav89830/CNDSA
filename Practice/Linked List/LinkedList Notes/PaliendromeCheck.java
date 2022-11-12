import java.util.*;
public class PaliendromeCheck {
	public static boolean isPalindrome(Node<Integer> head) {
     
        Node<Integer> temphead = head;
        int len =0; // null bhi count ho jayega isliye 
        
        while(temphead!=null){
            len++;
            temphead=temphead.next;
        }
        
        int mid;
        if(len%2==0){
            mid = len/2;
        }
        else
            mid = len/2+1;
        
        temphead = head;
        ArrayList<Integer> ans = new ArrayList<>();
        int count=0;
        while(temphead!=null){
            if(count>=mid){
                ans.add(temphead.data);
            }
            temphead= temphead.next;
            count++;
        }
        
        temphead = head;
        
        // boolean flag = false;
		 Collections.reverse(ans);
        for( int i = 0 ; i < len/2;i++){
            if(temphead.data.equals(ans.get(i)) == false){
                return false;
            }
            temphead = temphead.next;
        }
        return true;
	}

}