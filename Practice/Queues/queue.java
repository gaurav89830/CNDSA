// import java.util.Queue;

public class queue {
    public static void main(String[] args) {
        // QueueUsingArray queue = new QueueUsingArray();
        fun(5);
    }

    static void fun(int n) {
        QueueUsingArray q = new QueueUsingArray();

        for(int i = 0 ; i < n ; i++){
        q.enqueue(i+1);
        System.out.println("Added "+ (i+1));
        }

        while(!q.isEmpty()){
            System.out.println("Removed "+ q.dequeue());
        }
    }
}
