package GeeksForGeeks.LinkedList;
//Program to perform merge sort on two lists

public class DoublyLinkedList2 {
    public static class DoublyLinkedListNode {
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
    public DoublyLinkedList2(){
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
    private void add(int data, DoublyLinkedListNode predecessor, DoublyLinkedListNode successor){
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
        while (curr!=null && !curr.equals(trailer) ){
            System.out.print(curr.element+" ");
            curr=curr.next;
        }
        System.out.println();
    }
    public DoublyLinkedListNode split(DoublyLinkedListNode header){
        DoublyLinkedListNode slow= header,fast =header;
        while (fast.next!=null && fast.next.next != null){
            fast=fast.next.next;
            slow=slow.next;
        }
        DoublyLinkedListNode middle = slow.next;
        slow.next=null;
        return middle;
    }
    public DoublyLinkedListNode mergeSort(DoublyLinkedListNode header){
        if(header==null|| header.next==null)
            return header;
        DoublyLinkedListNode secondList= split(header);
        DoublyLinkedListNode firstList = mergeSort(header);
        secondList=mergeSort(secondList);
        return merge(firstList,secondList);
    }
    public DoublyLinkedListNode merge(DoublyLinkedListNode header1,DoublyLinkedListNode header2 ){
        if(header1==null)
            return header2;
        if(header2==null)
            return header1;
        if(header1.element<header2.element){
            header1.next= merge(header1.next,header2);
            header1.next.prev=header1;
            header1.prev=null;
            return header1;
        }
        else {
            header2.next= merge(header1,header2.next);
            header2.next.prev=header2;
            header2.prev=null;
            return header2;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList2 list2=new DoublyLinkedList2();
         list2.addFirst(10);
         list2.addLast(2);
         list2.addLast(0);
         list2.addLast(12);
         list2.addLast(11);
         list2.addLast(8);
         list2.printList(list2.header);
        list2.mergeSort(list2.header);
         list2.printList(list2.header);
    }
}
