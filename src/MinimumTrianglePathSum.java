import java.util.Arrays;
import java.util.List;

public class MinimumTrianglePathSum {

	public static int minPath(int[][] nums) {
		int n = nums.length;
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {

				nums[i][j] += nums[i + 1][j] < nums[i + 1][j + 1] ? nums[i + 1][j] : nums[i + 1][j + 1];
			}
		}
		return nums[0][0];
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size() + 1;
		int[] A = new int[n];
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
			}
		}
		return A[0];
	}
	
    public int minimumTotal2(List<List<Integer>> triangle) {
        
        int len = triangle.size();
        int[] sums = new int[len];
        Arrays.fill(sums, Integer.MAX_VALUE);
        sums[0] = triangle.get(0).get(0);
        helper(triangle, 1, sums);
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.min(res, sums[i]);
        }
        return res;
    }
    private void helper(List<List<Integer>> triangle, int level, int[] sums) {
        if (level >= triangle.size()) {
            return;
        }
        for (int i = level; i >= 0; i--) {
            if (i == 0) {
                sums[i] = sums[0];
            } else {
                sums[i] = Math.min(sums[i], sums[i - 1]);
            }
            sums[i] += triangle.get(level).get(i);
        }
        helper(triangle, level + 1, sums);
    }
}

	public static void main(String[] args) {
		int[][] nums = new int[][] { { 6 }, { 3, 1 }, { 2, 1, 9 }, { 7, 2, 9, 1 } };
		int[][] nums2 = new int[][] { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
		int res = minPath(nums);
		System.out.println(res);
		System.out.println(minPath(nums2));
	}
}
