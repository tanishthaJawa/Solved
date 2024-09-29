/*
Given three integers  'A' denoting the first term of an arithmetic sequence , 'C' denoting the common difference of an arithmetic sequence and an integer 'B'. you need to tell whether 'B' exists in the arithmetic sequence or not. Return 1 if B is present in the sequence. Otherwise, returns 0.

Example 1:

Input: A = 1, B = 3, C = 2
Output: 1
Explaination: 3 is the second term of the 
sequence starting with 1 and having a common 
difference 2.

TC : o(1)
SC : o(1)
*/
class Solution{
    static int inSequence(int A, int B, int C){
        // code here
        
        // formula : an = a +(n-1)d;
        // There can only be one element in such sequence and B will be equal to A
        if(C == 0){
            return B == A ? 1 :0;
        }
        long n = (B- A)/ C +1; // compute n
        
        // n should be a positive integer and should be completely divisible because a decimal number is not acceptable
        // suppose n is 2.5 the first condition is true but the second condition will evaluate to false which is correct.
       return n> 0 && (B- A) %C == 0 ? 1 : 0;
    }
}
