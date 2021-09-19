package sheetSolutions.string;

public class countAndSay {
    static String countAndSayMeth(int n){
        if(n==1)
            return"1";
        String str=countAndSayMeth(n-1);
        return parseIt(str);
    }
   static String parseIt(String str){
       //this function should do this
       // input : 1 , output : 11  (1 times 1)
       //input  : 11 , output : 21 (2 times 1)
       //input : 21 , output : 1211 (1 times 2 and 1 times 1)
       //input : 1211 ,output : 111221 ( 1 times 1,1 times 2,2 times 1)
       String parsed="";
       int freq=1;

       int num = str.charAt(0)-'0';
       for (int i = 1; i < str.length(); i++) {
           if(str.charAt(i)==str.charAt(i-1)){
               freq++;
           }
           else{
               //before changing the data record old data in parsed
               //ex 111->31
               parsed+= freq+String.valueOf(num);
               freq=1;//for this newly found digit
               num=str.charAt(i)-'0';
           }
       }
       parsed+= freq +String.valueOf(num);//if a string contains 111 or 1 then else portion would never run thus we can
       return parsed;                      //concatenate string like this.

   }

    public static void main(String[] args) {
        System.out.println(countAndSayMeth(4));
    }
}
