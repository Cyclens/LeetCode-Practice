import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidTriangleFromList {

	public List<List<Integer>> vlidTriangle(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < nums.length && nums[i] != 0; j++) {
				System.out.println(Arrays.toString(new int[] {i, j, k}));
				if (k == nums.length - 1) k--;
				while (k < nums.length && nums[i] + nums[j] > nums[k]) {
					if (k != j) {
						List<Integer> curr = new ArrayList<Integer>();
						curr.add(nums[i]);
						curr.add(nums[j]);
						curr.add(nums[k]);
						res.add(curr);
					}
					k++;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6};
		System.out.println(new ValidTriangleFromList().vlidTriangle(arr).toString());
	}
}
