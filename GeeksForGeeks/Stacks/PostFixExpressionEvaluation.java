package GeeksForGeeks.Stacks;
import java.util.Stack;
/* This code works for few operators and only for digits with single numbers*/
public class PostFixExpressionEvaluation {
    public static int postfixEvaluation(String expr){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if(Character.isDigit(ch)){
                stack.push(ch-'0');//subtract 0 to convert to integer
            }
            else {
                int val1= stack.pop();//top element would be second element
                int val2= stack.pop();
                switch (ch){
                    case'+':stack.push(val2+val1);
                              break;
                    case'-':stack.push(val2-val1);
                        break;
                    case'*':stack.push(val2*val1);
                        break;
                    case'/':stack.push(val2/val1);
                        break;
                }
            }
        }
       return stack.pop();
    }

    public static void main(String[] args) {
        String expr="231*+9-";
        System.out.println(postfixEvaluation(expr));
    }

}
