import java.util.*;
import java.lang.String;

public class solution {

	// Return a string array that contains all possible codes
	public static  String[] getCode(String input){
		// Write your code here
		return getCode2(input,0);
	}

    private static String[] getCode2(String input, int sI){
        boolean flag = false;
        int k = 0;
        
        if(input.length()==0){
            String ans[]={""};
            return ans;
        }
        
        // String[] oneDigitAns = getCode2(input.substring(1),sI + 1);
        
        if( input.length() >= 2 && Integer.parseInt(input.substring(0,2))<= 26 && Integer.parseInt(input.substring(0,2))>=10 ){
        // String[] twoDigitAns = getCode2(input.substring(2),sI + 2);
        flag = true;
        }
        
        if(flag){
        String[] oneDigitAns = getCode2(input.substring(1),sI + 1);
        String[] twoDigitAns = getCode2(input.substring(2),sI + 2);
        String[] ans = new String[oneDigitAns.length + twoDigitAns.length];
        char a = (char)(Integer.parseInt(input.substring(0,1)) + 96);
        
        for(int i = 0 ; i < oneDigitAns.length ; i++){
            ans[i] = a + oneDigitAns[i];
            k++;
        }
        
        char b = (char)(Integer.parseInt(input.substring(0,2)) + 96);
        for(int i = 0 ; i < twoDigitAns.length ; i++){
            ans[i + k] = b + twoDigitAns[i];
        }
            return ans;
        }
        
        else{
        String[] oneDigitAns = getCode2(input.substring(1),sI + 1);
        String[] ans = new String[oneDigitAns.length];
        char a = (char)(Integer.parseInt(input.substring(0,1)) + 96);
        for(int i = 0 ; i < oneDigitAns.length ; i++){
            ans[i] = a + oneDigitAns[i];
        }
        return ans;
        }
    }
}

