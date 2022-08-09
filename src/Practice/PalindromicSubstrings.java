package Practice;

public class PalindromicSubstrings {

	public static void main(String[] args) {
		String s = "aaa";
		int n = s.length(), count=0;
		boolean[][] dp = new boolean[n][n];
		
		for(int gap = 0;gap < n; gap++) {
			for(int i=0, j = gap; i < n && j < n; i++, j++) {
				if(gap == 0) {
					dp[i][j] = true;
				}else if(gap == 1) {
					dp[i][j] = s.charAt(i) == s.charAt(j);
				}else {
					if(s.charAt(i) == s.charAt(j)) {
						dp[i][j] = dp[i+1][j-1];
					}
				}
				count += dp[i][j]?1:0;
			}
		}
		
		System.out.println(count);
	}

}
