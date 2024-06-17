package Practice;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    public static List<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<>();


        if (digits.length() < 1) return list;

        String values[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder comb = new StringBuilder("");
        LetterCombination.combinations(digits, comb, list, values, 0);

        return list;
    }

    public static void combinations(String digits, StringBuilder comb, ArrayList<String> list, String[] values, int index) {

        if (index > digits.length()) return;

        if (comb.length() == digits.length()) {
            list.add(comb.toString());
            return;
        }

        int digit = Character.getNumericValue(digits.charAt(index));
        String currentStr = values[digit];

        for (char c : currentStr.toCharArray()) {
            combinations(digits, new StringBuilder(comb).append(c), list, values, index + 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = LetterCombination.letterCombinations("23");
        System.out.println(list.toString());

    }

}
