import java.util.*;
/*
Given a Queue Q containing N elements. The task is to reverse the Queue. Your task is to complete the function rev(),
that reverses the N elements of the queue.

Example 1:

Input:
6
4 3 1 10 2 6
Output: 
6 2 10 1 3 4
Explanation: 
After reversing the given elements of the queue , the resultant queue will be 6 2 10 1 3 4.
*/  

/* 
Two approaches:
1. Insert all elements in a stack(LIFO) and then add all elements in the queue
2. Use a combination of enqueueing and dequeueing
*/
public class ReverseQueue{
  // Approach 1 Time Complexity: o(n) Space complexity: o(n)
  public static Queue<Integer> rev(Queue<Integer> q){
    Stack<Integer> s = new Stack<>();
     while(!q.isEmpty()){
       s.add(q.poll());
     }

    while(!s.isEmpty()){
      q.add(s.pop());
    }
    return q;
  }

  public static Queue<Integer> reverse(Queue<Integer> q){
    if(q.isEmpty()){
      return q;
    }
    int curr = q.poll();
    reverse(q);
    q.add(curr);
    return q;
  }

   public static void print(Queue<Integer> queue)
    {
        while (!queue.isEmpty()) {
            System.out.print(queue.peek() + ", ");
            queue.remove();
        }
    }
   public static void main(String args[])
    {
      Queue<Integer>  queue = new LinkedList<Integer>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);
        queue.add(90);
        queue.add(100);
 
        reverse(queue);
        rev(queue);
        Print(queue);
    }
}
