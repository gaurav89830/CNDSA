import java.util.*;
import java.io.InputStream;
public class Solution {
    
    public static void selectionSort(int[] arr){
        for(int i = 0 ; i< arr.length - 1;i++){
            int min = i;
            
            for(int j = i + 1 ; j < arr.length; j++){
                if(arr[j] < arr[min] )
                    min = j;
            }
            
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
	public static int findDuplicate(int[] arr) {
        selectionSort(arr);
        
        for(int i = 0 ; i< arr.length - 1;i++){
            if(arr[i] == arr[i+1])
                return arr[i];
        }
        return -1;
	}



    public static void main(String[] args) throws NumberFormatException {
        int[] input = {5 ,5, 1, 6, 8, 3, 0, 2 ,7 ,4}; 
        
        	System.out.println(Solution.findDuplicate(input));
    }
}