package GeeksForGeeks.LinkedList;
/*Program to detect loop can be done using a hashset, floyd cycle detection algorithm , by creating
 a temporary node in linked list */
//Program to remove loop
public class SinglyLinkedList4 {
    private static class Node {
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
    private Node head = null, tail = null;
    private int size = 0;
    public Node getHead(){
        return head;
    }
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void printLinkedList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getElement()+" ");
            current = current.next;
        }
        System.out.println();
    }
    public void addFirst(int data) {
        head = new Node(data, head);
        if (isEmpty())
            tail = head;
        size++;
    }
    public void addLast(int data) {
       Node newNode = new Node(data, null);
        if (isEmpty())
            head = newNode;
        else
            tail.setNext(newNode);
        tail = newNode;
        size++;
    }
    //Floyd cycle detection algorithm
    public void detectLoop(Node head){
        Node slowFp = head,fastFp=head;
        int flag=0;
        while(slowFp!=null && fastFp!=null && fastFp.next!=null){
            slowFp=slowFp.next;
            fastFp=fastFp.next.next;
            if(slowFp==fastFp){
                flag=1;
                break;
            }
        }
        if(flag==1){
            System.out.println("Loop detected");
            removeLoop(slowFp, head);
        }

        else
            System.out.println("Loop not detected");
    }
    public void removeLoop(Node loopNode,Node head){
        int countNodes=1;
        Node slowFp=loopNode,fastFp = loopNode;
        while(slowFp.next!=fastFp){
            slowFp=slowFp.next;
            countNodes++;//count nodes of loop
        }
        slowFp=head;
        fastFp=head;
        for (int i = 0; i < countNodes; i++) {
            fastFp=fastFp.next;//set one pointer after no. of nodes in loop (after countNodes)
        }
        while (fastFp!=slowFp){
            slowFp=slowFp.next;
            fastFp=fastFp.next;//find starting node of loop
        }
        while (fastFp.next!=slowFp){
            fastFp=fastFp.next;//find last node of loop
        }
        fastFp.next= null;


    }

    public static void main(String[] args) {
        SinglyLinkedList4 list4=new SinglyLinkedList4();
        list4.addFirst(5);
        list4.addLast(1);
        list4.addLast(3);
        list4.addLast(4);
        list4.addLast(5);
        list4.addLast(3);
        list4.addLast(5);
        list4.head.next.next.next.next.next.next.next= list4.head.next.next.next;
        list4.detectLoop(list4.head);
        list4.printLinkedList();

    }
}
