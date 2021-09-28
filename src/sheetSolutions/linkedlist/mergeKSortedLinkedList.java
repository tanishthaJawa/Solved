package sheetSolutions.linkedlist;
/*
This program aims to merge k sorted lists of different sizes to return a single linked list.
 */
public class mergeKSortedLinkedList {
    /*
    The idea is to keep merging the lists until only last list is left. First we merge k lists. After first cycle
    k/2 lists are left. then k/4 and so on.
    time complexity: O(nk Log k)
     */
    static Node mergeKLists(Node[]arr,int k){
        int last=k-1;
        // repeat until only one list is left
        while(last!=0){
            int i=0,j=last;
            while(i<j){// merge two lists
                arr[i]=sortedMerge(arr[i],arr[j]);//results in k/2 lists
                i++;
                j--;
                if(i>=j)//prepares for next cycle i.e for lists returned after merging
                    last=j;
            }
        }
        return arr[0];
    }
   static Node sortedMerge(Node head1,Node head2){
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
        if(head1.value< head2.value){
            head1.next=sortedMerge(head1.next,head2);
            return head1;
        }
        else{
            head2.next=sortedMerge(head1,head2.next);
            return head2;
        }
    }
}
