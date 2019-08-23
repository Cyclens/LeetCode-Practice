import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Serialize_and_Deserialize_Binary_Tree {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {

		return serial(new StringBuilder(), root).toString();
	}

	private StringBuilder serial(StringBuilder sb, TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return sb.append("null").append(",");
		else {
			sb.append(root.val).append(",");
			serial(sb, root.left);
			serial(sb, root.right);
		}
		return sb;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {

		return deserial(new LinkedList<>(Arrays.asList(data.split(","))));
	}

	private TreeNode deserial(Queue<String> queue) {
		// TODO Auto-generated method stub
		String val = queue.poll();
		if (val.equals("null"))
			return null;
		else {
			TreeNode root = new TreeNode(Integer.valueOf(val));
			root.left = deserial(queue);
			root.right = deserial(queue);
			return root;
		}

	}

}
