package sheetSolutions.string;

public class palindrome {
    static void palindromeChecking(String s){
        String j="";
        for (int i = s.length()-1; i >=0; i--) {
            j=j.concat(String.valueOf(s.charAt(i)));
        }
        System.out.println(s);
        System.out.println(j);
        if(j.equalsIgnoreCase(s)){
            System.out.println("Palindrome");
        }
        else
            System.out.println("Not palindrome");
    }

    public static void main(String[] args) {
        String s="Bam";
        palindromeChecking(s);
    }
}
