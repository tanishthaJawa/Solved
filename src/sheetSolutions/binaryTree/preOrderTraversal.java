package sheetSolutions.binaryTree;

import java.util.Stack;

// program to implement preorder traversal of binary tree. Root, left,right
public class preOrderTraversal {
  static void preOrder(Node root) {
    if (root == null) return;
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  static void preOrderIterative(Node root) {
    /*
     if (node = null)
      return
    s —> empty stack
    s.push(node)
    while (not s.isEmpty())
      node —> s.pop()
      visit(node)
      if (node.right != null)
        s.push(node.right)
      if (node.left != null)
        s.push(node.left)
             */
    // return if the tree is empty
    if (root == null) {
      return;
    }

    // create an empty stack and push the root node
    Stack<Node> stack = new Stack<>();
    stack.push(root);

    // loop till stack is empty
    while (!stack.empty()) {
      // pop a node from the stack and print it
      Node curr = stack.pop();

      System.out.print(curr.data + " ");

      // push the right child of the popped node into the stack
      if (curr.right != null) {
        stack.push(curr.right);
      }

      // push the left child of the popped node into the stack
      if (curr.left != null) {
        stack.push(curr.left);
      }

      // the right child must be pushed first so that the left child
      // is processed first (LIFO order)

    }
  }

  public static void main(String[] args) {
    /* Construct the following tree
               1
             /   \
            /     \
           2       3
          /      /   \
         /      /     \
        4      5       6
              / \
             /   \
            7     8
    */

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.right.left = new Node(5);
    root.right.right = new Node(6);
    root.right.left.left = new Node(7);
    root.right.left.right = new Node(8);
    preOrder(root);
    System.out.println();
    preOrderIterative(root);
  }
}
