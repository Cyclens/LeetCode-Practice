import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Serialize_and_Deserialize_Binary_Tree {
	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		return serial(new StringBuilder(), root).toString();
	}

	private static StringBuilder serial(StringBuilder str, TreeNode root) {
		if (root == null)
			return str.append("null");
		str.append(root.val).append(",");
		serial(str, root.left).append(",");
		serial(str, root.right);
		return str;
	}

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		return deserial(new LinkedList<>(Arrays.asList(data.split(","))));
	}

	private static TreeNode deserial(Queue<String> q) {
		String val = q.poll();
		System.out.println(val+ "123");
		if ("null".equals(val))
			return null;
		System.out.println(val);
		TreeNode root = new TreeNode(Integer.valueOf(val));
		root.left = deserial(q);
		root.right = deserial(q);
		return root;
	}

	public static void main(String[] args) {
		String data = "1,2,3,null,null,4,5";
		TreeNode node = deserialize(data);
		String serializedNode = serialize(node);
		System.out.println(serializedNode);
	}
}
