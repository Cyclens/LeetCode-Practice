
public class StringPalindrome {

	public boolean isPalindrome (String s) {
		if (s.length() == 0) return true;
		int l = 0, r = s.length() - 1;
		while (l <= r) {
			if (!Character.isLetterOrDigit(s.charAt(l))) l++;
			else if (!Character.isLetterOrDigit(s.charAt(r))) r--;
			else {
				//System.out.println(s.charAt(l));
				//System.out.println(s.charAt(r));
				if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
				l++;
				r--;
			}
		}
		return true;
	}
	
	public static void main (String[] args) {
		String input = "0P";
		boolean res = new StringPalindrome().isPalindrome(input);
		System.out.println(res);
	}
}
