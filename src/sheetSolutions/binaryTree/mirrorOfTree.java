package sheetSolutions.binaryTree;
// This program aims to find mirror image of binary tree
public class mirrorOfTree {

    static void inOrder(Node root){
        if (root == null)
            return ;
        inOrder(root.left);
        System.out.print(root.data +" ");
        inOrder(root.right);
    }
    static Node mirrorImage(Node root){
        if(root==null)
            return null;
        Node temp= new Node(root.data);
        temp.right=mirrorImage(root.left);
        temp.left=mirrorImage(root.right);
        return temp;// return root of new node
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
        inOrder(mirrorImage(root));
    }
}
