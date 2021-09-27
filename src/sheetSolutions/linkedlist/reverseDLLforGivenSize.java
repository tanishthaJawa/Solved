package sheetSolutions.linkedlist;
/*This program aims to reverse a doubly linked list for given size

 */
public class reverseDLLforGivenSize {
 static Node reverse(Node head,int k){
     if(head==null)
         return null;
     head.prev=null;
     Node temp;
     Node curr=head;
     Node newHead=null;
     int count=0;
     while (curr!=null && count < k){
         newHead=curr;//make last element as head
         temp=curr.prev;
         curr.prev=curr.next;
         curr.next=temp;
         curr=curr.prev;
         count++;
     }
     // Checking if the reversed LinkedList size is
     // equal to K or not. If it is not equal to k
     // that means we have reversed the last set of
     // size K and we don't need to call the
     // recursive function
     if(count>=k){
        Node rest=reverse(curr,k);
         head.next=rest;
         if(rest!=null){
             rest.prev=head;
         }
     }
     if(newHead!=null)// not in the original code added by  me to make prev of first node in modified list as null
        newHead.prev=null;
     return newHead;

 }
}
