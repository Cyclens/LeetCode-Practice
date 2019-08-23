
public class Shortest_Palindrome {

	public static String shortestPalindrome(String s) {
		int n = s.length();
		String rev = "";
		for (int i = 0; i < n; i++) {
			rev = s.substring(i, i + 1) + rev;
		}
		System.out.println(rev);
		for (int j = 0; j < n; j++) {
			if (s.substring(0, n - j).equals(rev.substring(j)))
				return rev.substring(0, j) + s;
		}
		return "";
	}

	public String TwoPointer(String s) {
		int n = s.length();
		int i = 0;
		for (int j = n - 1; j >= 0; j--) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
			}
		}
		if (n == i)
			return s;
		String remainReverse = new StringBuilder(s.substring(i, n)).reverse().toString();
		return remainReverse + shortestPalindrome(s.substring(0, i)) + s.substring(i);
	}

	public static void main(String[] args) {
		String s = "aacecaaa";
		String ss = "abcd";
		System.out.println(shortestPalindrome(s));
		System.out.println(shortestPalindrome(ss));
	}
}
