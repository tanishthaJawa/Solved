package sheetSolutions.linkedlist;
/*
This program aims to delete a node from circular linked list
 */
public class deletionFromCircularLinkedList {
    static Node delete(Node head, int key){
        if(head==null)//list is empty
            return null;
        Node curr= head,prev=null;
        while(curr.value!=key){
            if(curr.next==head){
                System.out.println("element doesn't exist");
                break;
            }
            prev=curr;
            curr=curr.next;
        }
        if(curr== head && curr.next==head){// if list contains only one node
            return null;
        }
        if(curr==head){//first node
            while(curr.next!=head){
                curr=curr.next;
            }
            curr.next=head.next;
            head=head.next;
        }
        else if(curr.next==head)//last node
                prev.next=head;
        else
            prev.next=curr.next;    //between condition

        return head;
    }
}
