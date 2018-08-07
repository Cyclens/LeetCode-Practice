
public class BinaryTreeLongestConsecutiveSequence {
	int count = 0;
	public int longestConsecutive(TreeNode root) {
		if (root == null) return 0;
		dfs(root, 0, root.val);
		return count;
	}
	
	public void dfs(TreeNode node, int curr, int target) {
		if (node == null) return;
		if (node.val == target) curr++;
		else curr = 1;
		count = Math.max(count, curr);
		dfs(node.left, curr, node.val + 1);
		dfs(node.right, curr, node.val + 1);
	}
}
