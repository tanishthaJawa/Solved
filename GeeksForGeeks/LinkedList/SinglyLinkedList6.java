package GeeksForGeeks.LinkedList;
/*Program to rotate a linked list counter-clockwise k times
 */
public class SinglyLinkedList6 {
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
    public void printLinkedList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getElement()+" ");
            current = current.next;
        }
        System.out.println();
    }
    public static Node rotate(Node head,int k){
        /* Function to rotate a linked list counter-clockwise k times assuming k is
          less than size of linked list*/
        if(k==0)
            return head;
        int count =1;
        Node current =head;
        while(count<k && current!=null){
            // at the end of loop node will point to k node
            current=current.next;
            count++;
        }
        if(current==null||current.next==null)// k is greater or equal to size of linked list
            return head;
        Node kNode=current;
        while(current.next!=null){
            // after this loop current will point to last node
            current=current.next;
        }
        current.next=head;//make current point to first node
        head=kNode.next;//make k+1 node as head
        kNode.next=null;//make kNode last node
        return head;
    }
    public static Node rotate1(Node head,int k){
        /* This function can rotate a linked list greater than its size
         */
        if(k==0)
            return head;
        Node current =head;
        while(current.next!=null){
            current=current.next;
        }
        /* it first  makes last node point to head (creates a circular linked list) */
        current.next=head;
        current=head;
        for (int count = 1; count < k; count++) {
            //finds kth node
            current=current.next;
        }
        head=current.next;//make k+1 node as head
        current.next=null;// set k node as null
        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedList6 list6= new SinglyLinkedList6();
        list6.addFirst(10);
        list6.addLast(20);
        list6.addLast(30);
        list6.addLast(40);
        list6.addLast(50);
        list6.addLast(60);
        list6.printLinkedList();
        list6.head= rotate1(list6.head, 7);
        list6.printLinkedList();
    }
}

