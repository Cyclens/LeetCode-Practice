
public class Binary_Tree_Maximum_Path_Sum {
	
	int max;
	
	public int maxPathSum(TreeNode root) {
		max = Integer.MIN_VALUE;
		maxPathDown(root);
		return max;
	}

	private int maxPathDown(TreeNode node) {
		if (node == null) return 0;
		int left = Math.max(max, maxPathDown(node.left));
		int right = Math.max(max, maxPathDown(node.right));
		max = Math.max(max, left + right + node.val);
		return Math.max(left, right) + node.val;
		
	}
}
