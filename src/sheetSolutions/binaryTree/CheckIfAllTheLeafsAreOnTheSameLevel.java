package sheetSolutions.binaryTree;

public class CheckIfAllTheLeafsAreOnTheSameLevel {

    private int leafLevel = Integer.MIN_VALUE;

    public boolean isCheck(Node root) {
        return isCheckUtil(root, 0);
    }

    private boolean isCheckUtil(Node node, int level) {
        if (node == null) { //base case
            return true;
        }
        if (node.left == null && node.right == null) {
            if (leafLevel == Integer.MIN_VALUE) { // if this is the first leaf node encountered
                leafLevel = level;
                return true; // we can omit this line, but it makes the program run faster because it won't have to check next condition which will always return true;
            }
            return leafLevel == level; // check if all the leaf nodes are on the same level as the first node
        }
        return isCheckUtil(node.left, level + 1) && isCheckUtil(node.right, level + 1);
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

        CheckIfAllTheLeafsAreOnTheSameLevel check = new CheckIfAllTheLeafsAreOnTheSameLevel();
        System.out.println(check.isCheck(root));
    }
}
