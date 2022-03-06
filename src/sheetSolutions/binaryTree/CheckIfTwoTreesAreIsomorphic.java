package sheetSolutions.binaryTree;
/*Given two Binary Trees. Check whether they are Isomorphic or not.

    Note:
    Two trees are called isomorphic if one can be obtained from another by a series of flips, i.e. by swapping left and right
    children of several nodes. Any number of nodes at any level can have their children swapped. Two empty trees are isomorphic.
 Trees are isomorphic if their children and children are exchanged(kind of).
        Input:
 T1    1     T2:   1
     /   \        /  \
    2     3      3    2
   /            /
  4            4
Output: No

Example 2:

Input:
T1    1     T2:    1
    /  \         /   \
   2    3       3     2
  /                    \
  4                     4
Output: Yes

 */
public class CheckIfTwoTreesAreIsomorphic {
  static boolean isIsomorphic(Node root1, Node root2) {
    // Both roots are NULL, trees isomorphic
    if (root1 == null && root2 == null) return true;
    // Exactly one of the root1 and root2 is NULL, trees not isomorphic
    if (root1 == null || root2 == null) return false;
    // if nodes data are different , trees are not isomorphic
    if (root1.data != root2.data) return false;
    // There are two possible cases for n1 and n2 to be isomorphic
    // Case 1: The subtrees rooted at these nodes have NOT been
    // "Flipped".
    // Both of these subtrees have to be isomorphic.
    // Case 2: The subtrees rooted at these nodes have been "Flipped"
    return (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right))
        || (isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left));
  }

  public static void main(String[] args) {

    // Let us create trees shown in above diagram
    Node root1 = new Node(1);
    root1.left = new Node(2);
    root1.right = new Node(3);
    root1.left.left = new Node(4);
    root1.left.right = new Node(5);
    root1.right.left = new Node(6);
    root1.left.right.left = new Node(7);
    root1.left.right.right = new Node(8);

    Node root2 = new Node(1);
    root2.left = new Node(3);
    root2.right = new Node(2);
    root2.right.left = new Node(4);
    root2.right.right = new Node(5);
    root2.left.right = new Node(6);
    root2.right.right.left = new Node(8);
    root2.right.right.right = new Node(7);

    if (isIsomorphic(root1, root2)) System.out.println("Yes");
    else System.out.println("No");
  }
}
