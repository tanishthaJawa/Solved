package sheetSolutions.linkedlist;
/*
Given elements as nodes of the two linked lists. The task is to multiply these two linked lists, say L1 and L2.

Note: The output could be large take modulo 109+7.
 */
public class multiplyTwoLinkedLists {
    static long multiply(Node l1,Node l2){
        long N=1000000007;
        long num1=0,num2=0;
        while(l1!=null || l2!=null){
            if(l1!=null){
                num1=(num1 * 10) % N + l1.value;
                l1=l1.next;
            }
            if(l2!=null) {
                num2 = (num2 * 10) % N + l2.value;
                l2 = l2.next;
            }
        }
        return ((num1 % N )* (num2 % N )) % N;
    }
}
