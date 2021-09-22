package sheetSolutions.linkedlist;

import java.util.Stack;

public class checkIfLinkedListIsPalindrome {
    boolean isPalindrome(Node head)
    {
        //Your code here
       Node slow=head,fast=head,midNode=null,prev=head,list2;
        boolean ans=true;
        if (head != null && head.next != null) {
            while (fast != null && fast.next != null) {//find mid of node
                fast = fast.next.next;
                prev = slow;//needed for odd nodes
                slow = slow.next;
            }
       /* fast_ptr would become NULL when there are even elements
               in the list and not NULL for odd elements. We need to skip
               the middle node for odd case and store it somewhere so that
               we can restore the original list */
            if (fast != null) {
                midNode.next = slow;
                slow = slow.next;
            }
            list2 = slow;
            prev.next = null;
            // Now reverse the second half and compare it with first half
            reverse(slow);
            ans = compareLists(head, list2);
            reverse(slow);// Reverse the second half again
            if (midNode != null) {
                // If there was a mid node (odd size case) which
                // was not part of either first half or second half.
                prev.next = midNode;
                midNode.next = list2;
            } else {
                prev.next = list2;
            }
        }
 return ans;

    }
    private Node reverse(Node head){
        Node curr=head,prev=null,point;
        while(curr!=null){
            point=curr.next;
            curr.next=prev;
            prev=curr;
            curr=point;
        }
        return prev;
    }
    private boolean compareLists(Node head1,Node head2){
        Node curr=head1 ,curr1=head2;
      while(curr!=null && curr1!=null){
          if (curr.value == curr1.value) {
              curr = curr.next;
              curr1 = curr1.next;
          }
          else
              return false;
      }
        return curr == null && curr1 == null;
    }
    static boolean isPalindrome1(Node head)
    {

        Node slow = head;
        boolean ispalin = true;
        Stack<Integer> stack = new Stack<>();

        while (slow != null) {
            stack.push(slow.value);
            slow = slow.next;
        }

        while (head != null) {

            int i = stack.pop();
            if (!(head.value == i)) {
                ispalin = false;
                break;
            }
            head = head.next;
        }
        return ispalin;
    }

}
