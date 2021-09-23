package sheetSolutions.linkedlist;
/*
This program aims to detect and remove loop if it exists
 */
public class removeLoop {
    static void detectAndRemoveLoop(Node head){
        Node slow=head,fast=head;
        if(head==null || head.next==null)
            return ;
        slow=slow.next;
        fast=fast.next.next;//Idk why but these steps are important else timeout
        while(fast!=null && fast.next!=null){//detects the loop
            if(slow==fast)
                break;
            slow=slow.next;
            fast=fast.next.next;
        }
          if(slow==fast){
              slow=head;
              if(slow!=fast){//checks if slow and fast do not meet at head
                  while (slow.next!=fast.next){// till next of both pointers point to starting node of loop
                      slow=slow.next;
                      fast=fast.next;
                  }
                  fast.next=null;//fast points to last loop node;
              }
              else {//checks if slow and fast meet at head
                  while (fast.next!=slow){
                      fast=fast.next;//will point to last node
                  }
                  fast.next=null;
              }
          }
    }
}
