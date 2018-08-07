package Google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Longest_Consecutive_Sequence {

	public int longestConsecutive(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 0;
		for (int num : nums) {
			if (!map.containsKey(num)) {
				int left = map.containsKey(num - 1)? map.get(num - 1) : 0;
				int right = map.containsKey(num + 1)? map.get(num + 1) : 0;
				int sum = left + right + 1;
				map.put(num, sum);
				map.put(num - left, sum);
				map.put(num + right, sum);
				max = Math.max(max, sum);
			}
		}
		return max;
	}
	
	public int lCSorted(int[] nums) {
		Arrays.sort(nums);
		int max = 1;
		int count = 1;
		for (int i = 0; i < nums.length; i++) {
			while (nums[i + 1] == nums[i]) {
				i += 1;
				if (i == nums.length - 1) break;
			}
			if (i == nums.length - 1) break;
			
			if (nums[i + 1] == nums[i] + 1) {
				count++;
				max = Math.max(max, count);
			}
			else {
				count = 1;
			}
		}
		return max;
	}
}
