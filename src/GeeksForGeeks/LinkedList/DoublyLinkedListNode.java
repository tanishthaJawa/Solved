package GeeksForGeeks.LinkedList;

public class DoublyLinkedListNode {
    private Integer element;
    private DoublyLinkedListNode next,prev;
    public DoublyLinkedListNode(int data, DoublyLinkedListNode n,DoublyLinkedListNode p){
        element=data;
        next=n;
        prev=p;
    }
    public int getElement(){return  element;}
    public DoublyLinkedListNode getNext(){return  next;}
    public DoublyLinkedListNode getPrev(){return  prev;}
    public  void setNext(DoublyLinkedListNode n){next =n;}
    public void setPrev(DoublyLinkedListNode p){prev=p;}
}
