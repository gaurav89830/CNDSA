// import org.w3c.dom.Node;
public class Node<T>{
    T data;
    Node<T> next;

    Node(T data){
        this.data = data;
    }

    public static<T> void printLL(Node<T> Head ){
        Node<T> tempHead = Head;

        while(tempHead!=null){
            System.out.print(tempHead.data + " ");
            tempHead = tempHead.next;
        }
        System.out.println();
    }
    
}