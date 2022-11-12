
class QueueUsingArray {
    private int data[];
    private int size;
    private int front;
    private int rear;

    QueueUsingArray() {
        data = new int[10];
        size = 0;

        front = -1;
        rear = -1;
    }

    QueueUsingArray(int capacity) {
        data = new int[capacity];
        size = 0;

        front = -1;
        rear = -1;
    }

    int size(){
        return size;
    }
    boolean isEmpty(){
        return (size==0)?true:false; 
    }

    int front() throws Exception{
        if(size==0)
            throw new emptyQueueException();
        else
            return data[front];
    }

    void enqueue(int elem){

        if(size == data.length){
            // either throw exception or 
            doubleCapacity();
        }

        if(size == 0){ // As size = 0 & new nelement is now being inserted , therefore the front will become 0 from -1.
            front = 0;
        }

        // rear++;
        // if(size == data.length){
        //     rear=0;
        // } or
        size++; 
        // next step is for circular but in this case as we double its cap it doesnt affect anthing.
        rear = (rear + 1) % data.length; // circular queue
        data[rear] = elem;
    }

    int dequeue(){
        if(size == 0){
            //exception
        }
        int temp = data[front];
        // front++;
        // if(front == data.length){
        //     front = 0;
        // } or 
        front = (front + 1)%data.length;
        size--;

        if(size == 0){
            front = -1;
            rear = -1;
        }

        return temp;
    }

    void doubleCapacity(){
        int[] temp = data;
        data = new int[temp.length * 2];

        int index = 0;

        // as queue is circular above so rear piche bhi ho skta hai front k isliye 

        //exp 
        // we did this bec. before doubleCap called there could be a case when 
        // there is enq enq enq then deq in this case the rear has smaller index than front.
        for(int i = front ; i < temp.length ; i++){ // front se aage ka data 
            data[index++] = temp[i];
        } 
        for(int i = 0 ; i <= front - 1; i++){ // front se piche ka 
            data[index++] = temp[i];
        }

        front = 0;  
        rear = temp.length - 1;
    }
}