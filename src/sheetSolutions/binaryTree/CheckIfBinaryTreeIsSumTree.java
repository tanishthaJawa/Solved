package sheetSolutions.binaryTree;

public class CheckIfBinaryTreeIsSumTree {
    public static boolean isSumTree(Node root) {
        // Base case: empty tree or leaf node
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        // Check if the left and right subtrees are Sum Trees
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        return root.data == leftSum + rightSum && isSumTree(root.left) && isSumTree(root.right);
    }

    private static int getSum(Node node) {
        // Base case: empty tree or leaf node
        if (node == null) {
            return 0;
        }
        // Compute the sum of the subtree
        if (node.left == null && node.right == null) {
            return node.data;
        } else {
            int leftSum = getSum(node.left);
            int rightSum = getSum(node.right);
            if (node.data == leftSum + rightSum) {
                // sum of left subtree and right subtree will be sum of all leaf nodes and curr root node, thus 2*curr node
                return 2 * node.data;
            } else {
                // If the subtree is not a Sum Tree, return -infinity
                return Integer.MIN_VALUE;
            }
        }
    }

    public static void main(String[] args) {
         /* Construct the following tree
                   3
                 /   \
                /     \
               2       1

         */
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(1);
        System.out.println( isSumTree(root));

    }
}
