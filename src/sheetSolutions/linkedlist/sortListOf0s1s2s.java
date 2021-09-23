package sheetSolutions.linkedlist;

public class sortListOf0s1s2s {
    static Node sort(Node head){
        Node zeroD=new Node(0);
        Node oneD=new Node(0);
        Node twoD=new Node(0);
        Node zero=zeroD,one=oneD,two=twoD;
        Node curr=head;
        while(curr!=null){
            if(curr.value==0){
                zero.next=curr;
                zero=zero.next;
            }
            else  if(curr.value==1){
                one.next=curr;
                one=one.next;
            }
            else{
                two.next=curr;
                two=two.next;
            }
            curr=curr.next;
        }
        zero.next=(oneD.next!=null)? oneD.next:twoD.next;
        one.next=twoD.next;
        two.next=null;
        return zeroD.next;
    }
}
