package sheetSolutions.stackNQueues;
/*
The problem is to implement  2 stacks in one array efficiently.
 */

public class twoStacks {
  /*
  A simple approach would be to divide the array in two halves and then use stacks. But  much efficient approach
  would be to s to start two stacks from two extreme corners of arr[]. stack1 starts from the leftmost element, the first
   element in stack1 is pushed at index 0. The stack2 starts from the rightmost corner, the first element in stack
   2 is pushed at index (n-1). Both stacks grow (or shrink) in opposite direction.
   */
  static class TwoStack { // Just for reference

    int size;
    int top1, top2;
    int[] arr = new int[100];

    TwoStack() {
      size = 100;
      top1 = -1;
      top2 = size;
    }
  }

  void push1(int x, TwoStack sq) {
    if (sq.top1 < sq.top2 - 1) { // there is at least one empty space between stacks
      sq.top1++;
      sq.arr[sq.top1] = x;
    } else System.out.println("Stack overflow");
  }

  void push2(int x, TwoStack sq) {
    if (sq.top1 < sq.top2 - 1) {
      sq.top2--;
      sq.arr[sq.top2] = x;
    } else {
      System.out.println("Stack overflow");
      System.exit(1);
    }
  }

  int pop1(TwoStack sq) {
    if (sq.top1 > 0) {
      int ans = sq.arr[sq.top1];
      sq.top1--;
      return ans;

    } else return -1;
  }

  int pop2(TwoStack sq) {
    if (sq.top2 < sq.size) {
      int ans = sq.arr[sq.top2];
      sq.top2++;
      return ans;
    } else return -1;
  }

  public static void main(String[] args) {
    twoStacks s = new twoStacks();
    TwoStack sq = new TwoStack();
    s.push1(1, sq);
    s.push1(2, sq);
    s.push2(5, sq);
    System.out.println(s.pop1(sq));
    System.out.println(s.pop2(sq));
  }
}
