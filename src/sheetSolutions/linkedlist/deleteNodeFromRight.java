package sheetSolutions.linkedlist;
/*
This program aims to delete all nodes which have greater value on its right side. The greater node could be anywhere
on the right side.
 */
public class deleteNodeFromRight {
    /*
    The main idea is to reverse the list and to keep track of max so far and if there is any value on traversing
    the list after reversing which is less than max_so_far.delete it.
     */
    static Node delete1(Node head) {
        Node head1 = reverse(head);
        Node curr = head;
        while (curr != null && curr.next != null) {
            int max_so_far = curr.value;
            if (max_so_far > curr.next.value) {
                Node temp = curr.next;
                curr.next = temp.next;
            } else {
                curr = curr.next;
            }
        }
        return reverse(head1);
    }

    static Node delete(Node head) {
        //Second approach. We use recursion.Indirectly it follows above approach
        if (head.next == null)//this makes sure list is traversed backward.
            return head;
        Node temp = delete(head.next);
        if (temp.value > head.value)
            return temp;//this keeps track of max_so_far
        else
            head.next = temp;// this deletes all values less than max_so_far
        return head;
    }

    static Node reverse(Node head) {
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