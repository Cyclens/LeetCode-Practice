import java.util.ArrayList;
import java.util.List;

public class PathSumII {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		helper(root, sum, res, path);
		return res;
	}

	private void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
		// TODO Auto-generated method stub
		if (root == null) return;
		path.add(new Integer(root.val));
		if (root.left == null && root.right == null && root.val - sum == 0)
			res.add(new ArrayList<>(path));
		else {
			helper(root.left, sum - root.val, res, path);
			helper(root.right, sum - root.val, res, path);
		}
		path.remove(path.size() - 1);
	}
}
