import java.util.Arrays;

public class TrianglewSmallestPerimeter {

	public static int findTri(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < nums.length; j++) {
				while (k < nums.length) {
					if (nums[i] + nums[j] > nums[k])
						return nums[i] + nums[j] + nums[k];
					k++;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 10, 21, 22, 100, 101, 200, 300 };
		System.out.println(findTri(nums));
	}
}
