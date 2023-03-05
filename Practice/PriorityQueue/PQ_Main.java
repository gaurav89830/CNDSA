public class PQ_Main {
    public static void main(String[] args) {
        PQ pq = new PQ();

        int arr[] = { 5, 1, 9, 2, 0 };

        for (int i = 0; i < arr.length; i++) {
            pq.insert(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            try {
                System.out.print(pq.removeMin() + " ");
            } catch (Exception e) {
            }

        }
    }
}