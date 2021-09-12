package GeeksForGeeks.Stacks;

public class TwoStacks {
    private int top1,top2;
    private int [] arr ;
    TwoStacks(int size){
        arr= new int[size]; // suppose size=6
        top1=size/2+1;// top1=4
        top2=size/2;//top2=3
    }
    public void push1(int data){
        if(top1>0){// stack 1 is the inner stack
            top1--;
            arr[top1]=data;

        }
        else{
            System.out.println("Stack overflow in stack 1");
        }

    }
    public void push2(int data) {
        if (top2<arr.length-1) {
            top2++;
            arr[top2] = data;
        }
        else{
            System.out.println("Stack overflow in stack 2");
        }
    }
    public int pop1(){
        if(top1<0){
            System.out.println("Stack underflow in stack 1");
            return -1;
        }
        int ans = arr[top1];
        top1++;
        return ans;
    }
    public int pop2(){
        if(top2<arr.length/2){
            System.out.println("Stack underflow in stack 2");
            return -1;
        }
        int ans = arr[top2];
        top2--;
        return ans;
    }

    public static void main(String[] args) {
        TwoStacks s= new TwoStacks(6);
        s.push1(4);
        s.push1(5);
        s.push1(6);
        System.out.println(s.pop1());
        s.push1(7);
        s.push2(1);
        s.push2(2);
        s.push2(3);
        System.out.println(s.pop2());
       // s.push2(0);


    }
}
