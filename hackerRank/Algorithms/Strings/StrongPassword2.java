package hackerRank.Algorithms.Strings;

import java.io.*;
public class StrongPassword2 {
    public static int minimumNumber(int n, String password){
        int min=0;
        int length=6;
        boolean hasNumber=false;
        boolean hasUpperCharacter=false;
        boolean hasLowerCharacter=false;
        boolean hasSpecialCharacter=false;
        for(int i=0;i<password.length();i++){
            char c=password.charAt(i);
            hasUpperCharacter=Character.isUpperCase(c)||hasUpperCharacter;
            hasLowerCharacter=Character.isLowerCase(c)||hasLowerCharacter;
            hasNumber=Character.isDigit(c)||hasNumber;
            hasSpecialCharacter="!@#$%^&*()-+".contains
                    (String.valueOf(c))||hasSpecialCharacter;

        }
        if(!hasUpperCharacter)
            min++;
        if(!hasLowerCharacter)
            min++;
        if(!hasNumber)
            min++;
        if(!hasSpecialCharacter)
            min++;
        return Math.max(min,length-n);

    }
}

class Strong2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = StrongPassword2.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}



