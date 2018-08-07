import java.util.Stack;

public class LongestValidPrentheses {

	
	public static void main (String[] args) {
		String input = ")()())";
		int longestP = LongestParentheses(input);
		System.out.println(longestP);
	}

	private static int LongestParentheses(String input) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		int longest = 0, n = input.length();
		for (int i = 0; i < n; i++) {
			if (input.charAt(i) == '(') {
				stack.push(i);
			}else {
				if (!stack.isEmpty()) {
					if (input.charAt(stack.firstElement()) == '(') {
						stack.pop();
					}else {
						stack.push(i);
					}
				}else stack.push(i);
			}
		}
		if (stack.isEmpty()) longest = n;
		else {
			int l = 0, r = n;
			while (!stack.isEmpty()) {
				l = stack.firstElement();
				stack.pop();
				longest = Math.max(longest, r - l - 1);
				r = l;
			}
			longest = Math.max(longest, r);
		}
		return longest;
	}
}
