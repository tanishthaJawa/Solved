package hackerRank.DataStructures.stacks;

import java.util.Scanner;
import java.util.Stack;

/*
Implement a simple text editor. The editor initially contains an empty string, . Perform  operations of the following  types:

append - Append string  to the end of string.
delete - Delete the last  characters of string .
print - Print the  character of .
undo - Undo the last (not previously undone) operation of type  or , reverting  to the state it was in prior to that operation.

 */
public class textEditor {
  // logic is correct but gives tle in some cases due to some input issues
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String s = "";
    Stack<String> st = new Stack<>();
    st.push(s);
    for (int i = 0; i < n; i++) {
      int t = in.nextInt();
      switch (t) {
        case 1:
          s = s + in.nextInt();
          st.push(s);
          break;
        case 2:
          s = s.substring(0, s.length() - in.nextInt());
          st.push(s);
          break;
        case 3:
          System.out.println(s.charAt(in.nextInt() - 1));
          break;
        case 4:
          st.pop();
          s = st.peek();
          break;
      }
    }
  }
}
