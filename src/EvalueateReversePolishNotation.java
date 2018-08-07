import java.util.Stack;

public class EvalueateReversePolishNotation {
	public static int evalRPN (String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			switch(tokens[i]) {
			case "+":
				stack.push(stack.pop() + stack.pop());
				break;
			case "-":
				stack.push(-stack.pop() + stack.pop());
				break;
			case "*":
				stack.push(stack.pop() * stack.pop());
				break;
			case "/":
				int a = stack.pop(), b = stack.pop();
				stack.push(b / a);
				break;
				
			default:
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		return stack.pop();
	}
}
