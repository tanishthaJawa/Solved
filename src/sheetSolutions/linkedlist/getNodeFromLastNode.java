package sheetSolutions.linkedlist;
/*
This program aims to find nth node from last node
 */
public class getNodeFromLastNode {
    /*
   This approach uses two pointers. Both pointers are initialized to head.
   Traverse n nodes from head with first pointer.
    Then the second pointer and the first pointer start moving simultaneously.
    This keeps on going till the first pointer becomes null.
     At this point the second pointer will be at the desired node i.e. at nth node from end since the first
     pointer had traversed n elements previously and thus has difference of n nodes with second pointer.

     */
static int getNode(int n,Node head){
    //Time:O(n) , Space complexity:O(1)
    if(head==null)
        return -1;
    Node curr=head,prev=head;
    int idx=0;
    while (idx<n){// move one pointer to nth node
        if(curr==null)
            return -1;
        curr=curr.next;
        idx++;
    }
    while (curr!=null){//move second pointer till first pointer becomes null
        prev=prev.next;
        curr=curr.next;
    }
    return prev.value;//return second pointer value
}
static int getNode1(Node head,int n){
    /*
    Another approach is to calculate the length of the linked list (L)and subtract n(position from the back)
     from it to get the position of the desired node from the front.
     */
    if(head==null)
        return -1;
    Node curr=head;
    int count=0;
    while (curr!=null){
        curr=curr.next;
        count++;
    }
    if (count < n)
        return -1;
    int diff= count-n;
    int j=0;
    curr=head;
    while (j<diff){
        curr=curr.next;
        j++;
    }
    return curr.value;
}
}
