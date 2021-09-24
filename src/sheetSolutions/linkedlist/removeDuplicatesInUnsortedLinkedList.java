package sheetSolutions.linkedlist;

import java.util.HashSet;

/*
This program aims to remove duplicates in an unsorted linked list
 */
public class removeDuplicatesInUnsortedLinkedList {
    /*
    this program uses a set to check if an element exists twice.If an element  occurs twice then first occurrence
    node should be preserved.
    Time Complexity:0(n)
    Space complexity:O(n)
     */
    static Node remove(Node head){
        HashSet<Integer> hs= new HashSet<>();
        Node curr=head,prev=null;
        while (curr!=null){
            if(hs.contains(curr.value)){
                prev.next=curr.next;// remove the link from curr node
                curr.next=null;// remove the next link from curr node
                curr=prev.next;//move curr
            }
            else{
                 hs.add(curr.value);
                   prev=curr;
                   curr=curr.next;
            }
        }
        return head;
    }
}
/*
We can use merge sort approach .but the order won't be preserved in that case.
 */
