package GeeksForGeeks.Stacks;

public class ArrayStack<E> implements InterfaceStack<E> {
    private static final int  MaxSize=10;
    private int top=-1;
    private E [] data ;
    public ArrayStack(){
        this(MaxSize);
    }
    public ArrayStack(int maxSize){
        data =(E[])new Object[maxSize];
    }
   public int size(){
        return top+1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public void push(E e) throws IllegalStateException{
        if(size()==data.length) throw new IllegalStateException("Stack is full");
        data[++top]=e;

    }
    public E pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        E ans = data[top];
        data[top]=null;
        top--;
        return ans;
    }
   public E peek(){
        if(isEmpty())
            return null;
        return data[top];
   }

    public static void main(String[] args) {
        ArrayStack<Integer> stk = new ArrayStack<>();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);
        System.out.println(stk.peek());
        System.out.println(stk.pop());
        System.out.println(stk.peek());
    }
}
