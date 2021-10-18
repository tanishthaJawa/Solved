package sheetSolutions.binarySearchTree;

public class minimumElementInBST {
    static int minValue(Node node) {
        if (node == null)
            return -1;
        while (node.left != null)
            node = node.left;
        return node.data;
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
        System.out.println(minValue(root1));
    }
}
