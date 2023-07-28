class stack {
    private int data[];
    private int top;

    stack() {
        data = new int[10];
        top = -1;
    }

    stack(int size) {
        data = new int[size];
        top = -1;
    }

    public boolean isEmpty() {
        // return top==-1?true:false;
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public int top() throws Exception {
        if (top == 0) {
            stackEmptyExpection e = new stackEmptyExpection();
            throw e;
        }
        return data[top];
    }

    public void push(int elem) throws Exception {
        if (size() == data.length) {
            // Exception e = new stackFullException();
            // throw e;

            int[] temp = data;
            data = new int[temp.length * 2];

            for (int i = 0; i <= top; i++) {
                data[i] = temp[i];
            }
        }
        top++;
        data[top] = elem;
    }

    public int pop() throws Exception {
        if (size() == 0) {
            Exception e = new stackEmptyExpection();
            throw e;
        }

        int temp = data[top];
        top--;
        return temp;
    }

    public void print() throws Exception {
        if (size() == 0) {
            Exception e = new stackEmptyExpection();
            throw e;
        }

        for (int i = 0; i <= top; i++)
            System.out.print(data[i] + "->");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        stack a = new stack();

        a.push(10);
        a.push(20);
        a.push(30);
        a.push(40);
        a.push(50);
        a.push(60);
        a.push(60);
        a.push(60);
        a.push(60);
        a.push(60);
        a.push(60);

        a.print();
    }
}