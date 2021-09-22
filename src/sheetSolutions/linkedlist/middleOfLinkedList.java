package sheetSolutions.linkedlist;
/*
This program aims to find middle of linked list.
 */
public class middleOfLinkedList {
    public Node middleNode(Node head) {
        Node curr=head,prev=head;
        while( curr!=null && curr.next!=null  ){//hare and tortoise approach
            prev=prev.next;
            curr=curr.next.next;
        }
        return prev;

    }
}
