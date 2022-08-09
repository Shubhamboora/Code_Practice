package Practice;

public class PalindromicSubsequences {

	public static void main(String[] args) {
		String s = "abcd";
		int n = s.length(), count=0;
		
		int[][] dp = new int[n][n];
		
		for(int gap = 0;gap<n;gap++) {
			for(int i=0, j = gap;i<n && j<n;i++,j++) {
				if(gap ==0) {
					dp[i][j] = 1;
				}else if(gap == 1) {
					dp[i][j] = s.charAt(i) == s.charAt(j)?3:2;
				}else {
					if(s.charAt(i) == s.charAt(j)) {
						dp[i][j] = dp[i+1][j] + dp[i][j-1] + 1;
					}else {
						dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
					}
				}
			}
		}
		System.out.println(dp[0][n-1]);

	}

}
