package sheetSolutions.linkedlist;

public class QuickSort {
    static Node partition1(Node head,Node tail){
        Node prev=head,curr=head.next;
        Node pivot=head;
        return prev;
    }
    static Node partition(Node head, Node tail) {
        if (head == tail || head == null || tail == null)
            return head;
        Node pivot_prev = head;
        Node curr = head;
        int pivot = tail.value;
        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot. For ex 15->8->1->4->2
        while (head != tail) {
            if (head.value < pivot) {
                pivot_prev = curr; // keep tracks of last modified item
                // In quick sort if we find a value smaller than pivot we swap current
                int temp = curr.value;//value to the value in the beginning such that result gets sorted.(temp=1)
                curr.value = head.value;// here we swap curr value with starting values( curr=15)
                head.value = temp;//(head=1)
                curr = curr.next;// check next values curr=8 at idx 1
            }
            head = head.next;// move head to next position for swapping head=4
        }
        // after above loop list becomes 1->8->15->4->2
        int temp = curr.value;// we swap pivot with the last element that is just less than pivot. temp=8
        curr.value = pivot;
        tail.value = temp;// list becomes 1->2->15->4->8
        // return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;//1
    }

    static void sort(Node head, Node tail) {
        if (head == null || head == tail || head == tail.next)
            return;
        Node pivot_prev = partition(head, tail);
        sort(head, pivot_prev);// something like sort till 0 to partition-1
        // if pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot i.e sort from pivot
        if (pivot_prev != null && pivot_prev == head)
            sort(pivot_prev.next, tail);

            // if pivot is in between of the list,
            // start from next of pivot,
            // since we have pivot_prev, so we move two nodes i.e sort after pivot
        else if (pivot_prev != null
                && pivot_prev.next != null)
            sort(pivot_prev.next.next, tail);// something like sort partition+1 to tail.
    }
}
