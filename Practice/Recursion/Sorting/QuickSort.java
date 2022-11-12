
public class Solution {
	
	public static void quickSort(int[] input) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * No need to print or return the output.
		 * Taking input and printing output is handled automatically.
		 */
        int sI = 0;
        int eI = input.length-1;
		quickSort2( input , sI , eI);
	}
    
    private static void quickSort2(int[] input , int sI , int eI){
        if(sI>=eI)
            return;
        
        int pivot = partition(input,sI,eI);
        quickSort2(input,sI,pivot-1);
        quickSort2(input,pivot+1,eI);
        
    }
    
    private static int partition(int[] input, int sI , int eI){
        int count=0;
        
        for (int i = sI+1; i <= eI; i++) {
            if (input[i] <= input[sI])
                count++;
        }
        
        //swap 
        int temp = input[sI + count];
        input[sI + count] = input[sI];
        input[sI] = temp;
        
        //move
        int pivot = count + sI;
        int i=sI,j=eI;
        
        while(i < pivot && j > pivot ){
            if(input[i] <= input[pivot]){
                i++;
            }
            else if(input[j] > input[pivot]){ // >= ???
                j--;
            }
            
        else {
                int temp2 = input[i];
                input[i] = input[j];
                input[j] = temp2;
                i++;j--;
            }
        }
        
        return sI + count;   
    }
	
}