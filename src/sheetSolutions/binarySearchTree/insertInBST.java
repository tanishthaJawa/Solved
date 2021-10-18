package sheetSolutions.binarySearchTree;
// This program aims to insert a node in binary search tree. The node is always inserted at the leaf node.
public class insertInBST {
    static Node insert(Node root,int key){
        if(root==null){
            root=new Node(key);
            return root;
        }

        if(root.data<key)// if given value is greater than root value
            root.right=insert(root.right,key);
        else
            root.left= insert(root.left,key);
        return root;
    }
    static void inOrder(Node root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data +" ");
        inOrder(root.right);
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
        Node root1= new Node(3);
        root1.left = new Node(2);
        root1.right = new Node(7);
        root1.left.left = new Node(1);
        root1.right.left = new Node(5);
        root1.right.right = new Node(9);
        root1.right.left.left = new Node(4);
        root1.right.left.right = new Node(6);
        inOrder(root1);
        System.out.println();
      inOrder(insert(root1,11));
    }
}
