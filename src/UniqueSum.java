import java.util.HashSet;
import java.util.Set;

public class UniqueSum {
	public static int uniqueSum (int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		int res = 0;
		for (int num : nums) {
			if (set.contains(num)) res++;
			else {
				set.add(num);
				res += num;
			}
		}
		return res;
	}
}
