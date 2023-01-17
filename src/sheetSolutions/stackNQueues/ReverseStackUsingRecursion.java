package sheetSolutions.stackNQueues;

import java.util.Stack;

public class ReverseStackUsingRecursion {

    static void reverse(Stack<Integer> s) {
        // add your code here

        if (!s.isEmpty()) {
            int temp = s.pop();
            reverse(s);
            insert(s, temp);
        }

    }

    static void insert(Stack<Integer> tempStack, int element) {
        if (tempStack.isEmpty()) {
            tempStack.push(element);
        } else {
            int temp = tempStack.pop();
            insert(tempStack, element);
            tempStack.push(temp);
        }


    }
}
