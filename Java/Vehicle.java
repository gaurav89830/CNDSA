
public class Vehicle {

	public static int countZerosRec(int input){
		// Write your code here
        boolean flag = false;
        int sum = 0;
        if(input == 0)
            return 1;
        return countZeroesRec2( input ,  flag , sum);
	}
    private static int countZeroesRec2(int input , boolean flag , int ans){
        if(input == 0)
            return ans;
        int rem = input % 10;
        if(rem == 0){
            ans++;
        }
        
        ans  =  countZeroesRec2(input/10 , flag , ans);
        return ans;
    }


        public static void main(String[] args) {
            int n = 1002020;
            System.out.println(Vehicle.countZerosRec(n));
        }
    

}
