package Google;

public class Range_Sum_Query_2D {

	int[][] dp;

	public Range_Sum_Query_2D(int[][] matrix) {

		if (matrix.length == 0 || matrix[0].length == 0)
			return;
		int m = matrix.length;
		int n = matrix[0].length;
		dp = new int[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
			}
		}

	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return dp[row1][col1] + dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1];
	}
	
}
