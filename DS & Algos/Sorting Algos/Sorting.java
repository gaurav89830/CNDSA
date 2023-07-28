import java.util.*;

class Sorting {

    public static void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    Swap(arr, j, j + 1);
                }
            }
        }
        // return arr;
    }

    public static void SelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            // boolean flag = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                    // flag = true;
                }
            }
            // we can also uncomment the lines of code here and above, just increases somw
            // steps as it swaps even when noelement is smaller than current element in
            // array.
            // if(flag){
            Swap(arr, i, min);
            // }
        }
    }

    public static void InsertionSort(int[] arr) {
        // best case O(n)
        // worst Case O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i;
            while (j >= 0 && arr[j + 1] < arr[j]) {
                Swap(arr, j, j + 1);
                j--;
            }
        }
    }

    // -------------------MERGE SORT-----------------------
    public static void MergeSort(int[] arr) {
        split(arr, 0, arr.length - 1);
    }

    private static void split(int[] arr, int sI, int eI) {

        if (sI >= eI)
            return;

        int mid = (sI + eI) / 2;

        split(arr, sI, mid);
        split(arr, mid + 1, eI);

        merge(arr, sI, eI);
    }

    private static void merge(int[] arr, int sI, int eI) {
        int mid = (sI + eI) / 2;

        int[] temp = new int[(eI + 1) - sI];

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

        for (int x = 0; x < temp.length; x++)
            arr[sI + x] = temp[x];

    }

    // ------------------QUICK SORT------------------------

    public static void QuickSort(int[] arr) {
        QuickSort2(arr, 0, arr.length - 1);
    }

    private static void QuickSort2(int[] arr, int sI, int eI) {
        if (sI >= eI)
            return;

        int pivot = partition(arr, sI, eI);

        QuickSort2(arr, sI, pivot);
        QuickSort2(arr, pivot + 1, eI);
    }

    private static int partition(int[] arr, int sI, int eI) {
        int count = 0; // no of elements smaller than first element / pivot

        for (int i = sI + 1; i <= eI; i++) { // + 1 coz dont compare 1st element
            if (arr[i] <= arr[sI])
                count++;
        }
        // swapping
        int temp = arr[sI + count];
        arr[sI + count] = arr[sI];
        arr[sI] = temp;

        int i = sI, j = eI;
        int pivot = count + sI;

        while (i < pivot && j > pivot) { // important step
            if (arr[i] <= arr[pivot])
                i++;
            else if (arr[j] > arr[pivot])
                j--;
            else {
                int temp2 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp2;
                i++;
                j--;
            }
        }

        return pivot;

    }

    // ------------------------------------------------

    public static void Swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    static public long t1 = System.currentTimeMillis();

    public static void printTimetaken() {
        System.out.printf("\n \n ___________________________ \n\n");
        System.out.println("    Time taken : " + (System.currentTimeMillis() - t1) + " ms");
        System.out.println(" ___________________________ ");

    }
    // ------------------------------------------------

    public static void main(String[] args) {
        // clrscr();
        int[] arr = { 100, 4, 5, 3, 1, 2, 88 };
        QuickSort(arr);
        System.out.println(Arrays.toString(arr));
        printTimetaken();
    }
}