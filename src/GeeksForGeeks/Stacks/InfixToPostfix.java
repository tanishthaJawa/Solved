package GeeksForGeeks.Stacks;
import java.util.Stack;
public class InfixToPostfix {
    public static int precedence(char ch){
        //Function deciding precedence
        switch(ch){
            case '+':
            case'-':
                return 1;
            case '*':
            case'/':
                return 2;
            case'^':
                return 3;
        }
        return -1;
    }
    public static String infixConverter(String expr){
        String result="";
        Stack<Character> s= new Stack<>();
        for (int i = 0; i < expr.length(); ++i) {
            /* If character is digit add it to result*/
            char c = expr.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                result = result + c;
            }
            /* If char is ( push it into stack */
            else if (c =='(')
                s.push(c);
            /*  if char is ) pop elements from stack till either stack becomes empty or
             a ( is encountered
             */
            else if (c ==')') {
                while (!s.isEmpty() && s.peek() != '('){
                    result = result + s.pop();
                }
                s.pop();//pops the bracket
            }
            else {
             /* If an operator is encountered and if its precedence is lower than that of
             operator in stack pop it till either stack gets empty or you encounter an
              operator whose precedence is lower than of scanned operator then push it into
              stack.*/
                while (!s.isEmpty() && precedence(c)<precedence(s.peek())) {
                    result = result + s.pop();
                }
                s.push(c);// Otherwise Push into stack
            }
        }
            while (!s.isEmpty()){
                if(s.peek()=='(')
                    return "Invalid expression";
                result=result+s.pop();
            }
            return result;
        }

    public static void main(String[] args) {
        String exp="a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixConverter(exp));
    }
}
