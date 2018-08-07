import java.util.Arrays;

public class moveZeroes {
	public static int[] movezeros(int[] nums) {
		int i = 0;
		for (int num : nums) {
			if (num !=  0) nums[i++] = num;
		}
		while (i < nums.length ) {
			nums[i++] = 0;
		}
		return nums;
		
	}
	
	public static void main(String[] args) {
		int[] nums = {1,0,2,0};
		int[] l = new int[4];
		l = movezeros(nums);
		String ll = Arrays.toString(l);
		//System.out.println(ll);
		
		int[] a = {1,2,0,3,0,4};
		String as = Arrays.toString(a);
		System.out.println(as);
	}
}
