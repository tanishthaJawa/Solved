package sheetSolutions.stackNQueues;

import java.util.Stack;

/*
This program aims to evaluate a postfix operation
 */
public class evaluationOfPostfixOperation {
    public static int evaluatePostFix(String S)
    {
       /*
       time complexity:O(n)
       While reading the expression from left to right, push the element in the stack if it is an operand.
       Pop the two operands from the stack, if the element is an operator and then evaluate it. Push back the
       result of the evaluation. Repeat it till the end of the expression.
        */
        Stack<Integer> hs= new Stack<>();
        for(int i=0;i<S.length();i++){
            char ch=S.charAt(i);
            if(Character.isDigit(ch)){
                hs.push(ch-'0');
            }
            else{
                int num1,num2,ans=0;
               num1=hs.pop();
               num2=hs.pop();
               switch(ch){
                   case'+':ans=num2+num1;
                   break;
                   case'-':ans=num2-num1;
                       break;
                   case'*':ans=num2*num1;
                       break;
                   case'/':ans=num2/num1;
                       break;
                   case'%':ans=num2%num1;
                       break;
                   default:
                   break;
               }
              hs.push(ans);
            }
        }
        return hs.pop();
    }
}
