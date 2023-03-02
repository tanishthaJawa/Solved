package sheetSolutions.linkedlist;

/*
This program aims to add two numbers represented by linked lists.
 */
public class addTwoNumbersRepresentedByLinkedLists {
    static Node add(Node first, Node second) {
        first = reverse(first);
        second = reverse(second);
        Node result = new Node(0), resultHead = result;
        int sum, carry = 0;

        while (first != null || second != null) {
            int a = (first != null) ? first.value : 0;
            int b = (second != null) ? second.value : 0;
            sum = carry + a + b;
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;

            result.next = new Node(sum);
            result = result.next;

            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }
        if (carry > 0) {//if result is greater than no. of digits in individual values
            result.next = new Node(carry);
        }

        return reverse(resultHead.next);
    }

    static private Node reverse(Node head) {
        Node curr = head, prev = null, link;
        while (curr != null) {
            link = curr.next;
            curr.next = prev;
            prev = curr;
            curr = link;
        }
        return prev;
    }
}
