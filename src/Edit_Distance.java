
public class Edit_Distance {

	public int minDistance(String word1, String word2) {

		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++) {
			dp[i][0] = i;
		} 
		for (int i = 0; i < n + 1; i++) {
			dp[0][i] = i;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (word1.charAt(i) == word2.charAt(j))
					dp[i + 1][j + 1] = dp[i][j];
				else {
					int a = dp[i][j];
					int b = dp[i][j + 1];
					int c = dp[i + 1][j];
					dp[i + 1][j + 1] = 1 + Math.min(Math.min(a, b), c);
				}
			}
		}
		return dp[m][n];
	}
}
