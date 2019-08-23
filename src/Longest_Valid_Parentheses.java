
public class Longest_Valid_Parentheses {
	
	public int longestValidParentheses(String s) {

		char[] ch = s.toCharArray();
		int[] dp = new int[s.length()];
		int open = 0, max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (ch[i] == '(') open++;
			if (ch[i] == ')' && open > 0) {
				dp[i] = dp[i - 1] + 2;
				if (i - dp[i] > 0) {
					dp[i] += dp[i - dp[i]];
				}
				open--;
			}
			max = Math.max(max, dp[i]);
			
		}
		return max;
	}
}
