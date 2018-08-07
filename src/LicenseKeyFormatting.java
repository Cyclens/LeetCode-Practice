import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LicenseKeyFormatting {
	public String licenseKeyFormatting (String S, int K) {
		if (S.length() == 0 || S == null) return S;
		Stack<Character> allowed = new Stack<Character>();
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) != '-') {
				allowed.push(Character.toUpperCase(S.charAt(i)));
			}
		}
		char[] res = new char[allowed.size() + allowed.size() / K];
		int count = 0;
		int j = res.length - 1;
		while (!allowed.isEmpty()) {
			if (count == K) {
				res[j] = '-';
				j--;
				count = 0;
			}
			res[j] = allowed.pop();
			j--;
			count++;
			
		}
		
		return new String().valueOf(res).replaceAll(" ", "");
	}
	public static void main (String[] args) {
		String S = "2-5g-3-J";
		int K = 2;
		String res = new LicenseKeyFormatting().licenseKeyFormatting(S, K);
		System.out.println(res);
	}
}
