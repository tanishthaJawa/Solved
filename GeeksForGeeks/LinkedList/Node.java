package GeeksForGeeks.LinkedList;

public class Node {
    private Integer element;
    private Node next;
    public Node(int data, Node n) {
        element = data;
        next = n;
    }
    public int getElement() {
        return element;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node t) {
        next = t;
    }

}
