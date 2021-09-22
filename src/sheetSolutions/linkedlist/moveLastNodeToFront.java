package sheetSolutions.linkedlist;
/*
This program aims to move first node to last node
 */
public class moveLastNodeToFront {
    static void moveNode(Node head){
        if(head==null || head.next==null){
            return ;
        }
        Node curr=head,prev=null;
        while(curr.next!=null){
            prev=curr;
            curr=curr.next;
        }
        curr.next=head;
        prev.next=null;
        head=curr;
    }
}
