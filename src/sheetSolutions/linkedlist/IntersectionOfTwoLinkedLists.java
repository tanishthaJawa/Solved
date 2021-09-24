package sheetSolutions.linkedlist;
/*
This program aims to find intersection of two sorted linked lists.It should create a new list and should not modify
existing lists.
 */
public class IntersectionOfTwoLinkedLists {
    //Time complexity:O(n),Space complexity:O(n)
 static Node intersection(Node head1,Node head2){
     Node curr1=head1,curr2=head2;
     Node head3=new Node(0);
     Node curr3=head3;
     while(curr1!=null && curr2!=null){
         if(curr1.value==curr2.value){
             curr3.next=new Node(curr1.value);
             curr3=curr3.next;
             curr1=curr1.next;
             curr2=curr2.next;

         }
         else if(curr1.value<curr2.value){
             curr1=curr1.next;
         }
         else{
             curr2=curr2.next;
         }
     }
     return head3.next;
 }
             
 }

