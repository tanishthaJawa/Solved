package GeeksForGeeks.Stacks;
//Reversing a string using stack
public  class ReverseString {
    private static class Stack{
        private int top=-1;
        private char[] stack ;
        Stack(int size){
            stack=new char[size];
        }
        public boolean isEmpty(){
            return top==-1;
        }
        public int size(){
            return top+1;
        }
        public void push(char data){
            if(size()==stack.length){
                System.out.println("Overflow");
            }
            else {
                stack[++top]=data;
            }

        }
        public char peek(){
            if(isEmpty())
                return ' ';
            return stack[top];
        }
        public char pop(){
            if(isEmpty()){
                System.out.println("Underflow");
                return ' ';
            }
            char ans =stack[top];
            top--;
            return ans;
        }
    }

    public static StringBuilder reverseString(StringBuilder str){
        Stack s = new Stack(str.length());
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            s.push(ch);
        }
        for (int i = 0; !s.isEmpty(); i++) {
            str.setCharAt(i,s.pop());
        }
     return str;
    }
    public static void swap(char[] arr,int i, int  j){//Swap without using stack
        char temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static String reverse2(String str){
        char[] arr= str.toCharArray();
        for (int k = 0; k < str.length()/2; k++) {
           swap(arr,k,str.length()-k-1);
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        StringBuilder str=new StringBuilder("Hi TANISHTHA");
        System.out.println(reverseString(str));
        System.out.println(reverse2("hello"));
    }

}
