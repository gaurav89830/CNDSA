import java.io.*;;
class Solution {
    public static String[] CalcsubString(String input){
        if(input.length() == 0){
            String[] a = {""};
            return a;
        }
        
        String[] smallAns = CalcsubString(input.substring(1));
        String[] finalAns = new String[2*smallAns.length];
        int k = 0;
        for(int i = 0 ; i < smallAns.length ; i++){
            finalAns[i] = smallAns[i];
            k++;
        }
        for(int i = 0 ;i <  smallAns.length;i++){
            finalAns[k] = input.charAt(0) + smallAns[i];
            k++;
        }
        
        return finalAns;
    }
    
    public static void main(String[] args) {
        {
            try {
                System.setIn(new FileInputStream("input.txt"));
                System.setOut(new PrintStream(new FileOutputStream("output.txt")));
            } catch (Exception e) {
                System.err.println("Error");
            }
        }
        
        String input = "xero";
        String list[] = CalcsubString(input);
        for(int i= 0; i<list.length ;i++)
        System.out.println(list[i]);
    }
}

