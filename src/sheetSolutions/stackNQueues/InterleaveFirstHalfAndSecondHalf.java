import java.util.*;

// InterLeave first Half elements of Queue to Second Half
// Q : 11 12 13 14 15 16 17 18 19 20 Expected: 11 16 12 17 13 18 14 19 15 20

// Approach 1 :
//  - Take first half elements of the queue. 
// Add them to another queue and then poll one element from new queue and one from old queue and enqueeu them back to old queue
// New Queue: 11 12 13 14 15
// Old queue: 16 17 18 19 20
// after one iteration
// New queue: 12 13 14 15
// Old queue : 17 18 19 20 11 16
class InterLeaveElements {
    public static ArrayList<Integer> rearrangeQueue(int N, Queue<Integer> q) {
        // code here
        Queue<Integer> q1 = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(q.size()%2!=0){
            return new ArrayList<>();
        }
        
        int halfsize = q.size()/2;
        for(int i = 0; i<halfsize;i++){
            q1.add(q.poll());
        }
        
        while(!q1.isEmpty()){
            int firstHalfEle = q1.poll();
            int secondHalfEle = q.poll();
            res.add(firstHalfEle);
            res.add(secondHalfEle);
        }
        
        
        return res;
    }
}

// Approach 2:
// Following are the steps to solve the problem: 

//Push the first half elements of the queue to stack. 
//Enqueue back the stack elements. 
//Dequeue the first half elements of the queue and enqueue them back. 
//Again push the first half elements into the stack. 
//Interleave the elements of queue and stack. 
 
class GFG {
 
    // Function to interleave the queue
    static void interLeaveQueue(Queue<Integer> q)
    {
        // To check the even number of elements
        if (q.size() % 2 != 0)
            System.out.println(
                "Input even number of integers.");
 
        // Initialize an empty stack of int type
        Stack<Integer> s = new Stack<>();
        int halfSize = q.size() / 2;
 
        // Push first half elements into the stack
        // queue:16 17 18 19 20, stack: 15(T) 14 13 12 11
        for (int i = 0; i < halfSize; i++) {
            s.push(q.peek());
            q.poll();
        }
 
        // enqueue back the stack elements
        // queue: 16 17 18 19 20 15 14 13 12 11
        while (!s.empty()) {
            q.add(s.peek());
            s.pop();
        }
 
        // dequeue the first half elements of queue
        // and enqueue them back
        // queue: 15 14 13 12 11 16 17 18 19 20
        for (int i = 0; i < halfSize; i++) {
            q.add(q.peek());
            q.poll();
        }
 
        // Again push the first half elements into the stack
        // queue: 16 17 18 19 20, stack: 11(T) 12 13 14 15
        for (int i = 0; i < halfSize; i++) {
            s.push(q.peek());
            q.poll();
        }
 
        // interleave the elements of queue and stack
        // queue: 11 16 12 17 13 18 14 19 15 20
        while (!s.empty()) {
            q.add(s.peek());
            s.pop();
            q.add(q.peek());
            q.poll();
        }
    }
 
    // Driver code
    public static void main(String[] args)
    {
        Queue<Integer> q = new java.util.LinkedList<>();
        q.add(11);
        q.add(12);
        q.add(13);
        q.add(14);
        q.add(15);
        q.add(16);
        q.add(17);
        q.add(18);
        q.add(19);
        q.add(20);
        interLeaveQueue(q);
        int length = q.size();
        for (int i = 0; i < length; i++) {
            System.out.print(q.peek() + " ");
            q.poll();
        }
    }
}
   
