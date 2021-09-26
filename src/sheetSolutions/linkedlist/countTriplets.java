package sheetSolutions.linkedlist;

import java.util.HashMap;

/*
The program aims to count triplets in a doubly linked list that sum up to given value.
 */
public class countTriplets {

    static int countPairs(Node first, Node second,int value){
        int count=0;
        // The loop terminates when either of two pointers
        // become null, or they cross each other (second.next
        // == first), or they become same (first == second)
        while(first!=null && second!=null && first!=second && second.next!=first){
            if(first.value+second.value==value){
                count++;
                first=first.next;
                second=second.prev;
            }
            else if(first.value+second.value<value){
                first=first.next;
            }
            else
                second = second.prev;
        }
        return count;
    }
    static int countTriples(Node head,int x){
        //o(n2)
        if (head==null)
            return 0;
        Node first;
        int count=0;
        Node second=head,current;
        while (second.next!=null){
            second=second.next;
        }
        // traversing the doubly linked list
        for (current = head; current != null; current = current.next) {

            // for each current node
            first = current.next;

            // count pairs with sum(x - current.value) in the range
            // first to last and add it to the 'count' of triplets
            count += countPairs(first, second, x - current.value);
        }

        return count;
    }
   /* Another approach could be : hashing
   Create a hash table with (key, value) tuples represented as (node value, node pointer) tuples. Traverse the
  doubly linked list and store each node’s value and its pointer pair(tuple) in the hash table. Now, generate
  each possible pair of nodes. For each pair of nodes, calculate the p_sum(sum of value in the two nodes) and
  check whether (x-p_sum) exists in the hash table or not. If it exists, then also verify that the two nodes
  in the pair are not same to the node associated with (x-p_sum) in the hash table and finally increment count. Return (count / 3) as each triplet is counted 3 times in the above process.
    */
   static int countTriplets1(Node head, int x)
   {
       Node ptr, ptr1, ptr2;
       int count = 0;

       // unordered_map 'um' implemented as hash table
       HashMap<Integer,Node> um = new HashMap<>();

       // insert the <node value, node pointer> tuple in 'um'
       for (ptr = head; ptr != null; ptr = ptr.next)
           um.put(ptr.value, ptr);

       // generate all possible pairs
       for (ptr1 = head; ptr1 != null; ptr1 = ptr1.next)
           for (ptr2 = ptr1.next; ptr2 != null; ptr2 = ptr2.next) {

               // p_sum - sum of elements in the current pair
               int p_sum = ptr1.value + ptr2.value;

               // if 'x-p_sum' is present in 'um' and either of the two nodes
               // are not equal to the 'um[x-p_sum]' node
               if (um.containsKey(x - p_sum) && um.get(x - p_sum) != ptr1
                       && um.get(x - p_sum) != ptr2)

                   // increment count
                   count++;
           }

       // required count of triplets
       // division by 3 as each triplet is counted 3 times
       return (count / 3);
   }
}
