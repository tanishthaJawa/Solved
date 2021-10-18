package sheetSolutions.binarySearchTree;
//This program aims to search and insert a value in a tree
public class searchInBST {
    // time complexity :O(logN)
    static int search(Node root, int key){
        if(root==null)
            return -1;
        if( root.data==key){
            return root.data;
        }
        else if(root.data>key){
            return search(root.left,key);
        }
        else
         return search(root.right,key);

    }
    static int search1(Node root, int key){
        while (root!=null){
            if(root.data==key)
                return root.data;
            else if(root.data>key){
                root=root.left;
            }
            else
                root=root.right;
        }
        return -1 ;
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
        System.out.println(search(root1,8));
        System.out.println(search1(root1,8));
    }
}
