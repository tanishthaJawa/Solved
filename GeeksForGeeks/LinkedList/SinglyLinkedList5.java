package GeeksForGeeks.LinkedList;
// Program to sum digits of linked list
public class SinglyLinkedList5 {
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
    public static Node reverseLinkedList(Node head){
        Node prev=null,curr=head,link;
        while(curr!=null){
            link=curr.next;
            curr.next=prev;
            prev=curr;
            curr=link;
        }
        return prev;
    }
    public static Node sumOfLinkedLists(Node head1,Node head2){
        head1=reverseLinkedList(head1);
        head2=reverseLinkedList(head2);
        Node prev =null,result=null,temp=null;
        int sum,carry=0;
        while(head1!=null||head2!=null){
            /*WE need to sum the lists till even one of them contains a data. if one of the
            list becomes empty we will take its data to be zero*/
            //sum of linked list
            sum=carry+(head1!=null?head1.element:0)+(head2!=null?head2.element:0);
            //update carry
            carry=(sum>=10)?1:0;
            // if the sum of two digits are greater than 10
            sum=sum%10;
            // create a new node with result of sum
            temp=new Node(sum,null);
            if(result==null){
                // set node at head
                result=temp;
            }
            else{
                //link prev node
                prev.next=temp;
            }
            // mak prev ready for next insertion
            prev=temp;
            if(head1!=null)
                head1=head1.next;
            if (head2!=null)
                head2=head2.next;

        }
        if (carry > 0) {
            // if the sum of digits is greater than no. of digits
            // if no. are of 3 digits and sum comes of 4 digits
            temp.next = new Node(carry,null);
        }

        result=reverseLinkedList(result);
        return result;
    }

    public static void main(String[] args) {
        SinglyLinkedList5 list1=new SinglyLinkedList5();
        SinglyLinkedList5 list2=new SinglyLinkedList5();
        SinglyLinkedList5 resultHead=new SinglyLinkedList5();
        list1.addFirst(6);
        list1.addLast(2);
        list1.addLast(3);
        list1.printLinkedList();
        list2.addFirst(4);
        list2.addLast(8);
        list2.addLast(7);
        list2.printLinkedList();
       resultHead.head = sumOfLinkedLists(list1.head, list2.head);
       resultHead.printLinkedList();


    }
}
