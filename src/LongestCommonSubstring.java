
public class LongestCommonSubstring {
	
	public static int LCString (String A, String B) {
		int m = A.length();
		int n = B.length();
		System.out.println(m);
		System.out.println(n);
		int[][] dp = new int[m + 1][n + 1];
		int len = 0;
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) dp[i][j] = 0;
				else {
					if (A.charAt(i - 1) == B.charAt(j - 1)) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
						len = Math.max(len, dp[i][j]);
					}
				}
			}
		}
		return len;
	}
	
	public static void main (String[] args) {
		String A = "GeeksforGeeks";
		String B = "GeeksQuiz";
		
		int res = LCString(A, B);
		System.out.println(res);
	}
}
