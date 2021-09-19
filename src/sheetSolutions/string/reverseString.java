package sheetSolutions.string;

public class reverseString {
        static void reverseString1(char[] s) {
            char temp;
            int low=0,high=s.length-1;
            while(low<=high){
                temp=s[low];
                s[low]=s[high];
                s[high]=temp;
                low++;
                high--;
            }

    }

    public static void main(String[] args) {
        char[]s={'h','e','l','l','o'};
        System.out.println(s);
        reverseString1(s);
        System.out.println(s);
    }
}

