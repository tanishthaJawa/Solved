package sheetSolutions.linkedlist;
/*
This method aims to find duplicates in a sorted array.
 */
public class removeDuplicatesInSortedLinkedList {
    Node removeDuplicates(Node head)
    {
        // Your code here
        Node curr=head;
        while(curr!=null && curr.next!=null){
            if(curr.value==curr.next.value){// if an element is equal to its adjacent element
                curr.next=curr.next.next;// change next of current element to the element pointed by adjacent
            }
            else{
                curr=curr.next;// else move to next element
            }

        }
        return head;
    }
}
