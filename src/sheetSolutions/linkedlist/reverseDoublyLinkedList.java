package sheetSolutions.linkedlist;

import java.util.Stack;

/*
This program aims to reverse a doubly linked list.
 */
public class reverseDoublyLinkedList {
    public static Node reverseDLL(Node  head)
    {
        //Your code here
        Node curr=head,previous=null;
        while(curr!=null){
            curr.prev=curr.next;
            curr.next=previous;
            previous=curr;
            curr=curr.prev;
        }
        return previous;
    }
    void reverse(Node head)
    {
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        while (temp != null) {
            stack.push(temp.value);
            temp = temp.next;
        }
        // added all the elements sequence wise in the
        // stack
        temp = head;
        while (temp != null) {
            temp.value = stack.pop();
            temp = temp.next;
        }
        // popped all the elements and the added in the
        // linked list,
        // which are in the reversed order.
    }
}
