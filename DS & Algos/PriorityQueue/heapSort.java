public class heapSort {
    // lets imliment a maxHeap
    private static void addToHeap(int[] arr, int i) {
        int childIndex = i; // new element child rhega then parent calc hoga
        int parentIndex = (i - 1) / 2;

        while (childIndex > 0) {
            if (arr[parentIndex] < arr[childIndex]) {
                int temp = arr[parentIndex];
                arr[parentIndex] = arr[childIndex];
                arr[childIndex] = temp;

                // now lets update the pointers
                childIndex = parentIndex; // upheapify hai na bro, upr hi toh jayega
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    private static int removeFromHeap(int[] arr, int heapSize) {
        int removed = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;

        int index = 0;
        int rightChildIndex = 2 * index + 2;
        int leftChildIndex = 2 * index + 1;

        while (leftChildIndex < heapSize) {
            int maxElemIndex = index;

            if (arr[leftChildIndex] > arr[maxElemIndex]) {
                maxElemIndex = leftChildIndex;
            }
            if (leftChildIndex < heapSize && arr[rightChildIndex] > arr[maxElemIndex]) {
                maxElemIndex = rightChildIndex;
            }

            if (maxElemIndex == index) {
                break;
            } else {
                int temp = arr[index];
                arr[index] = arr[maxElemIndex];
                arr[maxElemIndex] = temp;

                index = maxElemIndex;
                leftChildIndex = 2 * index + 1;
                rightChildIndex = 2 * index + 2;
            }
        }

        return removed;
    }

    public static void inplaceHeapSort(int arr[]) {
        /*
         * Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Change in the given input itself.
         * Taking input and printing output is handled automatically.
         */

        for (int i = 0; i < arr.length; i++) {
            addToHeap(arr, i);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - 1 - i] = removeFromHeap(arr, arr.length - i);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        inplaceHeapSort(new int[] { 21, 33, 4, 23, 6, 42, 3 });
    }
}