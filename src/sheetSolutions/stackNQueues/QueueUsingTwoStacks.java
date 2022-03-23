package sheetSolutions.stackNQueues;
/*
This program aims to implement a queue using stack
 */
import java.util.Stack;

public class QueueUsingTwoStacks {
  private int size;
  Stack<Integer> s1 = new Stack<>();
  Stack<Integer> s2 = new Stack<>();

  QueueUsingTwoStacks() {
    size = 0;
  }

  public void enqueue(int item) {
    s1.push(item);
    size++;
  }

  public int dequeue() {
    int x;
    if (s1.isEmpty() && s2.isEmpty()) return -1;
    if (s2.isEmpty()) {
      while (!s1.isEmpty()) {
        x = s1.pop();
        s2.push(x);
      }
    }
    x = s2.pop();
    size--;
    return x;
  }

  public int top() {
    int x;
    if (s1.isEmpty() && s2.isEmpty()) return -1;
    if (s2.isEmpty()) {
      while (!s1.isEmpty()) {
        x = s1.pop();
        s2.push(x);
      }
    }
    x = s2.peek();
    return x;
  }

  public int size() {
    return size;
  }

  public static void main(String[] args) {
    QueueUsingTwoStacks q = new QueueUsingTwoStacks();
    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);
    q.enqueue(40);
    System.out.println(q.size());
    System.out.println(q.top());
    System.out.println(q.dequeue());
    System.out.println(q.top());
    System.out.println(q.dequeue());
    System.out.println(q.top());
    System.out.println(q.size());
  }
}
