package sheetSolutions.stackNQueues;

import java.util.Stack;

public class SortStack {

    public void sort2(Stack<Integer> s) {
        // Take care of recursion stack
        if (!s.isEmpty()) {
            int temp = s.pop();
            sort2(s);
            sortInsert(s, temp);
        }
    }

    private void sortInsert(Stack<Integer> s, int element) {
        if (s.isEmpty() || element > s.peek()) {
            s.push(element);
        } else {
            int temp = s.pop();
            sortInsert(s, element);
            s.push(temp);
        }
    }

    //Alternative approach
    public Stack<Integer> sort(Stack<Integer> s) {
        //add code here.
        Stack<Integer> tempStack = new Stack<>();

        while (!s.isEmpty()) {
            int temp = s.pop();

            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                s.push(tempStack.pop());
            }
            tempStack.push(temp);
        }

        return tempStack;
    }


    public static void main(String[] args) {

    }
}
