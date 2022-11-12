public class solution {


	public static int[][] subsetsSumK(int input[], int k) {
        
        return subsetsSumK2(input,k,0);
	}
    
    private static int[][] subsetsSumK2(int input[], int target , int sI){

        if(sI==input.length)
        {
            if(target==0)
                return new int[1][0];
            else
                return new int[0][0];
        }

        
        int[][] smallAns1 = subsetsSumK2(input,target-input[sI],sI + 1);
        int[][] smallAns2 = subsetsSumK2(input,target,sI + 1);
        
        int[][] finalAns = new int[smallAns1.length + smallAns2.length][];
        int k =0;
        
        for(int row = 0 ; row < smallAns1.length;  row++){
            finalAns[row] = new int[smallAns1[row].length + 1];
            finalAns[row][0] = input[sI];
            k++;
            for(int col = 0 ; col < smallAns1[row].length; col++){
                finalAns[row][col+1] = smallAns1[row][col];
            }
        }
        
        
        for(int row = 0 ; row < smallAns2.length; row++){
            finalAns[row + k] = new int[smallAns2[row].length];
            for(int col = 0 ; col < smallAns2[row].length;col++){
                finalAns[row+k][col] = smallAns2[row][col];
            }
        }
        
        return finalAns;

    }
}
