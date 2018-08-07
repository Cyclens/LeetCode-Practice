package Google;

public class Closest_Binary_Search_Tree_Value {

	public static int closestValue(TreeNode root, double target) {
		int val = root.val;
		TreeNode next = null;
		if (val > target) {
			next = root.left;
		}
		else 
			next = root.right;
		if (next == null)
			return val;
		int secondVal = closestValue(next, target);
		if (Math.abs(val - target) < Math.abs(secondVal - target))
			return val;
		else
			return secondVal;
	}
}
