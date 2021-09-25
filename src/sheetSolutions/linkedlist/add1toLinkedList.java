package sheetSolutions.linkedlist;
/*
This program aims to add 1 to a number represented as linked list.
 */
public class add1toLinkedList {
   static Node sum(Node head){
       head=reverse(head);
       int sum,carry=1;
       Node prev=null,result=null,temp=null;
       while (head!=null){
           sum=carry+ head.value;
           carry=(sum>=10)?1:0;
           sum=sum%10;//to store single digit
           temp=new Node(sum);
           if(result==null){ //if it is the first digit else connect to prev digit
               result=temp;
           }
           else{
               prev.next=temp;
           }
           prev=temp;
           head=head.next;
       }
       if(carry>0){
           temp.next=new Node(carry);
       }
       result=reverse(result);
       return result;
    }
    static Node reverse(Node head){
        Node curr= head,prev=null,link;
        while(curr!=null){
            link=curr.next;
            curr.next=prev;
            prev=curr;
            curr=link;
        }
        return prev;
    }
}
