package Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Summary_Ranges {

	public List<String> summaryRanges(int[] nums) {
		int n = nums.length;
		List<String> res = new ArrayList<String>();
		if (n == 0) return res;
		for (int i = 0; i < n; i++) {
			int l = nums[i];
			while (i < n - 1 && nums[i + 1] == nums[i] + 1) {
				i++;
			}
			if (nums[i] == l) {
				res.add(l + "");
			}
			else {
				res.add(l + "->" + nums[i]);
			}
		}
		return res;
	}
	
	public static void main (String[] args ) {
		int[] nums = new int[] {0,1,2,4,5,7};
		System.out.println(new Summary_Ranges().summaryRanges(nums));
	}
}
