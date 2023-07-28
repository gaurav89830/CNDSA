import java.util.*;
import java.lang.String;

public class Solution {
	public static boolean checkSequence(String s, String t) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
//      if(b.length() == 0)
//             return true;      
//      if(a.length() == 0)
//             return false;

        
//      if(a.charAt(0) == b.charAt(0)){
//             a = a.substring(1);
//             b = b.substring(1);
//         }else{
//             a = a.substring(1);
//         }
        
//         boolean ans = checkSequence(a,b);
        
//         return ans;
        
        
        
        
        
        
        		
     if(t.length() == 0)
            return true;      
     if(s.length() == 0)
            return false;

        
        char firstChar = t.charAt(0);
        int place = -1;
        for(int i = 0; i < s.length();i++){
            if(firstChar == s.charAt(i)){
                place = i;
                break;
            }
        }
        
        if(place == -1)
            return false;
            
        
        boolean smallAns = checkSequence(s.substring(place+1) , t.substring(1));
        
        return smallAns;
        
        
	}


    public class Main {
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
    
            String large = s.nextLine();
            String small = s.nextLine();
    
            System.out.println(Solution.checkSequence(large, small));
        }
}
}










// 		 */
//      if(t.length() == 0)
//             return true;      
//      if(s.length() == 0)
//             return false;

        
//         char firstChar = t.charAt(0);
//         int place = -1;
//         for(int i = 0; i < s.length();i++){
//             if(firstChar == s.charAt(i))
//                 place = i;
//         }
        
//         if(place<0)
//             return false;
            
        
//         boolean smallAns = checkSequence(s.substring(place) , t.substring(1));
        
//         return smallAns;