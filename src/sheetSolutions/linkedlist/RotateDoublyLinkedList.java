package sheetSolutions.linkedlist;
/*
This function aims to rotate a doubly linked list node by K times. It rotates only if K is less than size of
linked list.
 */
public class RotateDoublyLinkedList {
    // This function rotates a doubly linked
// list counter-clockwise and updates the
// head. The function assumes that N is
// smaller than size of linked list. It
// doesn't modify the list if N is greater
// than or equal to size
    static Node rotate(Node head,int k){
        if(k==0)
            return head;
        // Let us understand the below code
        // for example N = 2 and
        // list = a <-> b <-> c <-> d <-> e.
        Node curr=head;
        int count=1;
        // current will either point to Nth
        // or NULL after this loop. Current
        // will point to node 'b' in the
        // above example
        while(count<k && curr!=null){
            curr = curr.next;
            count++;
        }
        // If current is NULL, N is greater
        // than or equal to count of nodes
        // in linked list. Don't change the
        // list in this case
        if(curr==null)
            return head;
        // current points to Nth node. Store
        // it in a variable. NthNode points to
        // node 'b' in the above example
        Node kNode=curr;
        // current will point to last node
        // after this loop current will point
        // to node 'e' in the above example
        while (curr.next!=null){
            curr=curr.next;
        }
        // Change next of last node to previous
        // head. Next of 'e' is now changed to
        // node 'a'
        curr.next=head;
        // Change prev of Head node to current
        // Prev of 'a' is now changed to node 'e'
        head.prev=curr;
        // Change head to (N+1)th node
        // head is now changed to node 'c'
        head=kNode.next;
        // Change prev of New Head node to NULL
        // Because Prev of Head Node in Doubly
        // linked list is NULL
        head.prev=null;
        // change next of Nth node to NULL
        // next of 'b' is now NULL
        kNode.next=null;
        return head;
    }
}
