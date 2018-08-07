import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidTriangleFromList {

	public List<List<Integer>> vlidTriangle(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < nums.length - 1; j++) {
				while (k < nums.length && nums[i] + nums[j] > nums[k]) {
					if (k > j) {
						List<Integer> curr = new ArrayList<Integer>();
						curr.add(nums[i]);
						curr.add(nums[j]);
						curr.add(nums[k]);
						res.add(curr);
					}
					++k;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 21, 22, 100, 101, 200, 300 };
		System.out.println(new ValidTriangleFromList().vlidTriangle(arr).toString());
	}
}
