import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null)
			return list;

		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> tempLevel = new ArrayList<Integer>();
			int numNodes = queue.size();
			for (int i = 0; i < numNodes; i++) {

			}
		}
	}
}
