import java.util.ArrayList;

public class PQ {

	private ArrayList<Integer> heap;

	public PQ() {
		heap = new ArrayList<Integer>();
	}

	boolean isEmpty() {
		return heap.size() == 0;
	}

	int size() {
		return heap.size();
	}

	int getMin() throws PriorityQueueException {
		if (isEmpty()) {
			// Throw an exception
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}

	void insert(int element) {
		heap.add(element);

		// now up heapify

		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while (childIndex > 0) {
			if (heap.get(childIndex) < heap.get(parentIndex)) {
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

	int removeMin() throws PriorityQueueException {
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
		while (leftChildIndex < heap.size()) { // entry condition ki left child hai bhi
			if (heap.get(leftChildIndex) < heap.get(minIndex)) {
				minIndex = leftChildIndex;
			}
			// right child k liye bhi toh condition lagao
			if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)) {
				minIndex = rightChildIndex;
			}

			if (minIndex == index) {
				break; // if min index is unchanged
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

class PriorityQueueException extends Exception {

}

// import java.net.http.HttpHeaders;
// import java.util.ArrayList;

// import javax.print.attribute.standard.ReferenceUriSchemesSupported;
// import javax.xml.transform.Templates;

// class Priority_Queue {
// private ArrayList<Integer> heap;

// Priority_Queue() {
// heap = new ArrayList<>();
// }

// boolean isEmpty() {
// return heap.size() == 0;
// }

// int size() {
// return heap.size();
// }

// int getMin() throws PQemptyException {
// if (isEmpty()) {
// throw new PQemptyException();
// }
// return heap.get(0);
// }

// // now main logic begins

// void insert(int elem) {
// heap.add(elem);
// int childIndex = heap.size() - 1;
// int parentIndex = (childIndex - 1) / 2;

// while (childIndex > 0) { // got it , easy

// if (heap.get(parentIndex) > heap.get(childIndex)) {
// // swap
// int temp = heap.get(childIndex);
// heap.add(childIndex, heap.get(parentIndex));
// heap.add(parentIndex, temp);
// // index update
// childIndex = parentIndex;
// parentIndex = (childIndex - 1) / 2;
// } else {
// return;
// }
// }
// }

// int remove() throws Exception {
// if (heap.size() == 0) {
// throw new PQemptyException();
// }

// int deletedElem = heap.get(0);
// heap.set(0, heap.get(heap.size() - 1));
// heap.remove(heap.size() - 1);
// // now compare with both left and right nodes and find which one is smaller
// int leftChildIndex = 1; // initially
// int rightChildIndex = 2; // initially
// int minIndex = 0;
// int index = 0;

// // dono child left right mein se chhota dhundo and minindex update kro
// while (leftChildIndex < heap.size()) {
// if (heap.get(leftChildIndex) < heap.get(minIndex)) {
// minIndex = leftChildIndex;
// }
// if (rightChildIndex < heap.size() && heap.get(rightChildIndex) <
// heap.get(minIndex)) {
// minIndex = rightChildIndex;
// }

// if (minIndex == index) {
// break;
// } else {
// int swaptemp = heap.get(index);
// heap.set(index, heap.get(minIndex));
// heap.set(minIndex, swaptemp);

// // update index
// index = minIndex;
// leftChildIndex = 2 * index + 1;
// rightChildIndex = 2 * index + 2;
// }
// }
// return deletedElem;
// }
// }