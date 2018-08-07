import java.util.Arrays;
import java.util.Collections;

public class SortColors {
	// public void sortColors(int[] nums) {
	// int zeros = 0, ones = 0, twos = 0;
	// for (int i = 0; i < nums.length; i++) {
	// if (nums[i] == 0)
	// zeros++;
	// if (nums[i] == 1)
	// ones++;
	// if (nums[i] == 2)
	// twos++;
	// }
	// int cur0 = 0, cur1 = 0, cur2 = 0;
	//
	// for (int i = 0; i < nums.length; i++) {
	// System.out.println(Arrays.toString(nums));
	// if (nums[i] == 0) {
	// int temp = nums[cur0];
	// nums[cur0] = nums[i];
	// nums[i] = temp;
	// cur0++;
	// }
	//
	// }
	// for (int i = zeros; i < nums.length; i++) {
	// if (nums[i] == 1) {
	// // System.out.println(cur1 + zeros);
	// int temp = nums[cur1 + zeros];
	// nums[cur1 + zeros] = nums[i];
	// nums[i] = temp;
	// cur1++;
	// }
	// }
	//
	// }
	public void sortColors(int[] nums) {
		int p1 = 0, p2 = nums.length - 1, index = 0;
		while (index <= p2) {

			System.out.println(Arrays.toString(nums));
			if (nums[index] == 0) {
				nums[index] = nums[p1];
				nums[p1] = 0;
				p1++;
			}
			if (nums[index] == 2) {
				nums[index] = nums[p2];
				nums[p2] = 2;
				p2--;
				index--;
			}
			index++;
			System.out.println(Arrays.toString(nums) + "111");
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1,2,0 };
		new SortColors().sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
}
