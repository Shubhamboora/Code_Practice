package Practice;

public class KMPAlgorithm {

    public static void FindPattern(String content, String pattern) {
        int[] lps = new int[pattern.length()];
        int i = 0, j = 0;

        FormLps(lps, pattern);

        while (i < content.length()) {
            if (content.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                if (j == pattern.length()) {
                    System.out.println("Pattern found at index " + (i - j));
                    j = lps[j - 1];
                }
            } else {
                if (i < content.length() && content.charAt(i) != pattern.charAt(j)) {
                    if (j > 0)
                        j = lps[j - 1];
                    else
                        i++;
                }
            }
        }
    }

    public static void FormLps(int lps[], String pattern) {
        int i = 0, j = i + 1;
        lps[0] = 0;

        while (j < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                i += 1;
                lps[j] = i;
                j += 1;
            } else {
                if (i > 0) {
                    i = lps[i - 1];
                } else {
                    lps[j++] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        String str = "ababbbabbabaababab";
        String search = "abab";
//		String str = "abab";
//		String search = "abab";
        KMPAlgorithm.FindPattern(str, search);

    }

}
