import java.util.Stack;

public class ParenthesisMatch {

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '[')
				stack.push(']');
			else if (c == '{')
				stack.push('}');
			else if (c == '(')
				stack.push(')');
			else if (stack.isEmpty() || c != stack.pop())
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		String input = "[][][]{{{{([][])}}}}";
		System.out.println(isValid(input));
	}
}
