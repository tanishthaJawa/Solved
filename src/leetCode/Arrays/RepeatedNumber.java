package leetCode.Arrays;

import java.util.List;

public class RepeatedNumber {
    public static int repeated(int[] a) {
        // Write your code here
        int rep=0;
        for(int i:a){
            rep = rep ^ i; // x xor x =0 and x xor 0=0. So in case of 2n elements the repeated would be returned as it is.
        }
        return rep;
    }

  public static void main(String[] args) {
    //
      int [] a= {1,2,3,4,3,2,1};
    System.out.println(repeated(a));
  }
}
