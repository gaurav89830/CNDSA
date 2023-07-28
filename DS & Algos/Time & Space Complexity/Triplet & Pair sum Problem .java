import java.util.*;
public class Solution {	
    public static int pairSum(int[] arr, int num, int sI,int eI){
    // Arrays.sort(arr);
    
  
    int ans = 0;
    while(sI<eI){

        if(arr[sI] + arr[eI] > num)
            eI--;
        else if(arr[sI] + arr[eI] < num)
            sI++;
        else{
            int firstElement = arr[sI];
            int lastElement = arr[eI];
            
            if(firstElement == lastElement){
                int repeatedCase = eI - sI + 1; // +1 bcoz 0 indexing
                 ans += (repeatedCase)*(repeatedCase-1)/2;
                return ans;
            }
            
            int tempsI = sI + 1;
            int tempeI = eI - 1;
            
            while(tempsI <= tempeI && arr[tempsI] == arr[sI]){
                tempsI++;
            }
            
            while(tempeI>=tempsI && arr[tempeI] == arr[eI]){
                tempeI--;
            }
            
            int sameStartingElements = tempsI - sI;
            int sameEndingElements = eI - tempeI;
            
            
            
            ans += sameStartingElements*sameEndingElements;
            
            eI = tempeI;
            sI = tempsI;
        }
    }
            return ans;

}
	public static int tripletSum(int[] arr, int target) {
        Arrays.sort(arr);

        int count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            int toFind = target - arr[i];
            int numPairs = pairSum(arr ,toFind, i+1 , arr.length-1 );
            count=count+ numPairs;
        }
        return count;
	}
}
