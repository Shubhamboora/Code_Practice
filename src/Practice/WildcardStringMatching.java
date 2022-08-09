package Practice;

public class WildcardStringMatching {
	
	static boolean match(String wild, String pattern) {
		int w = wild.length();
		int p = pattern.length();
		boolean[][] dp = new boolean[w+1][p+1];
		for(int i = w; i>=0; i--) {
			for(int j = p; j>=0; j--) {
				
				if(i == w && j == p) {
					dp[i][j] = true;
				}else if(i == w) {
					dp[i][j] = false;
				}else if(j == p) {
					if(wild.charAt(i)=='*') {
						dp[i][j] = dp[i+1][j];
					}else {
						dp[i][j] = false;
					}
				}else {
					if(wild.charAt(i) == '?') {
						dp[i][j] = dp[i+1][j+1];
					}else if(wild.charAt(i) == '*') {
						dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
					}else if(wild.charAt(i) == pattern.charAt(j)) {
						dp[i][j] = dp[i+1][j+1];
					}else{
						dp[i][j] = false;
					}
				}
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		String wild = "ge?ks*", pattern = "geeksforgeeks";
		System.out.println(match(wild, pattern));
		

	}

}
