package sheetSolutions.linkedlist;
/*
This program aims to find the starting node of loop
 */
public class startingNodeOfLoop {
    static Node startingNode(Node head){
        if (head == null || head.next == null)
            return null;

        Node slow = head, fast = head;

        // Move slow and fast 1
        // and 2 steps ahead
        // respectively.
        slow = slow.next;
        fast = fast.next.next;//idk why are they important
        while(fast!=null && fast.next!=null){//detect the loop
            if(slow==fast)
                break;
            slow=slow.next;
            fast= fast.next.next;
        }
        if(slow!=fast)//if loop doesn't exists
            return null;
        slow=head;
        while(slow!=fast){//find where they meet
            slow=slow.next;
            fast=fast.next;
         }
        return slow;

    }
}
