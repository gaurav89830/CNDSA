import java.util.*;
class Sort{
    public static void MergeSort(int[] arr){
        split(arr, 0 , arr.length - 1);
    }

    public static void split(int[] arr , int sI , int eI){
        if(sI>eI)
            return;

        int mid = (sI + eI )/2;
        split(arr , sI , mid);
        split(arr , mid + 1 , eI)
        mergeBoth(arr , sI , eI);
    }

    public static void mergeBoth(int[] arr , int sI , int eI){
        int mid = (sI + eI)/2;
    }
    public static void main(String[] args) {
        int[] arr = {7,5,3,1,3,4,2};
        System.out.println(Arrays.toString(arr));
        MergeSort(arr)
        System.out.println(Arrays.toString(arr));
    }
}
