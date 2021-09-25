package sheetSolutions.linkedlist;
/*
This program aims to find a pair of elements in linked list with the sum equal to a value.
 */
public class findPairsWithSumInDoublyLinkedList {
    static void pairSum(Node head,int x){
        Node first=head,second=head;
       boolean found=false;
        while(second.next!=null){
            second=second.next;//make second point to last node
        }
        while(first!=second && second.next!=first){//loop terminates when first equals to second or first becomes greater than second
            if((first.value+second.value)==x){
                found=true;
                System.out.println(first.value+" "+ second.value);
                first=first.next;
                second=second.next;
            }
            else{
                if((first.value+second.value)<x){
                    first=first.next;//move first in forward direction
                }
                else{
                    second=second.prev;//move second in backward direction
                }
            }
        }
        if(!found){
            System.out.println("element not found");

        }
    }
}
