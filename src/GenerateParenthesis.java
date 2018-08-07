import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	public List<String> generateParenthesis (int n) {
		List<String> res = new ArrayList<String>();
		backtrack(res, "", 0, 0, n);
		return res;
	}
	
	public void backtrack(List<String> res, String str, int open, int close, int n) {
		if (str.length() == n * 2) {
			res.add(str);
			return;
		}
		
		if (open < n) backtrack(res, str + "(", open + 1, close, n);
		if (open > close) backtrack(res, str + ")", open, close + 1, n);
	}
	
	public static void main (String[] args) {
		int n = 5;
		List<String> parenthesis = new GenerateParenthesis().generateParenthesis(n);
		System.out.println(parenthesis.toString());
	}
}
