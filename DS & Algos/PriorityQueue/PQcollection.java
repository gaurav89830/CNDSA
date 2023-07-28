import java.util.PriorityQueue;
import java.util.Comparator;

/*
 * The default PriorityQueue is implemented with Min-Heap, that is the top element is the minimum one in the heap.

In order to implement a max-heap, you can create your own Comparator:




So, you can create a min-heap and max-heap in the following way:

PriorityQueue minHeap=new PriorityQueue();
PriorityQueue maxHeap=new PriorityQueue(size, new MyComparator());
 */

class MyComparator implements Comparator<Integer> {
    public int compare(Integer x, Integer y) { // i don't know how this works , i mean kis ko kya priority de .
        return y - x;
        // trick ( x, y ) is in the parameter , so for accending its x - y
        // and for decending its y - x
    }
}

class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) { // minHeap

        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        } else {
            return 0;
        }
    }

}

class PQcollection {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        MyComparator mycomparator = new MyComparator();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(mycomparator);

        // not only this we can create pq for string and set the comparator this way
        // that the priority is according to length of string

    }
}
