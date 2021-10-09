package sheetSolutions.binaryTree;
//The program aims to find the height of a tree. Height of empty tree is 0
public class heightOfTree {
    static int height(Node node){
        if(node==null)
            return 0;
        int left=height(node.left);// calculates for left tree. leaf node would have 0 height
        int right= height(node.right);
        return Math.max(left,right)+1;
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
        System.out.println(height(root));
    }


}
