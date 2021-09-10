package GeeksForGeeks.Stacks;

public class LinkedListStack {
    static class LinkedListNode{
        int data;
        LinkedListNode next =null;
        LinkedListNode(int e){
            data=e;
        }

    }
    LinkedListNode root;
    private int size=0;
    public int size(){
      return size;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public void push(int d){
        LinkedListNode newNode = new LinkedListNode(d);
        if(root==null){
            root= newNode;
        }
        else{
            LinkedListNode temp = root;
            root = newNode;
            newNode.next=temp;
        }
        size++;
    }
    public int pop(){
        if(isEmpty())
            System.out.println("Stack is empty");
         else {
             int ans = root.data;
             root=root.next;
              size--;
             return ans;
        }
         return -1;
    }
    public  int peek(){
        if(root==null)
            return -1;
        return root.data;
    }

    public static void main(String[] args) {
        LinkedListStack stk = new LinkedListStack();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        System.out.println(stk.peek());
        System.out.println(stk.pop());
        System.out.println(stk.peek());
    }
}
