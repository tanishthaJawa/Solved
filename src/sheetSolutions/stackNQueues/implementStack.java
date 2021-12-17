package sheetSolutions.stackNQueues;

public class implementStack {
  private static final int maxSize = 50;
  private int top = -1;
  int[] arr = new int[maxSize];

  void push(int item) {
    if (top == maxSize - 1) {
      System.out.println("Stack overflow");
    } else {
      arr[++top] = item;
    }
  }

  int pop() {
    if (top < 0) {
      System.out.println("Stack underflow");
    } else {
      int ans = arr[top];
      top--;
      return ans;
    }
    return -1;
  }

  int peek() {
    if (top < 0) return -1;
    return arr[top];
  }

  int size() {
    return top + 1;
  }

  public static void main(String[] args) {
    implementStack s = new implementStack();
    s.push(10);
    s.push(20);
    s.push(30);
    System.out.println(s.peek());
    System.out.println(s.size());
    System.out.println(s.pop());
    System.out.println(s.peek());
    System.out.println(s.size());
  }
}
