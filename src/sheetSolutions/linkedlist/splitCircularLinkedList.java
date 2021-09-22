package sheetSolutions.linkedlist;
/*
Program demonstrating splitting of circular linked list .if there are odd no. of nodes first list would have
an extra node.
 */
public class splitCircularLinkedList {
    void split( Node head,Node head1,Node head2)
    {
        // Your code here
        Node first=head,second=head;
        while(second.next!=head && second.next.next!=head){//condition for odd and even nodes respectively
            first=first.next;
            second=second.next.next;
        }
        if(second.next.next==head){//for even no. of nodes
            second=second.next;
        }
        second.next= first.next;
        first.next=head;
        head1=head;
        head2=second.next;

    }
    void printCircularLinkedList(Node head){
        Node curr=head;
        if(curr!=null){
            do{
                System.out.print(curr.value+" ");
                curr=curr.next;
            }while(curr!=head);
        }
        System.out.println();
    }

}
