package Google;

public class Find_Target_Sum_Ways {

	public static int targetSum(int[] nums, int S) {
		int sum = 0;
		for (int num : nums)
			sum += num;
		if (sum < S || (sum + S) % 2 != 0)
			return 0;
		int[] dp = new int[(sum + S) / 2 + 1];
		dp[0] = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = (sum + S) / 2; j >= nums[i]; j--) {
				dp[j] += dp[j - nums[i]];
			}
		}
		return dp[(sum + S) / 2];
	}

	public static void main(String[] args) {

		int[] nums = {1,1,1,1,1};
		int S = 3;
		System.out.println(targetSum(nums, S));
	}
}
