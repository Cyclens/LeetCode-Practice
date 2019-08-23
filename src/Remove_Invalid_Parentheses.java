import java.util.ArrayList;
import java.util.List;

public class Remove_Invalid_Parentheses {

	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<String>();
		helper(s, res, 0, 0, '(', ')');
		return res;
	}

	private void helper(String s, List<String> res, int istart, int jstart, char open, char close) {
		// TODO Auto-generated method stub
		int counter = 0;
		for (int i = istart; i < s.length(); i++) {
			if (s.charAt(i) == open) counter++;
			if (s.charAt(i) == close) counter--;
			if (counter < 0) {
				for (int j = jstart; j <= i; j++) {
					if (s.charAt(j) == close && (j == jstart || s.charAt(j - 1) != close)) {
						helper(s.substring(0, j) + s.substring(j + 1, s.length()), res, i, j, open, close);
					}
				}
				return;
			}
		}
		String reversed = new StringBuilder(s).reverse().toString();
		if (open == '(') {
			helper(reversed, res, 0, 0, ')', '(');
		}else {
			res.add(reversed);
		}
	}
	
	public static void main(String[] args) {
		String pars = "((())))()()()())";
		System.out.println(new Remove_Invalid_Parentheses().removeInvalidParentheses(pars).toString());
	}
}
