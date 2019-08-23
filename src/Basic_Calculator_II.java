import java.util.Stack;

public class Basic_Calculator_II {

	public int calculate (String s) {
		if (s == null || s.length() == 0) return 0;
		int num = 0;
		char sign = '+';
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				num = num * 10 + s.charAt(i) - '0';
			}
			if ((!Character.isDigit(s.charAt(i))) && s.charAt(i) != ' ' || i == s.length() - 1) {
				if (sign == '+')
					stack.push(num);
				if (sign == '-')
					stack.push(-num);
				if (sign == '*')
					stack.push(stack.pop() * num);
				if (sign == '/')
					stack.push(stack.pop() / num);
				sign = s.charAt(i);
				num = 0;
			}
		}
		int res = 0;
		for (int n : stack) {
			res += n;
		}
		return res;
	}
	
	public static void main (String[] args) {
		String str = "3 + 4 * 5";
		System.out.println(new Basic_Calculator_II().calculate(str));
	}
}
