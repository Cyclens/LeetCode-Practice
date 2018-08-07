package Google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class nextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums.length <= 1)
			return;
		int i;
		for (i = nums.length - 1; i > 0; i--) {
			if (nums[i - 1] < nums[i])
				break;
		}
		if (i == 0) {
			reverse(nums, 0, nums.length - 1);
			return;
		} else {
			int x = nums[i - 1];
			int j;
			for (j = nums.length - 1; j >= i - 1; j--) {
				if (nums[j] > x)
					break;
			}
			swap(nums, i - 1, j);
			reverse(nums, i, nums.length - 1);
			return;
		}
	}

	public void swap(int[] nums, int l, int r) {
		int temp = nums[r];
		nums[r] = nums[l];
		nums[l] = temp;
	}

	public void reverse(int[] nums, int l, int r) {
		if (l > r) return;
		for (int i = l; i <= (l + r) / 2; i++) {
			swap(nums, i, l + r - i);
		}
	}

	public static void main(String[] args) {
		int[] nums = {1,3,2};

		new nextPermutation().nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}
