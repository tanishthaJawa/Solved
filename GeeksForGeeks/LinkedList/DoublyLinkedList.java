package GeeksForGeeks.LinkedList;
// program to reverse a linked list
//Program to perform quick sort on two lists
public class DoublyLinkedList {
    private static class DoublyLinkedListNode {
        private Integer element;
        private DoublyLinkedListNode next,prev;
        public DoublyLinkedListNode(int data, DoublyLinkedListNode n, DoublyLinkedListNode p){
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
    private DoublyLinkedListNode trailer ,header;
    private int size=0;
    public DoublyLinkedList(){
        header= new DoublyLinkedListNode(-1,null,null);
        trailer=new DoublyLinkedListNode(-1,null,header);
        header.next=trailer;
    }
    public int getSize(){return size;}
    public boolean isEmpty(){return size==0;}
    public int first(){
        if(isEmpty())
            return -1;
        return header.next.element;
    }
    public int last(){
        if(isEmpty())
            return -1;
        return trailer.prev.element;
    }
    public void addFirst(int data){
     add(data,header,header.getNext());

    }
    public void addLast(int data){
        add(data,trailer.getPrev(),trailer);
    }
    public int removeFirst(){
        if(isEmpty())
            return -1;
     return remove(header.next);
    }
    public int removeLast(){
        if(isEmpty())return -1;
    return remove(trailer.prev);
    }
    public int removeBetween(){
        return remove(header.next.next.next);
    }
    private void add(int data,DoublyLinkedListNode predecessor,DoublyLinkedListNode successor){
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data,successor,predecessor);
        predecessor.setNext(newNode);
        if(successor!=null)
           successor.setPrev(newNode);
        size++;
    }
    private int remove(DoublyLinkedListNode node){
       DoublyLinkedListNode predecessor= node.getPrev();
       DoublyLinkedListNode successor= node.getNext();
       predecessor.setNext(successor);
       successor.setPrev(predecessor);
       size--;
       return node.element;
    }
   public void printList(DoublyLinkedListNode header){
        DoublyLinkedListNode curr= header.next;
        while (!curr.equals(trailer)){
            System.out.print(curr.element+" ");
            curr=curr.next;
        }
        System.out.println();
   }
   public void reverse(){
       DoublyLinkedListNode temp;
        DoublyLinkedListNode node=header.next;
        while (node!=trailer) {
             temp = node.prev;
            node.prev = node.next;
            node.next = temp;
            node = node.prev;
        }
       DoublyLinkedListNode newTemp = trailer.prev;
        trailer.prev=header.next;
        trailer.prev.next=trailer;
        header.next=newTemp;
        header.next.prev=header;
        /* Since my linked lists have two dummy nodes header and trailer,I need to
        change the next of header and previous of trailer and set it to new nodes.Also
        starting node successor will point to header and the last node prev will point to
        trailer and these needs to be changed. If that wouldn't have been the case
        we would write
        if(temp!=null) //to check if list is empty or contains one node
        head = temp.prev; */

   }
private DoublyLinkedListNode partition(DoublyLinkedListNode header,DoublyLinkedListNode trailer){
        int x=trailer.getElement();// Find the last element of list
        DoublyLinkedListNode i=header.prev;//i set to low-1
    for (DoublyLinkedListNode j = header; j != trailer; j=j.next) { //Till j is less than last element of list
        if(j.getElement()<=x){//if j is less than x swap i and j
            i=(i==header.prev)?header:i.next;
            int temp =i.element;
            i.element=j.element;
            j.element=temp;
        }
    }
    i=(i==header.prev)?header:i.next;
    int temp=i.element;// swap i+1 with last element
    i.element=trailer.element;
    trailer.element=temp;
    return i;
}
public void QuickSort(DoublyLinkedListNode header,DoublyLinkedListNode trailer){
        if(header!=null && header!=trailer && header!=trailer.next){
            DoublyLinkedListNode p=partition(header,trailer);
            QuickSort(header,p.prev);
            QuickSort(p.next,trailer);
        }



}
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(15);
        list.addLast(8);
        list.addLast(1);
        list.addLast(4);
         list.addLast(2);
         list.printList(list.header);
        list.QuickSort(list.header.next, list.trailer.prev);
        list.printList(list.header);

    }
}
