package SeparateChaining;
// Note : Array Cant be generic on compile time, so we have to use ArrayList

import java.util.ArrayList;
// import java.util.Map;

// import javax.management.ValueExp;

public class Map<K, V> {
    ArrayList<MapNode<K, V>> buckets;
    int size; // not the size but entries you have put in
    int numBuckets;

    Map() {
        numBuckets = 20;
        buckets = new ArrayList<>();
        // now put null in buckets
        for (int i = 0; i < 20; i++)
            buckets.add(null);
    }

    private int hashFunc(K key) { // this is bucket index function
        // 2 steps
        int hashCode;
        hashCode = hashCode(); // implemented by Object Class
        // ⚠️ this should be key.hashcode(); ??
        return hashCode % numBuckets;

    }

    public void insert(K key, V value) {
        // 1. traverse the LL to find if duplicate/key is present and update it with
        // value
        // 2. if not present then create a new node;
        int bucketIndex = hashFunc(key);
        // buckets is ArrayList btw
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // now create a new node and add it to arraylist ( shift other after new node )
        head = buckets.get(bucketIndex);
        MapNode<K, V> newNode = new MapNode<>(key, value);
        size++;
        newNode.next = head; // now head is attached
        // now add newNode to the ArrayList
        buckets.add(bucketIndex, newNode);

        // to reHash

        double loadFactor = loadFactor();

        if (loadFactor > 0.7) {
            System.out.println("Rehashing...");
            reHash();
        }
    }

    private void reHash() {
        ArrayList<MapNode<K, V>> temp = buckets;
        buckets = new ArrayList<>();
        for (int i = 0; i < 2 * numBuckets; i++) {
            buckets.add(null);
        }
        size = 0;
        numBuckets = 2 * numBuckets;

        // now interate over the old and add new elements to the buckets

        for (int i = 0; i < temp.size(); i++) {
            MapNode<K, V> head = temp.get(i);

            while (head != null) {
                K key = head.key;
                V value = head.value;

                insert(key, value); // yeh buckets mein directly insert krega na isliye

                head = head.next;
            }
        }

    }

    public double loadFactor() {
        return (1.0 * size) / numBuckets;
    }

    public int size() {
        return size;
    }

    public V getValue(K key) {
        int bucketIndex = hashFunc(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V removeKey(K key) {
        int bucketIndex = hashFunc(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        MapNode<K, V> prevNode = null;
        while (head != null) {
            if (head.key.equals(key)) {
                size--;
                if (prevNode == null) {
                    // if the head is the key required. then the prevNode is null
                    buckets.set(bucketIndex, head.next);
                } else {
                    prevNode.next = head.next;// now head is out of the LL
                }
                return head.value;
            }
            prevNode = head;
            head = head.next;
        }
        return null;
    }

}

