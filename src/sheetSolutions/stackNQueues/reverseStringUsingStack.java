package sheetSolutions.stackNQueues;

import java.util.Stack;

public class reverseStringUsingStack {
  static String reverse(String S) {
    // code here
    String s1 = "";
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < S.length(); i++) {
      s.push(S.charAt(i));
    }
    while (!s.isEmpty()) {
      s1 = s1 + s.pop();
    }
    return s1;
  }

  public static void main(String[] args) {
    String str = "Geeks";
    System.out.println(str);
    System.out.println(reverse(str));
  }
}
