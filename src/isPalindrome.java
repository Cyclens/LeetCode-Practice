
public class isPalindrome {
	public boolean isPalindrome (String s) {
		String[] words = s.split(" ");
		for (int i = 0; i < words.length; i++) {
			if (isValid(words[i])) return true;
			System.out.println(words[i]);
		}
		return false;
	}
	
	public boolean isValid(String s) {
		int i = 0, j = s.length() - 1;
		while (i <= j) {
			if (s.charAt(i) != s.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}
	
	public static void main (String[] args) {
		String s = "race a car";
		boolean res = new isPalindrome().isPalindrome(s);
		System.out.println(res);
	}
	
}
