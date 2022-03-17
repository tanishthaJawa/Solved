package sheetSolutions.stackNQueues;

import java.util.Stack;

public class balancedParentheses {

  static boolean isPar(String x) {
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < x.length(); i++) {
      char ch = x.charAt(i);
      if (ch == '(' || ch == '[' || ch == '{') {
        s.push(ch);
      } else {
        if (s.isEmpty())
          return false; // condition if a closing bracket exists without an opening bracket.
        char p = s.pop();
        switch (ch) {
          case ')':
            if (p == '[' || p == '{') return false;
            break;
          case ']':
            if (p == '(' || p == '{') return false;
            break;
          case '}':
            if (p == '(' || p == '[') return false;
            break;
        }
      }
    }
    return s.isEmpty();
  }

  public static void main(String[] args) {
    String str = "()";
    boolean v = isPar(str);
    System.out.println(v);
    if (v) {
      System.out.println("balancedParentheses");
    }
    else {
      System.out.println("UnbalancedParentheses");
    }
  }
}
