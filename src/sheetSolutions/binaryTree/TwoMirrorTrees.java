package sheetSolutions.binaryTree;

import java.util.Stack;

public class TwoMirrorTrees {
    static boolean areMirror(Node a, Node b) {
        // Your code here
        if (a == null && b == null) { // Base condition
            return true;
        }
        if (a == null || b == null) { // one of the node is null
            return false;
        }

        return a.data == b.data && areMirror(a.left, b.right) && areMirror(a.right, b.left);
    }

    /*
    Approach:

    The following steps are:

    1.Perform iterative inorder traversal of one tree and iterative reverse inorder traversal of the other tree in parallel.
    2.During these two iterative traversals check that the corresponding nodes have the same value or not.
      If not same then they are not mirrors of each other.
    3. If values are same, then check whether at any point in the iterative inorder traversal one of the root becomes null and the other is not null.
       If this happens then they are not mirrors of each other. This check ensures whether they have the corresponding mirror structures or not.
    4.Otherwise, both the trees are mirror of each other.
     */
    static boolean areMirrorIterative(Node root1, Node root2) {
        Stack<Node> st = new Stack<>();
        Stack<Node> st1 = new Stack<>();

        while (true) {

            // iterative inorder traversal of 1st tree and
            // reverse inorder traversal of 2nd tree

            while (root1 != null && root2 != null) {

                if (root1.data != root2.data) {
                    return false;
                }

                st.push(root1);
                st1.push(root2);
                root1 = root1.left;
                root2 = root2.right;
            }
           // if at any point one root becomes null and
            // the other root is not null, then they are
            // not mirrors. This condition verifies that
            // structures of tree are mirrors of each other.
            if (!(root1 == null && root2 == null)) {
                return false;
            }

            if (!st.isEmpty() && !st1.isEmpty()) {
                root1 = st.peek();
                root2 = st1.peek();

                st.pop();
                st1.pop();

                 /* we have visited the node and its left subtree.
                 Now, it's right subtree's turn */
                root1 = root1.right;

                root2 = root2.left;
            } else {
                // both the trees have been completely traversed
                break;
            }

        }
               // trees are mirrors of each other
        return true;

    }

    public static void main(String[] args) {

        Node root1 = new Node(1);         /*         1         */
        root1.left = new Node(3);         /*        / \     */
        root1.right = new Node(2);         /*      3   2     */
        root1.right.left = new Node(5);     /*         / \     */
        root1.right.right = new Node(4); /*            5  4 */

        // 2nd binary tree formation
        Node root2 = new Node(1);         /*         1         */
        root2.left = new Node(2);         /*        / \     */
        root2.right = new Node(3);         /*      2   3     */
        root2.left.left = new Node(4);     /*     / \         */
        root2.left.right = new Node(5);     /*   4   5         */

        System.out.println(areMirrorIterative(root1, root2));
        System.out.println(areMirror(root1, root2));
    }
}
