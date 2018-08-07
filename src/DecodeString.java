import java.util.Stack;

public class DecodeString {
	
	public String decodeString(String s) {
		Stack<Integer> intStack = new Stack<Integer>();
		Stack<StringBuilder> strStack = new Stack<StringBuilder>();
		StringBuilder str = new StringBuilder();
		int k = 0;
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				k = k * 10 + c - '0';
			}
			else if (c == '[') {
				intStack.push(k);
				strStack.push(str);
				str = new StringBuilder();
				k = 0;
			}
			else if (c == ']') {
				StringBuilder temp = str;
				str = strStack.pop();
				for (k = intStack.pop(); k > 0; k--) str.append(temp);
			}
			else str.append(c);
		}
		return str.toString();
	}
	
	public static void main (String[] args) {
		String s = "3[a2[c]]";
		String res = new DecodeString().decodeString(s);
		System.out.println(res);
	}
}
