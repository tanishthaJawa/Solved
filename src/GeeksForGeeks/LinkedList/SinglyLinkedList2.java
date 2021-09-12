package GeeksForGeeks.LinkedList;
//Program to swap two numbers without swapping data
//Program to reverse a linked list
//Program to reverse linked list for given size
public class SinglyLinkedList2 <E>{
    private static class Node1<E>{
        private  E element;
        private Node1<E> next;
        public Node1(E data, Node1<E> n){
            element=data;
            next =n;
        }
        public E getElement(){
            return element;
        }
        public Node1<E> getNext(){
            return next;
        }
        public void setNext(Node1<E> t){
            next=t;
        }
    }
    private Node1<E> head = null,tail=null;
    private int size=0;

    public int getSize() {
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    public void printLinkedList() {
        Node1<E> current = head;
        while (current != null) {
            System.out.print(current.getElement());
            current = current.next;
        }
        System.out.println();
    }
    public void addFirst(E data ){
        head= new Node1<>(data,head);
        if(isEmpty())
            tail=head;
        size++;
    }
    public void addLast(E data ){
        Node1<E> newNode= new Node1<>(data,null);
        if(isEmpty())
            head=newNode;
        else
            tail.setNext(newNode);
        tail=newNode;
        size++;
    }

    public void swap(E x,E y){
        Node1<E> xCurrent= head,yCurrent=head;
        Node1<E> xPrevious= null,yPrevious=null;
        if(x==y)
            return;

        while(xCurrent!=null && !xCurrent.getElement().equals(x))  {
           xPrevious=xCurrent;
           xCurrent=xCurrent.next;
        }
        while(yCurrent!=null && !yCurrent.getElement().equals(y)  ){
            yPrevious=yCurrent;
            yCurrent=yCurrent.next;
        }
        if(xCurrent==null || yCurrent==null)
            return;
        if(xPrevious!=null){
            xPrevious.next=yCurrent;
        }
        else{
            head=yCurrent;
        }

        if(yPrevious!=null){
            yPrevious.next=xCurrent;
        }
        else{
            head=xCurrent;
        }
        Node1<E>temp=xCurrent.next;
        xCurrent.next=yCurrent.next;
        yCurrent.next=temp;

    }
    public void reverse(){
        Node1 <E>link,prev=null;
        Node1 <E>curr=head;
        while (curr!=null){
            link=curr.next;
            curr.next=prev;
            prev=curr;
            curr=link;

        }
        head=prev;
    }
    public Node1<E> reverseForSize(Node1<E> head,int k) {
        Node1<E> link=null, prev = null;
        Node1<E> curr = head;
        int count = 0;
        while (count < k && curr != null) {
            link = curr.next;
            curr.next = prev;
            prev = curr;
            curr = link;
            count++;
        }
        if(link!=null){
           head.next=reverseForSize(link,k);
        }
        return prev;
    }

    public static void main(String[] args) {
        SinglyLinkedList2<Integer> list =new SinglyLinkedList2<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.printLinkedList();
//     list.swap(2,5);
//     list.printLinkedList();
//        list.swap(1,3);
//        list.printLinkedList();
//        list.swap(3,1);
//        list.printLinkedList();
//        list.swap(1,4);
//        list.printLinkedList();
//        list.addFirst(50);
        list.reverse();
        list.printLinkedList();
       list.head= list.reverseForSize(list.head, 2);
        list.printLinkedList();
    }
}
