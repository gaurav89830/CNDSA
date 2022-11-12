public class solution {

	// Return a string array that contains all the possible strings
	public static String[] keypad(int n){
    String[] list ={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    if(n == 0 || n==1){
        String temp[] = {""};
        return temp;
    } 
    
    int num = n%10;
    
    
    
    String smallAns[] = keypad(n/10);
    String finalAns[] = new String[smallAns.length * list[num].length()];
    int k = 0;
    
	for(int j = 0 ; j < list[num].length();j++)
    for(int i = 0 ; i < smallAns.length;i++){
        finalAns[k] =  smallAns[i] + list[num].charAt(j);
        k++;
    }
        // for(int i = 0 ; i < finalAns.length;i++){
        //     finalAns[i] = StringFormatter.reverseString(finalAns[i]);
        // }
        return finalAns;
	}
	
}

