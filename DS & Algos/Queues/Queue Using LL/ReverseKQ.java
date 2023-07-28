import java.util.LinkedList;
import java.util.Queue;

public class ReverseKQ {

	public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
    	// 1. simply rever till k
        // 2. now just pop len - k then push
        
        int len = input.size();
        reverse(input,k);
        for(int i = 0 ; i < len - k ; i++){
        	input.add(input.poll());
        }
        return input;
	}
    
    static void reverse(Queue<Integer> input, int k){
        if(k == 0)
            return;
        int temp = input.poll();
        reverse(input , --k);
        input.add(temp);
    }

}