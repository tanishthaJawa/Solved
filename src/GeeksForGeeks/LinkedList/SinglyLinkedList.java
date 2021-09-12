package GeeksForGeeks.LinkedList;

public class SinglyLinkedList <E>{
    private static class Node<E>{
      private  E element;
      private  Node<E> next;
        public Node(E data,Node<E> n){
             element=data;
             next =n;
        }
        public E getElement(){
            return element;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node<E> t){
            next=t;
        }
    }
    private int size=0;
    private Node<E> head = null,tail=null;
    public SinglyLinkedList(){}
    public int getSize(){return size;}
    public boolean isEmpty(){return size==0;}
    public E first(){
        if(isEmpty())return null;
        return head.getElement();
    }
    public E last(){
        if(isEmpty()) return  null;
        return tail.getElement();
    }
    public void addFirst(E data ){
        head= new Node<>(data,head);
        if(isEmpty())
            tail=head;
        size++;
    }
    public void addLast(E data ){
        Node<E>newNode= new Node<>(data,null);
        if(isEmpty())
            head=newNode;
        else
            tail.setNext(newNode);
        tail=newNode;
        size++;
    }
    public E removeFirst(){
        if(isEmpty())
            return null;
        E answer= head.getElement();
            head=head.getNext();
        size--;
        if(size==0)
            tail=null;
        return answer;
    }
    public void deleteNode(E data){
        Node<E> current=head,previous=null;
        while(current!=null&&current.getElement()!=data){
            previous=current;
            current=current.next;
        }
        if(current==null){
            System.out.println("Element not found");
        }
       else if(previous!=null){
            previous.next=current.next;
            size--;
        }
        else{
            head=current.next;
            current.next=null;
           size--;
        }


    }
    public void deleteNodeFromPosition(int position){
        Node<E> current=head,previous=null;
        int idx=0;
        if(head==null)
            return;
        if(position==0){
            head=current.next;
            current.next=null;
            size--;
            return;
        }
        while(idx!=position&&current!=null){
            previous=current;
            current=current.next;
            idx++;
        }
        if(position>size){
            System.out.println("Position greater");
        }
       else if(position==size-1){
            tail=previous;
           previous.next=null;
           size--;
        }
        else{
            previous.next=current.next;
        }

    }
    public void printLinkedList(){
        Node<E> current=head;
        while(current!=null){
            System.out.println(current.getElement());
            current=current.next;
        }
    }
}
class SingLyLinkedListTest{
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        System.out.println(list.first());
        System.out.println(list.last());
        System.out.println(list.getSize());
        list.printLinkedList();
       list.deleteNodeFromPosition(2);
       list.deleteNodeFromPosition(4);
       list.deleteNode(10);
       list.printLinkedList();
        System.out.println(list.first());
        System.out.println(list.removeFirst());
        list.printLinkedList();



    }
}
