public class Solution {
    public static boolean checkAB(String str) {
        if(str.length() == 0){
            return true; 
        } 
        if(str.charAt(0) == 'a') {
            if(str.substring(1).length() > 1 && str.substring(1, 3).equals("bb")) { 
                // substring(1,3) means from index 1 to 2, means length of 2. therefore str.substring(1).length() > 1
                return checkAB(str.substring(3)); 
            } 
            else { 
                return checkAB(str.substring(1)); 
            } 
        } 
        
        return false; 
    
    } 
}
