package hackerRank.Algorithms.Strings;

public class CaesarCipher {
    public static String caesarCipher(String s, int k) {
        // Write your code here
        StringBuilder encryptedString = new StringBuilder();
        char t;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            encryptedString.append(encrypt(ch, k));
        }
        return encryptedString.toString();
    }

    private static char encrypt(char ch, int k) {
        if (!Character.isLetter(ch)) {
            return ch;
        }
        int base = Character.isLowerCase(ch) ? 'a' : 'A';
        return (char) ((ch + k - base) % 26 + base);
    }
}
