package GeeksForGeeks.Stacks;
/* This code works for multiple digits using space as identifier*/
import java.util.Stack;

public class PostFixEvaluationPartTwo {
    public static int postfixEvaluation(String expr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch == ' ') {
                continue;
            }
            else if (Character.isDigit(ch)) {
                int n = 0;
                while (Character.isDigit(ch)) {
                    n = n * 10 + (ch - '0');// add the digits
                    i++;
                    ch = expr.charAt(i);// scan next digit, if it is not a digit subtract i
                }
                i--;
                stack.push(n);
            }
            else {
                int val1 = stack.pop();//top element would be second element
                int val2 = stack.pop();
                switch (ch) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String expr="100 200 + 2 / 5 * 7 +";
        System.out.println(postfixEvaluation(expr));
    }
}
