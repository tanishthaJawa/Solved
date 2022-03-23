package sheetSolutions.stackNQueues;
/*
This program aims to implement a stack using queue
 */
import java.util.LinkedList;
import java.util.Queue;

public class StacksUsingTwoQueues {
 private int size;
 private Queue<Integer> q1 = new LinkedList<>();
 private Queue<Integer> q2 = new LinkedList<>();

  StacksUsingTwoQueues() {
    size = 0;
  }

  public void push(int item) {
    size++;
    q1.add(item);
  }

  public int pop() {
    if (q1.isEmpty()) return -1;
    // Leave one element in q1 and
    // push others in q2.
    while (q1.size() != 1) {
      q2.add(q1.peek());
      q1.poll();
    }
    // Pop the only left element
    // from q1
    int ans = q1.poll();
    size--;
    // swap the names of two queues
    Queue<Integer> q = q1;
    q1 = q2;
    q2 = q;
    return ans;
  }

  public int top() {
    if (q1.isEmpty()) return -1;
    while (q1.size() != 1) {
      q2.add(q1.peek());
      q1.poll();
    }
    int ans = q1.peek(); // last element is the top element
    q1.poll(); // remove last element from q1. q1 becomes empty
    q2.add(ans); // add the last element to q.
    // swap the names of two queues
    Queue<Integer> q = q1;
    q1 = q2;
    q2 = q;
    return ans;
  }

  int size() {
    return size;
  }

  public static void main(String[] args) {
      StacksUsingTwoQueues s = new StacksUsingTwoQueues();
      s.push(10);
      s.push(20);
      s.push(30);
      s.push(40);
    System.out.println(s.size());
    System.out.println(s.top());
    System.out.println(s.pop());
    System.out.println(s.top());
    System.out.println(s.size());
  }
}
