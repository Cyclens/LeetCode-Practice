import java.util.HashSet;
import java.util.Set;

public class UniqueSum {
	
	public static int uniqueSum(int[] nums) {
		int sum = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.add(nums[i])) sum+= nums[i];
			else sum++;
		}
		return sum;
	}
	
	public static void main (String[] args) {
		int[] nums = new int[] {1,2,3,4,4,2,3,1};
		System.out.println(uniqueSum(nums));
	}
}
