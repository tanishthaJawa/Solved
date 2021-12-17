package sheetSolutions.binaryTree;

import java.util.*;
/* This program aims to find the top view of binary tree.
       1
    /     \
  2       3
  /  \    /   \
4    5  6   7
Top view will be: 4 2 1 3 7
Note: Return nodes from leftmost node to rightmost node.*/

public class topViewOfBinaryTree {
  /* We will use a treeMap to order the values for displaying.
  the idea is to use a level variable that keeps track if an element can be seen from the top on different
   levels. You could use it in node class but since my node class didn't have it. I did the following.
   */
  static ArrayList<Integer> topView(Node root) {
    // add your code
    class NodeAndLevel {
      final int level;
      final Node node;

      NodeAndLevel(Node node, int level) {
        this.level = level;
        this.node = node;
      }
    }
    ArrayList<Integer> result = new ArrayList<>();
    Queue<NodeAndLevel> q = new LinkedList<>();
    Map<Integer, Node> m = new TreeMap<>();
    q.add(new NodeAndLevel(root, 0)); // add a node and its level
    while (!q.isEmpty()) {
      NodeAndLevel temp = q.poll(); // retrieve the node
      if (!m.containsKey(temp.level)) { // check if map does not contain the key
        m.put(temp.level, temp.node); // put the key (level) and node in it.
      }
      if (temp.node.left != null) {
        // This is done so that we can display left values first as treeMap sorts data in asc order
        // based on key
        q.add(
            new NodeAndLevel(
                temp.node.left, temp.level - 1)); // set the level as -1 from that of parent
      }
      if (temp.node.right != null) {
        q.add(
            new NodeAndLevel(
                temp.node.right, temp.level + 1)); // set the level as +1 from that of parent
      }
    }
    for (Node e : m.values()) {
      result.add(e.data);
    }
    return result;
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

    System.out.println(topView(root));
  }
}
