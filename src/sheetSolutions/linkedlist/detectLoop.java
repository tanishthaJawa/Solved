package sheetSolutions.linkedlist;
/*
This program aims to detect a loop in linked list. A loop exists if a node points to any other node in the list
 */
public class detectLoop {
    public static boolean detectLoop1(Node head){
        // Add code here
        Node slowFp=head,fastFp=head.next;
        while(slowFp!=null && fastFp!=null && fastFp.next!=null){
            slowFp=slowFp.next;
            fastFp=fastFp.next.next;
            if(slowFp==fastFp)
                return true;
        }
        return false;
    }
}
