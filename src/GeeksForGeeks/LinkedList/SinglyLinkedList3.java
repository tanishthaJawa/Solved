package GeeksForGeeks.LinkedList;
//Program to merge two sorted lists
//Program to perform merge sort on two linked lists
public class SinglyLinkedList3  {
    private static class Node2 {
        private Integer element;
        private Node2 next;
        public Node2(int data, Node2 n) {
            element = data;
            next = n;
        }
        public int getElement() {
            return element;
        }
        public Node2 getNext() {
            return next;
        }
        public void setNext(Node2 t) {
            next = t;
        }
    }
    private Node2 head = null, tail = null;
    private int size = 0;
    public Node2 getHead(){
        return head;
    }
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void printLinkedList() {
        Node2 current = head;
        while (current != null) {
            System.out.print(current.getElement()+" ");
            current = current.next;
        }
        System.out.println();
    }
    public void addFirst(int data) {
        head = new Node2(data, head);
        if (isEmpty())
            tail = head;
        size++;
    }
    public void addLast(int data) {
        Node2 newNode = new Node2(data, null);
        if (isEmpty())
            head = newNode;
        else
            tail.setNext(newNode);
        tail = newNode;
        size++;
    }
    public static Node2 mergeLists(Node2 head1, Node2 head2){
        Node2 dummyNode=new Node2(0,null);
        Node2 tail=dummyNode;
        while (true){
            if(head1==null){
                tail.next=head2;
                break;
            }
            if (head2==null){
                tail.next=head1;
                break;
            }
            if(head1.element<=head2.element){
             tail.next=head1;
             head1=head1.next;
            }
            else {
                tail.next=head2;
                head2=head2.next;
            }
            tail=tail.next;
        }
        return dummyNode.next;
    }
    public static Node2 mergeLists1(Node2 head1, Node2 head2) {//Recursive approach
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }

        if(head1.element<=head2.element){
            head1.next= mergeLists1(head1.next,head2);
            return head1;
        }
        else{
            head2.next= mergeLists1(head1,head2.next);
            return head2;
        }
    }
  public static Node2 mergeSort(Node2 head){//Complexity: O(n*log n)
        if(head==null||head.next==null)
            return head;
        Node2 middle= getMiddle(head);
        Node2 nextOfMiddle= middle.next;
        middle.next=null;
        Node2 leftList= mergeSort(head);
        Node2 rightList = mergeSort(nextOfMiddle);
       return mergeLists1(leftList,rightList);

  }

    private static Node2 getMiddle(Node2 head) {//Tortoise and hare approach
        Node2 slow=head,fast=head.next;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        SinglyLinkedList3 list1=new SinglyLinkedList3();
        list1.addFirst(10);
        list1.addLast(20);
        list1.addLast(5);
        list1.addLast(2);
        list1.addLast(35);
        list1.addLast(23);
        list1.printLinkedList();
       list1.head= mergeSort(list1.head);
       list1.printLinkedList();
    }
}

