package sheetSolutions.linkedlist;
/*
This program aims to add two numbers represented by linked lists.
 */
public class addTwoNumbersRepresentedByLinkedLists {
    static Node add(Node first,Node second){
        first=reverse(first);
        second=reverse(second);
        Node result=null,prev=null,temp=null;
        int sum,carry=0;

        while (first!=null || second!=null){
            int a= (first!=null)? first.value : 0;
            int b= (second!=null)? second.value : 0;
            sum=carry+a+b;
            carry=(sum>=10)?1:0;
            sum=sum%10;
            temp=new Node(sum);
            if(result==null){
                result=temp;
            }
            else{
                prev.next=temp;
            }
            prev=temp;
            if(first!=null){
                first=first.next;
            }
            if(second!=null){
                second=second.next;
            }
        }
        if(carry>0){//if result is greater than no. of digits in individual values
            temp.next=new Node(carry);
        }
        result=reverse(result);
        return result;
    }
    static private Node reverse(Node head){
        Node curr=head,prev=null,link;
        while(curr!=null){
            link=curr.next;
            curr.next=prev;
            prev=curr;
            curr=link;
        }
        return prev;
    }
}
