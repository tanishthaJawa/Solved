package sheetSolutions.stackNQueues;
/*
implement a stack which will support following operations in O(1) time complexity?
1) push() which adds an element to the top of stack.
2) pop() which removes an element from top of stack.
3) findMiddle() which will return middle element of the stack.
4) deleteMiddle() which will delete the middle element.
If there are even elements in stack, findMiddle() returns the second middle element. For example, if stack
contains {1, 2, 3, 4}, then findMiddle() would return 3.
 */
public class OperationsOnMiddleOfStack {
  /*
  Deleting an element from middle is not O(1) for array. Also, we may need to move the middle pointer up when
    we push an element and move down when we pop(). In singly linked list, moving middle pointer in both
    directions is not possible. The idea is to use Doubly Linked List (DLL).
    */
  static class DLLNode {
    DLLNode prev; // prev here is said in terms of stack . for eg if stack has 1,2 then 1 prev is 2
    int data;
    DLLNode next;

    DLLNode(int d) {
      data = d;
    }
  }
  /* Representation of the stack data structure that
  supports findMiddle() in O(1) time.  The Stack is
  implemented using Doubly Linked List. It maintains
  pointer to head node, pointer to middle node and
  count of nodes */
  class myStack {
    DLLNode head;
    DLLNode mid;
    int count;
  }
  // function that creates a stack
  myStack createMyStack() {
    myStack ms = new myStack();
    ms.count = 0;
    return ms;
  }

  void push(int item, myStack ms) {
    DLLNode newNode = new DLLNode(item);
    /* Since we are adding at the beginning,
    prev is always NULL */
    newNode.prev = null;
    // link the old list
    newNode.next = ms.head;
    // increment count
    ms.count++;
    /* Change mid-pointer in two cases
    1) Linked List is empty
    2) Number of nodes in linked list is odd */
    if (ms.count == 1) {
      ms.mid = newNode;
    } else {
      ms.head.prev = newNode; // change prev of head node
      if (ms.count % 2 == 0) { // even nodes
        ms.mid = ms.mid.prev;
      }
    }
    /* move head to point to the new DLLNode */
    ms.head = newNode;
  }

  int pop(myStack ms) {
    /* Stack underflow */
    if (ms.count == 0) {
      System.out.println("Stack is empty");
      return -1;
    }
    DLLNode head = ms.head;
    int d = head.data;
    ms.head = head.next;
    // If linked list doesn't become empty, update prev
    // of new head as NULL
    if (ms.head != null) {
      ms.head.prev = null;
    }
    ms.count--;
    // update the mid-pointer when we have odd number
    // of elements in the stack, i,e move down the mid-pointer.
    if (ms.count % 2 != 0) {
      ms.mid = ms.mid.next;
    }
    return d;
  }

  int findMiddle(myStack ms) {
    if (ms.count == 0) {
      System.out.println("Stack is empty now");
      return -1;
    }
    return ms.mid.data;
  }

  int deleteMiddle(myStack ms) {
    if (ms.count == 0) {
      System.out.println("stack is empty");
      return -1;
    }
    DLLNode mid = ms.mid;
    int item = mid.data;
    ms.count--;
    if (ms.count == 1) {
      ms.head = ms.head.next;
      ms.mid = ms.head;
    } else if (ms.count > 0) {
      ms.mid.prev.next = ms.mid.next; // change prev of top node
      ms.mid.next.prev = ms.mid.prev;
      if (ms.count % 2 != 0) { // if odd nodes left after deletion
        ms.mid = ms.mid.next;
      } else ms.mid = ms.mid.prev;
    }
    return item;
  }

  public static void main(String[] args) {
    OperationsOnMiddleOfStack s = new OperationsOnMiddleOfStack();
    myStack ms = s.createMyStack();
    s.push(1, ms);
    s.push(2, ms);
    s.push(3, ms);
    s.push(4, ms);
    System.out.println(s.findMiddle(ms));
    System.out.println(s.pop(ms));
    System.out.println(s.findMiddle(ms));
    System.out.println(s.deleteMiddle(ms));
    System.out.println(s.findMiddle(ms));
  }
}
