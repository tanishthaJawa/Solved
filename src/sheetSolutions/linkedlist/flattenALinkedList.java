package sheetSolutions.linkedlist;
/*
This program aims to flatten a linked list where every node represents a sub-linked-list and contains two
pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order.
Note: The flattened list will be printed using the bottom pointer instead of next pointer.
 */
public class flattenALinkedList {
    static Node flatten(Node root){
        if(root==null || root.next==null)
            return root;
        root.next=flatten(root.next);
        root=sortedMerge(root,root.next);
        return root;
    }
    static Node sortedMerge(Node head1,Node head2){
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
        if(head1.value< head2.value){
            head1.bottom=sortedMerge(head1.bottom,head2);
            return head1;
        }
        else{
            head2.bottom=sortedMerge(head1,head2.bottom);
            return head2;
        }
    }
}

