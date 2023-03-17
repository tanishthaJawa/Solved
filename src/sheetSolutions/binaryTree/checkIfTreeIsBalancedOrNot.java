package sheetSolutions.binaryTree;

public class checkIfTreeIsBalancedOrNot {
    static class Height {
        int height;
    }

    static boolean isBalanced(Node root, Height h) {
        // Your code here
        Height lh = new Height();// height of left and right nodes
        Height rh = new Height();
        if (root == null) {
            h.height = 0;// height is 0
            return true;// the tree is balanced
        }
        boolean l = isBalanced(root.left, lh);// maintains check for children
        boolean r = isBalanced(root.right, rh);
        int leftHeight = lh.height, rightHeight = rh.height;
       /* Height of current node is max of heights of
           left and right subtrees plus 1*/
        h.height = Math.max(leftHeight, rightHeight) + 1;// height of tree
       /*
       if the heights are less than or equal to 1 and left and right sub-trees are balanced return true or false
        */
        return (Math.abs(leftHeight - rightHeight) <= 1) && l && r;
    }

    //Approach 2
    public boolean isBalanced1(Node root) {
        if (root == null) {
            return true;
        }
        return height(root) != -1;
    }

    private int height(Node root) {
        if (root == null) return 0;
        // Height of left subtree...
        int leftHeight = height(root.left);
        // Height of height subtree...
        int rightHeight = height(root.right);
        // In case of left subtree or right subtree unbalanced, return -1...
        if (leftHeight == -1 || rightHeight == -1) return -1;
        // If their heights differ by more than ‘1’, return -1...
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        // Otherwise, return the height of this subtree as max(leftHeight, rightHight) + 1...
        return Math.max(leftHeight, rightHeight) + 1;
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
        root.right.left.right.right = new Node(9);
        Height height = new Height();
        System.out.println(isBalanced(root, height));
    }


}



