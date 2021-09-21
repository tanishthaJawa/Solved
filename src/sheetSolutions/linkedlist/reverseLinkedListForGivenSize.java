package sheetSolutions.linkedlist;
/*
Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in
the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should be
 considered as a group and must be reversed (See Example 2 for clarification).

Example 1:

Input:
LinkedList: 1->2->2->4->5->6->7->8
K = 4
Output: 4 2 2 1 8 7 6 5
Explanation:
The first 4 elements 1,2,2,4 are reversed first
and then the next 4 elements 5,6,7,8. Hence, the
resultant linked list is 4->2->2->1->8->7->6->5.
 */
public class reverseLinkedListForGivenSize {
    //o(n) and O(1)
    static Node reverse(Node head,int k){
        Node curr= head,prev=null,list=null;
        int idx=0;
        while (idx<k && curr!=null){//curr!=null for last element or if no. of nodes is less than k
            list=curr.next;
            curr.next=prev;
            prev=curr;
            curr=list;
            idx++;
        }
        if(list!=null){
            head.next=reverse(list,k);//1.next=8;
        }
        return prev;//prev=8 for second run ,first run prev would be 4
    }
}
