package sheetSolutions.linkedlist;

public class mergeSortForLinkedLists {
    static Node mergeSort(Node head){
        Node middle=getMiddle(head);
        Node nextOfMiddle=middle.next;
        middle.next=null;
        Node leftList= mergeSort(head);
        Node rightList= mergeSort(nextOfMiddle);
        return mergeLists(leftList,rightList);
    }
    static Node getMiddle(Node head){
        Node slow=head,fast=head;
        while (fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static Node mergeLists(Node head1,Node head2){
        if(head1==null){// if one of the list is empty
            return head2;
        }
        if(head2==null){
            return head1;
        }
       if(head1.value< head2.value){
           head1.next=mergeLists(head1.next,head2);//check with next value
           return head1;// this becomes head of new list as it will be the min element
       }
       else{
           head2.next=mergeLists(head1,head2.next);
           return head2;
       }
    }
    static Node mergeLists1(Node head1,Node head2){
        if(head1==null){// if one of the list is empty
            return head2;
        }
        if(head2==null){
            return head1;
        }
        Node dummyNode = new Node(0);
        Node head=dummyNode;
        Node curr1=head1,curr2=head2;
        while (curr1!=null && curr2!=null){
            if(curr1.value< curr2.value){
                head.next=curr1;
                curr1=curr1.next;
            }
            else{
                head.next=curr2;
                curr2=curr2.next;
            }
            head=head.next;
        }
        if(curr1!=null){
            head.next=curr1;
        }
        if(curr2!=null){
            head.next=curr2;
        }
        return dummyNode.next;
    }
}
