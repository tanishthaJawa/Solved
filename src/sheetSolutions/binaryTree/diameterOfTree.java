package sheetSolutions.binaryTree;
/*This program aims to find the diameter of a binary tree.The diameter of a tree (sometimes called the width)
 is the number of nodes on the longest path between two end nodes.
The diameter of a tree T is the largest of the following quantities:

The diameter of T’s left subtree.
The diameter of T’s right subtree.
The longest path between leaves that goes through the root of T
(this can be computed from the heights of the subtrees of T).
 */
public class diameterOfTree {
    static class Height{
        //Time complexity :O(n)
        // A utility class to pass height object
        int h;
    }
   static int diameter(Node root, Height ht){
      Height lh= new Height();
      Height rh= new Height();
      if(root==null){
          ht.h=0;// height is 0
          return 0;//diameter is 0
      }
      int lDiameter=diameter(root.left,lh);//compute left and right diameters
       int rDiameter=diameter(root.left,lh);
       ht.h=Math.max(lh.h, rh.h)+1;//get the height
       return 1+Math.max(lh.h+rh.h+1,Math.max(lDiameter,rDiameter));// find max between height and diameters
   }
    public static void main(String[] args)
    {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
       root.left.left.left=new Node(6);
        Height height=new Height();

        System.out.println(diameter(root,height));
    }


}

