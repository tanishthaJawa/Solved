package sheetSolutions.binarySearchTree;

public class LowestCommonAncestor {
  public static Node lca(Node root, int v1, int v2) {
    if (root == null) return null;
    if (v1 < root.data && v2 < root.data) { // if v1 and v2 values are less than root lca is in left
      return lca(root.left, v1, v2);
    } else if (v1 > root.data
        && v2 > root.data) { // if v1 and v2 values are more than root lca is in right
      return lca(root.right, v1, v2);
    }
    return root; // else root is answer
  }

  public static Node lcaIteartive(Node root, int v1, int v2) {
    if (root == null) return null;
    while (root != null) {
      if (v1 < root.data
          && v2 < root.data) { // if v1 and v2 values are less than root lca is in left
        root = root.left;
      } else if (v1 > root.data
          && v2 > root.data) { // if v1 and v2 values are more than root lca is in right
        root = root.right;
      } else break;
    }
    return root; // else root is answer
  }

  public static void main(String[] args) {
    /* Construct the following tree
               3
             /   \
            /     \
           2       7
          /      /   \
         /      /     \
        1      5       9
              / \
             /   \
            4    6
    */
    Node root1 = new Node(3);
    root1.left = new Node(2);
    root1.right = new Node(7);
    root1.left.left = new Node(1);
    root1.right.left = new Node(5);
    root1.right.right = new Node(9);
    root1.right.left.left = new Node(4);
    root1.right.left.right = new Node(6);
    System.out.println(lca(root1, 1, 5).data);
    System.out.println(lcaIteartive(root1, 1, 5).data);
  }
}
