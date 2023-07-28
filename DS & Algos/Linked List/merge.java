import java.util.*;
import java.io.*;

class merge {

    private static void mergeArr(int[] arr, int sI, int eI) {
        int temp[] = new int[eI + 1 - sI];
        int mid = (sI + eI) / 2;
        int i = sI, j = mid + 1, k = 0;

        while (i <= mid && j <= eI) {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= eI)
            temp[k++] = arr[j++];

        for (int x = 0; x < temp.length; x++) {
            arr[sI + x] = temp[x];
        }
    }

    public static void mergeSort(int[] arr, int sI, int eI) {
        if (sI >= eI)
            return;

        int mid = (sI + eI) / 2;

        mergeSort(arr, sI, mid);
        mergeSort(arr, mid + 1, eI);
        mergeArr(arr, sI, eI);
    }

    public static void quickSort(int[] arr, int sI, int eI) {
        if (sI >= eI)
            return;

        int pivot = partition(arr, sI, eI);

        quickSort(arr, sI, pivot - 1); // pivot is on the right place
        quickSort(arr, pivot + 1, eI);
    }

    private static int partition(int[] arr, int sI, int eI) {
        int count = 0;
        for (int i = sI + 1; i <= eI; i++) {
            if (arr[i] <= arr[sI])
                count++;
        }

        // swapping
        int temp = arr[sI];
        arr[sI] = arr[sI + count];
        arr[sI + count] = temp;

        // balancing the array

        int i = sI, j = eI;
        int pivot = count + sI;// imp step
        while (i < pivot && j > pivot) {
            if (arr[i] <= arr[pivot])
                i++;
            else if (arr[j] > arr[pivot])
                j--;
            else {
                // both are at wrong place
                // swapping
                int temp2 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp2;
                i++;
                j--;
            }
        }
        // return count + sI;
        return pivot;

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

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        // mergeSort(arr, 0, n - 1);
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}