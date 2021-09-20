package sheetSolutions.linkedlist;

public class checkIfLinkedListIsCircular {
    boolean isCircular(Node head)
    {
        // Your code here
        Node slow=head,fast=head;
        while(slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
