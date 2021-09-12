package GeeksForGeeks.LinkedList;
//Program to split the circular list in two halves
//Program to insert nodes
//Program to perform sorted insertion
public class CircularLinkedList {
    private static class Node {
        private final Integer element;
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
    private Node  tail = null ;
    private int size = 0;
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public static void printCircularLinkedList(Node head){
        Node curr=head;
        if(head!=null){
            do{
                   System.out.print(curr.element+ " ");
                    curr= curr.next;
            }while (curr!=head);
        }
        System.out.println();

    }
    public int first(){
        if(tail!=null)
            return tail.next.element;
        return -1;
    }
    public int last(){
        if(tail!=null)
            return tail.getElement();
         return -1;
    }
    public void addFirst(int data) {
        if(size==0){
           tail= new Node(data,null);
            tail.next=tail;
        }
        else{
            tail.next= new Node(data,tail.getNext());
        }
        size++;
    }
    public void addLast(int data) {
       addFirst(data);
       tail=tail.getNext();
    }
    public void rotate(){
        if(tail!=null)
            tail=tail.getNext();
    }
    public void addAfter(int data, int position){
        if(position>size)
            return ;
        if(position==0  ){
            addFirst(data);
        }
         else if(position==size){
            addLast(data);
        }
         else {

            Node newNode = new Node(data,null);
            int count =0;
            Node curr = tail.next,prev=null;
            while (count<position && curr!=tail){
                prev=curr;
                curr=curr.next;
                count++;
            }
            newNode.next=prev.next;
            prev.next=newNode;
            size++;
        }
        }
    public int removeFirst(){
        Node head=tail.next;
        if(isEmpty())
            return -1;
      if(head==tail){
          tail=null;
      }
      else{
          tail.next=head.next;
      }
      size--;
      return head.element;
    }
public static void splitList(Node head){
        if(head==null)
            return;
        Node slowPtr=head,fastPtr=head;
        /*Hair and tortoise approach to find middle and last node .If there are odd no.of
         nodes then first list would have an extra node   */
        while (fastPtr.next!=head && fastPtr.next.next!=head){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
        }
        if(fastPtr.next.next==head){
            // if there are even  no. of nodes then moving fastPtr to last node
            fastPtr=fastPtr.next;
        }
        Node head1, head2 =null;
        head1=head;
       if(head.next!=head)
          head2=slowPtr.next;

       fastPtr.next=slowPtr.next;// make lists circular
       slowPtr.next= head;
     printCircularLinkedList(head1);
     printCircularLinkedList(head2);

}
    public void sortedInsert(int insertNode){
        // if node to be inserted is greater than last node we do not add it
        Node current = tail.next,head=tail.next;
        int position=0;
        while (current.next!= head && insertNode>current.element){
            current=current.next;
            position++;
        }
        if(position==size-1)
            return;
        addAfter(insertNode,position);
        size++;
}
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        printCircularLinkedList(list.tail.next);
       System.out.println(list.first());
       System.out.println(list.last());
       System.out.println(list.removeFirst());
         list.addAfter(25,2);
       printCircularLinkedList(list.tail.next);
       splitList(list.tail.next);
       list.sortedInsert(511);
       printCircularLinkedList(list.tail.next);
       list.rotate();
       printCircularLinkedList(list.tail.next);



    }
}
