import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ValidParenthesis {
	
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '[') stack.push(']');
			else if (c == '(') stack.push(')');
			else if (c == '{') stack.push('}');
			else if (stack.isEmpty() || stack.pop() != c) return false;
		}
		return stack.isEmpty();
	}
	
	public static void main (String[] args) {
		String input = "{)(}";
		boolean isValid = new ValidParenthesis().isValid(input);
		System.out.println(isValid);
	}
}
