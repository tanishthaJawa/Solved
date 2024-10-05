/*
You are given a histogram represented by an array hist[] of size n, where each element of the array denotes the height of the bars in the histogram. All bars have the same width of 1 unit.

Your task is to find the largest rectangular area possible in the given histogram, where the rectangle can be formed using a number of contiguous bars.

Example 1:

Input: 
n = 7
hist[] = [6, 2, 5, 4, 5, 1, 6]

The idea is to find the indexes of nearest samllest to right and left.
The width is nsr- nsl -1 and the height is of current bar.
Find the max in areas;

TC: o(n)
SC:)(n)
*/
class Solution {
    // Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[]) {
        // your code here
        if(hist.length== 0 || hist.length ==1){
            return 0;
        }
        
        long [] indexOfNsl = nearestSmallerToLeft(hist);
        long [] indexOfNsr = nearestSmallerToRight(hist);
        long [] width = new long[hist.length];
        long[] area = new long[hist.length];
        long maxArea = 0;
        
        for(int i =0; i<hist.length; i++){
            //System.out.println("nsr"+ indexOfNsr[i] );
            //System.out.println("nsl"+ indexOfNsl[i] );

            width[i] =  indexOfNsr[i] - indexOfNsl[i] -1;
            //System.out.println(width[i]);
        }
        
        for(int i =0 ;i< hist.length ;i++){
            area[i] = width[i] * hist[i];
            maxArea = Math.max(maxArea, area[i]);
        }
        
        return maxArea;
       
    }
    
    public static long[] nearestSmallerToLeft(long[] hist){
        long[] res = new long[hist.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i<hist.length; i++){
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
    
    public static long[] nearestSmallerToRight(long[] hist){
        long[] res = new long[hist.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i = hist.length-1; i>=0; i--){
            while(!st.isEmpty() && hist[st.peek()] >= hist[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                res[i] = hist.length;
            }
            else{
                res[i] = st.peek(); 
            }
            
            st.push(i);
        }
        
        return res;
    }
}
