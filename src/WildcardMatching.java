
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		int m = s.length(), n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for (int i = 1; i < m + 1; i++) {
			dp[i][0] = false;
		}
		for (int j = 1; j < n + 1; j++) {
			if (p.charAt(j - 1) == '*') dp[0][j] = true;
			else break;
		}
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if(p.charAt(j - 1) != '*') {
					dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
				}
				else
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
			}
		}
		return dp[m][n];
	}
	
	public static void main (String[] args) {
		String s = "acdcb";
		String p = "a*c?b";
		boolean match = new WildcardMatching().isMatch(s, p);
		System.out.println(match);
	}
}
