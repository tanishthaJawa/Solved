/*  
https://www.geeksforgeeks.org/problems/max-rectangle/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

Given a binary matrix M of size n X m. Find the maximum area of a rectangle formed only of 1s in the given matrix.

Example 1:

Input:
n = 4, m = 4
M[][] = {{0 1 1 0},
         {1 1 1 1},
         {1 1 1 1},
         {1 1 0 0}}
Output: 8
Explanation: For the above test case the
matrix will look like
0 1 1 0
1 1 1 1
1 1 1 1
1 1 0 0
the max size rectangle is 
1 1 1 1
1 1 1 1
and area is 4 *2 = 8.

Approach:
1. Convert each 2D row into 1D array and compute max area of histogram for that array
2. return max areas of all arrays

*/


class Solution {
    public int maxArea(int M[][], int n, int m) {
        // add code here.
        int [] hist = M[0];
        int area = maxAreaOfAHistogram(hist, m);
        
        for(int i =1 ; i< n;i++){
            for(int j = 0 ; j<m; j++){
                if(M[i][j] == 0){
                    hist[j] = 0;
                }
                else{
                    hist[j] = M[i][j] +hist[j];
                }
            }
          area = Math.max(maxAreaOfAHistogram(hist, m), area);
        }
        
        return area;
    }
    
    public int maxAreaOfAHistogram(int [] arr, int len){
        if(arr.length== 0 || arr.length ==1){
            return 0;
        }
    
        int [] indexOfNsl = nearestSmallerToLeft(arr, len);
        int [] indexOfNsr = nearestSmallerToRight(arr, len);
        int [] width = new int[len];
        int[] area = new int[len];
        int maxArea = 0;
        
        for(int i =0; i<len; i++){
            width[i] =  indexOfNsr[i] - indexOfNsl[i] -1;
        }
        
        for(int i =0 ;i<len ;i++){
            area[i] = width[i] * arr[i];
            maxArea = Math.max(maxArea, area[i]);
        }
        
        return maxArea;
    }
    

   public int[] nearestSmallerToLeft(int[] hist , int len){
        int[] res = new int[len];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i<len; i++){
            while(!st.isEmpty() && hist[st.peek()] >= hist[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                res[i] = -1;
            }
            else{
                res[i] = st.peek(); 
            }
            
            st.push(i);
        }
        
        return res;
    }
    
   public int[] nearestSmallerToRight(int[] hist , int len){
        int[] res = new int[len];
        Stack<Integer> st = new Stack<>();
        
        for(int i = len-1; i>=0; i--){
            while(!st.isEmpty() && hist[st.peek()] >= hist[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                res[i] = len;
            }
            else{
                res[i] = st.peek(); 
            }
            
            st.push(i);
        }
        
        return res;
    }
}
