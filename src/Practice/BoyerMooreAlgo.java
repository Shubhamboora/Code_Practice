package Practice;

import java.util.Arrays;

public class BoyerMooreAlgo {
    public static void search(char text[], char[] pat) {

        int[] badChar = new int[256];
        BadCharacter(badChar, pat.length, pat);
        int s = 0;

        while (s <= text.length - pat.length) {
            int j = pat.length - 1;
            while (j >= 0 && pat[j] == text[s + j])
                j--;

            if (j < 0) {
                System.out.println("Pattern found at index: " + s);
                s += (s + pat.length < text.length) ? pat.length - badChar[text[s + pat.length]] : 1;
            } else {
                s += Math.max(1, j - badChar[text[s + j]]);
            }
        }
    }

    static void BadCharacter(int arr[], int n, char pat[]) {
        Arrays.fill(arr, -1);

        for (int i = 0; i < pat.length; i++) {
            arr[pat[i]] = i;
        }
    }

    public static void main(String[] args) {
        char txt[] = "AAAAABCAAACD".toCharArray();
        char pat[] = "AAA".toCharArray();
        search(txt, pat);

    }

}
