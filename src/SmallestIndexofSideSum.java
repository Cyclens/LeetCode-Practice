
public class SmallestIndexofSideSum {

	public static int sameSum(int[] nums) {
		if (nums.length == 1) return 0;
		if (nums.length == 0) return -1;
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		int left = 0;
		for (int i = 0; i < nums.length; i++) {
			int right = sum - left - nums[i];
			if (left == right) return i;
			left += nums[i];
		}
		return -1;
	}
	
	public static void main (String[] args) {
		int[] nums = new int[] {1, 0};
		System.out.println(sameSum(nums));
	}
}
