package GeeksForGeeks.Stacks;
import java.util.Stack;
public  class BalancedBrackets {
   static Stack<Character> s= new Stack<>();
    public static String balancedParentheses(String str){
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch=='('|| ch=='{'|| ch=='[')
                s.push(ch);
            else{
                if(s.isEmpty())// if stack is empty means there is a closing bracket without opening bracket
                    return "Imbalanced";
                char c = s.pop();
                switch (ch){
                    case ')': if(c=='['|| c=='{')
                                return "imbalanced";
                                break;
                    case']': if(c=='('|| c=='{')
                                return "imbalanced";
                               break;
                    case'}': if(c=='('||c=='[')
                              return "imbalanced";
                             break;
                }
            }
        }
        if(s.isEmpty())
            return "balanced";
        else
        return "Imbalanced";
    }

    public static void main(String[] args) {
        String str="([])}";
        System.out.println(balancedParentheses(str));
    }
}
