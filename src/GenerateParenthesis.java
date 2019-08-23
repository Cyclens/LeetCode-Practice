import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public static List<String> gen (int n) {
		List<String> res = new ArrayList<String>();
		if (n != 0) {
			backtrack(res, "", 0, 0, n);
		}
		return res;
	}
	
	public static void backtrack (List<String> res, String s, int l, int r, int n) {
		if (s.length() == 2 * n) {
			res.add(s);
			return;
		}
		if (l < n) {
			backtrack(res, s + "(", l + 1, r, n);
		}
		if (r < l) {
			backtrack(res, s + ")", l, r + 1, n);
		}
	}
	
	public static void main (String[] args) {
		int n = 3;
		System.out.println(gen(n).toString());
	}
}
