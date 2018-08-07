
public class SameLeftandRightSum {
	
	public static int findLRsum (int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		int left = 0;
		int right = sum;
		for (int i = 0; i < nums.length; i++) {
			right -= nums[i];
			if (i > 0) left+= nums[i - 1];
			if (left == right) return i;
		}
		return -1;
	}
}
