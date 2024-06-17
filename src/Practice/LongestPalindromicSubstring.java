package Practice;

import java.util.Objects;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(LongestPalindromicSubstring.longestPalindrome("s"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 0) return "You fucked up.";
        int low, high, len = 1, index = 0, start = 0;
        while (index < s.length()) {
            low = index - 1;
            high = index + 1;

            //check for same alphabets on left side
            while (low >= 0 && s.charAt(low) == s.charAt(index)) low--;

            //check for same alphabets on right side
            while (high < s.length() && s.charAt(high) == s.charAt(index)) high++;

            //ittrating until left and right alphabets are same
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }

            int size = high - low - 1;
            if (size > len) {
                len = size;
                start = low + 1;
            }
            index++;
        }
        System.out.println("len = " + len);
        return s.substring(start, start + len);
    }
}
