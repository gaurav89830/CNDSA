public class solution {

	// element - number to be searched
	public static int binarySearch(int input[], int element) {
        return binarySearch2(input,element,0,input.length-1);
	}
    
    private static int binarySearch2(int[] input, int element, int sI, int eI){
        if(sI > eI)
            return -1;
        
        int mid = sI + (eI - sI)/2;
        
        if(input[mid] == element){
            // while(mid > sI && input[mid-1] == element){
            //     mid--;
            // }
            return mid;
        }
        
        if(input[mid] < element){
            return binarySearch2(input,element,mid+1,eI);
        }
        else
        	return binarySearch2(input,element,sI,mid-1);
        
    }
}

