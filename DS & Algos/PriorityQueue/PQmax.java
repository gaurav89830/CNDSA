import java.util.ArrayList;

public class PQmax {

    private ArrayList<Integer> heap;

    public PQmax() {
        heap = new ArrayList<Integer>();
    }

    boolean isEmpty() {
        return heap.size() == 0;
    }

    int size() {
        return heap.size();
    }

    int getMax() throws PriorityQueueException {
        if (isEmpty()) {
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex) > heap.get(parentIndex)) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    int removeMax() throws PriorityQueueException {
        // Complete this function
        // Throw the exception PriorityQueueException if queue is empty
        if (heap.size() == 0) {
            throw new PriorityQueueException();
        }

        int deletedElem = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        // now compare with both left and right nodes and find which one is smaller
        int leftChildIndex = 1; // initially
        int rightChildIndex = 2; // initially
        int minIndex = 0;
        int index = 0;

        // dono child left right mein se chhota dhundo and minindex update kro
        while (leftChildIndex < heap.size()) {
            if (heap.get(leftChildIndex) > heap.get(minIndex)) {
                minIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(minIndex)) {
                minIndex = rightChildIndex;
            }

            if (minIndex == index) {
                break;
            } else {
                int swaptemp = heap.get(index);
                heap.set(index, heap.get(minIndex));
                heap.set(minIndex, swaptemp);

                // update index
                index = minIndex;
                leftChildIndex = 2 * index + 1;
                rightChildIndex = 2 * index + 2;
            }
        }
        return deletedElem;

    }
}

/*
 * 
 * rough submitted code
 * import java.util.*;
 * class PQ {
 * private ArrayList<Integer> heap;
 * 
 * public PQ() {
 * heap = new ArrayList<Integer>();
 * }
 * 
 * boolean isEmpty() {
 * return heap.size() == 0;
 * 
 * }
 * 
 * int getSize() {
 * return heap.size();
 * 
 * }
 * 
 * int getMax(){
 * // if (isEmpty()) {
 * // throw new PriorityQueueException();
 * // }
 * return heap.get(0);
 * }
 * 
 * void insert(int element) {
 * heap.add(element);
 * int childIndex = heap.size() - 1;
 * int parentIndex = (childIndex - 1) / 2;
 * 
 * while (childIndex > 0) {
 * if (heap.get(childIndex) > heap.get(parentIndex)) {
 * int temp = heap.get(childIndex);
 * heap.set(childIndex, heap.get(parentIndex));
 * heap.set(parentIndex, temp);
 * childIndex = parentIndex;
 * parentIndex = (childIndex - 1) / 2;
 * } else {
 * return;
 * }
 * }
 * }
 * 
 * int removeMax() {
 * // Implement the removeMax() function here
 * // Throw the exception PriorityQueueException if queue is empty
 * // if (heap.size() == 0) {
 * // throw new PriorityQueueException();
 * // }
 * 
 * int deletedElem = heap.get(0);
 * heap.set(0, heap.get(heap.size() - 1));
 * heap.remove(heap.size() - 1);
 * // now compare with both left and right nodes and find which one is smaller
 * int leftChildIndex = 1; // initially
 * int rightChildIndex = 2; // initially
 * int minIndex = 0;
 * int index = 0;
 * 
 * // dono child left right mein se chhota dhundo and minindex update kro
 * while (leftChildIndex < heap.size()) {
 * if (heap.get(leftChildIndex) > heap.get(minIndex)) {
 * minIndex = leftChildIndex;
 * }
 * if (rightChildIndex < heap.size() && heap.get(rightChildIndex) >
 * heap.get(minIndex)) {
 * minIndex = rightChildIndex;
 * }
 * 
 * if (minIndex == index) {
 * break;
 * } else {
 * int swaptemp = heap.get(index);
 * heap.set(index, heap.get(minIndex));
 * heap.set(minIndex, swaptemp);
 * 
 * // update index
 * index = minIndex;
 * leftChildIndex = 2 * index + 1;
 * rightChildIndex = 2 * index + 2;
 * }
 * }
 * return deletedElem;
 * }
 * }
 * class PriorityQueueException extends Exception{
 * 
 * }
 */