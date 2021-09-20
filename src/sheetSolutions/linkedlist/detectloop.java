package sheetSolutions.linkedlist;

public class detectloop {
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
