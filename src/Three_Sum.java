import java.util.*;

public class Three_Sum {

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		//System.out.println(Arrays.toString(nums));
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int l = i + 1;
			int r = nums.length - 1;
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				//System.out.println(Arrays.asList(nums[i], nums[l], nums[r]).toString());
				if (sum > 0) {
					r--;
				}else if (sum < 0) {
					l++;
					
				}else {
					res.add(Arrays.asList(nums[i], nums[l], nums[r]));
					while (l < r && nums[l + 1] == nums[l]) l++;
					while (l < r && nums[r - 1] == nums[r]) r--;
					l++;
					r--;
				}
			}
		}
		return res;
	}
	
	public static void main (String[] args) {
		int[] nums = {1,-1,-1,0};
		System.out.println(threeSum(nums).toString());
	}
}
