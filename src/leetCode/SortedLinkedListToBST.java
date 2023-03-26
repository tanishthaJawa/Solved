package leetCode;

import sheetSolutions.binarySearchTree.Node;

import java.util.ArrayList;
import java.util.List;

public class SortedLinkedListToBST {


    public Node generate(sheetSolutions.linkedlist.Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new Node(head.value);
        }

        sheetSolutions.linkedlist.Node slow = head;
        sheetSolutions.linkedlist.Node fast = head.next.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node result = new Node(slow.next.value);
        sheetSolutions.linkedlist.Node rightSubTree = slow.next.next;
        slow.next = null;
        result.left = generate(head);
        result.right = generate(rightSubTree);
        return result;
    }
}
