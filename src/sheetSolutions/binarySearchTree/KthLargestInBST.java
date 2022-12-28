package sheetSolutions.binarySearchTree;

/*
The idea is to do reverse inorder traversal of BST. The reverse inorder traversal traverses all nodes in decreasing order. While doing the
traversal, we keep track of count of nodes visited so far. When the count becomes equal to k, we stop the traversal and print the key.
 */

public class KthLargestInBST {
    static class Count {
        int count = 0;
        int largest;
    }

    public int kthLargest(Node root, int K) {
        //Your code here
        Count c = new Count();
        kthLargestUtil(root, c, K);
        return c.largest;

    }

    private void kthLargestUtil(Node root, Count c, int k) {
        if (root == null || c.count >= k) {
            return;
        }
        kthLargestUtil(root.right, c, k);

        c.count++;

        if (c.count == k) {
            c.largest = root.data;
            return;
        }

        kthLargestUtil(root.left, c, k);

    }

    public static void main(String[] args) {

       /* Construct the following tree
                   4
                 /   \
                /     \
               2       9

        */
        KthLargestInBST tree = new KthLargestInBST();

        Node root1 = new Node(4);
        root1.left = new Node(2);
        root1.right = new Node(9);

        System.out.println(tree.kthLargest(root1,2 ));
    }
}
