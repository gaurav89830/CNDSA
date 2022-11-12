package StackUsing2Queues;

import java.util.LinkedList;
import java.util.Queue;

public class Stack {

    private Queue<Integer> q = new LinkedList<Integer>();
    private Queue<Integer> temp = new LinkedList<Integer>();

    public Stack() {
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        return q.size();
    }

    public boolean isEmpty() {
        return q.size()==0;
    }

    public void push(int element) {
        q.add(element);
    }
    
    public int top(){
        if(q.isEmpty()){
            return -1;
        }
        while(q.size()!=1){
        temp.add(q.poll());
        }
        
        int ret = q.peek();
        temp.add(q.poll());
        
        Queue<Integer> temp2 = new LinkedList<Integer>();
        temp2 = temp;
        temp = q;
        q = temp2;
        
        return ret;
        
    }
        public int pop(){
        if(q.isEmpty()){
            return -1;
        }
        while(q.size()!=1){
        temp.add(q.poll());
        }
        
        int ret = q.peek();
    	q.poll();
        
        Queue<Integer> temp2 = new LinkedList<Integer>();
        temp2 = temp;
        temp = q;
        q = temp2;
        
    	return ret;
    }

    
}

