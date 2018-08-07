package Google;

public class Matrix_Traversal {

	public static int getWays(int n, int m) {
		int[][] dp = new int[n][m];
		dp[0][0] = 1;
		for (int j = 1; j < m; j++) {
			for (int i = 0; i < n; i++) {
				if (i == n - 1) {
					dp[i][j] += dp[i][j - 1] + dp[i - 1][j - 1];
				}
				else if (i == 0) {
					dp[i][j] += dp[i][j - 1] + dp[i + 1][j - 1];
				}
				else {
					dp[i][j] += dp[i][j - 1] + dp[i - 1][j - 1] + dp[i + 1][j - 1];
				}
			}
		}
		return dp[n - 1][m - 1];
	}

	public static void main(String[] args) {

		int n = 4;
		int m = 5;
		System.out.println(getWays(n, m));
	}
}
