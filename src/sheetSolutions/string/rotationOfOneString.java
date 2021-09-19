package sheetSolutions.string;
/*
This program checks if one string is rotation of another
 */
public class rotationOfOneString {
/*
The idea is to concat two strings and check if second string is substring of first.
 */
    static void checkIfRotation(String s,String s1){
        String temp= s.concat(s);
        if(temp.contains(s1) && s.length()==s1.length()){
            System.out.println("rotation");
        }
        else{
            System.out.println("Not rotation");
        }
    }

    public static void main(String[] args) {
        String x="ABCD";
        String s1="CDABE";
        checkIfRotation(x,s1);
    }
}
