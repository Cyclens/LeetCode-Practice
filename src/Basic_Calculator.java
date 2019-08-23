import java.util.Stack;

public class Basic_Calculator {

	public static int calculate2(String s) {
		int len = s.length(), sign = 1, result = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(s.charAt(i))) {
				int sum = s.charAt(i) - '0';
				while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
					sum = sum * 10 + s.charAt(i + 1) - '0';
					i++;
				}
				result += sum * sign;
			} else if (s.charAt(i) == '+')
				sign = 1;
			else if (s.charAt(i) == '-')
				sign = -1;
			else if (s.charAt(i) == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} else if (s.charAt(i) == ')') {
				result = result * stack.pop() + stack.pop();
			}
			System.out.println(result);

		}
		return result;
	}
	
	public int calculate(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int sign = 1;
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				int num = s.charAt(i) - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					num = num * 10 + s.charAt(i + 1) - '0';
					i++;
				}
                res += num * sign;
			}else if (s.charAt(i) == '+')
				sign = 1;
			else if (s.charAt(i) == '-')
				sign = -1;
			else if (s.charAt(i) == '(') {
				stack.push(res);
				stack.push(sign);
				res = 0;
				sign = 1;
			}else if (s.charAt(i) == ')') {
				res = res * stack.pop() + stack.pop();
			}
			System.out.println(res);
		}
		return res;
	}
	
	public static void main (String[] args) {
		String str = "(1+2+3-4) + 5";
		System.out.println(new Basic_Calculator().calculate2(str));
		System.out.println(new Basic_Calculator().calculate(str));
	}
}
