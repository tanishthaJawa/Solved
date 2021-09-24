package sheetSolutions.linkedlist;
/*
This program has a Y shaped lists . we need to find where two lists point to common  nodes.
 */
public class IntersectionPointOfLinkedLists {
    /*
    Method Using difference of node counts:

Get count of the nodes in the first list, let be c1.
Get count of the nodes in the second list, let be c2.
Get the difference of counts d = abs(c1 – c2).
Now traverse the bigger list from the first node till d nodes so that from here onwards both the lists have
equal no of nodes.
Then we can traverse both the lists simultaneously till we come across a common node.
     */
    static int intersection(Node head1,Node head2){
        //Time complexity:O(n+m), Space complexity:O(1)
        Node curr1=head1,curr2=head2;
        int count1=0,count2=0;
        while (curr1!=null){//count the no. of nodes
            count1++;
            curr1=curr1.next;
        }
        while (curr2!=null){//count the no. of nodes in second list
            count2++;
            curr2=curr2.next;
        }
        int diff= Math.abs(count1-count2);
        int j=0;
        curr1=head1;
        curr2=head2;
        if(count1>count2){
            while (j<diff){
                if(curr1==null)
                    return -1;
                curr1=curr1.next;
                j++;
            }
        }
        else{
            while (j<diff){
                if(curr2==null)
                    return -1;
                curr2=curr2.next;
                j++;
            }
        }
        while (curr1!=null && curr2!=null){
            if(curr1.next==curr2.next){
                return curr1.next.value;
            }
            curr1=curr1.next;
            curr2=curr2.next;
        }
        return -1;
    }
    /*
    Another approaches could be :
    to detect if intersection point exists:
 1)    Traverse the list 1, store the last node address
2) Traverse the list 2, store the last node address.
3) If nodes stored in 1 and 2 are same then they are intersecting.

to find the intersection points:

Using hashing:
Basically, we need to find a common node of two linked lists. So we hash all nodes of the first list and then
 check the second list.
1) Create an empty hash set.
2) Traverse the first linked list and insert all nodes’ addresses in the hash set.
3) Traverse the second list. For every node check if it is present in the hash set. If we find a node in the
hash set, return the node.

We can mark visited flag with each linked list if a node has already been visited, but this requires modification
of linked list.


Using Two pointers :

Initialize two pointers ptr1 and ptr2  at the head1 and  head2.
Traverse through the lists,one node at a time.
When ptr1 reaches the end of a list, then redirect it to the head2.
similarly, when ptr2 reaches the end of a list, redirect it the head1.
Once both of them go through reassigning, they will be equidistant from
 the collision point
If at any node ptr1 meets ptr2, then it is the intersection node.
After second iteration if there is no intersection node it returns NULL.

     */
}
