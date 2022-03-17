package sheetSolutions.binaryTree;

import java.util.Stack;

public class inOrderTraversal {
  static void inOrder(Node root) {
    if (root == null) return;
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
  }

  static void inOrderIterative(Node root) {
    /*
    s —> empty stack
    while (not s.isEmpty() or node not null)
      if(node!=null){
          s->push node
           node= node.left;
           }
       else{
           node->s.pop()
           visit node
          node=node.right
                }
             */
    // return if the tree is empty
    Node curr = root;
    Stack<Node> s = new Stack<>();
    while (!s.isEmpty() || curr != null) {
      if (curr != null) {
        s.push(curr);
        curr = curr.left;
      } else {
        curr = s.pop();
        System.out.print(curr.data + " ");
        curr = curr.right;
      }
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

    inOrder(root);
    System.out.println();
    inOrderIterative(root);
  }
}
