package sheetSolutions.linkedlist;

import java.util.Stack;

public class reverseLinkedList {
    static Node reverseIterative(Node head){
            Node curr=head;
            Node prev=null;
            Node point;
            while(curr!=null){
                point=curr.next;
                curr.next=prev;
                prev=curr;
                curr=point;
            }
            return prev;

            // code here
        }

    static Node reverseRecursive(Node head) {
        // for 1->2->3->4
         if(head==null || head.next==null)
             return head;
        Node curr= reverseRecursive(head.next);//return 4 always
        head.next.next=head;//use forward and backward links
        head.next=null;
        return curr;
        }
    static Node reverse(Node head){
        Stack<Node> s= new Stack<>();
        Node temp=head;
        while (temp.next!=null){
            s.add(temp);
            temp=temp.next;
        }
        head=temp;
        while (!s.isEmpty()){
            temp.next=s.peek();
            s.pop();
            temp=temp.next;
        }
        temp.next=null;
        return head;

    }
    static Node reverseUtil(Node curr,Node prev){
        if (curr==null)
            return curr; //linked list is empty
        if(curr.next==null){
            curr.next=prev;//
            return curr;
        }
        Node list= curr.next;
        curr.next=prev;
        reverseUtil(list,curr);
        return curr;
    }

}
