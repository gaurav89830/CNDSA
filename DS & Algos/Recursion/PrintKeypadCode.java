public class solution {

	public static void printKeypad(int input){
    String[] list ={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        printKeypad2(input,list," ");
	}
    
    public static void printKeypad2(int input, String[] list, String outputSoFar){
            
    if(input == 0 || input==1){
        System.out.println(outputSoFar);
        return;
    }
        
        int rem = input % 10;
        
        for(int i = 0; i < list[rem].length(); i++){
            
            printKeypad2(input/10,list,list[rem].charAt(i)+outputSoFar);
            
        }
        
    }
}

