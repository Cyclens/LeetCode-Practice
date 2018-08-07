import java.util.HashSet;

public class LongestSubstring {
	
	public static int longsub (String s) {
		int maxlen = 0;
		HashSet<Character> set = new HashSet<Character>();
		int i = 0, j = 0;
		while (i < s.length() && j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				maxlen = Math.max(maxlen, j - i + 1);
				j++;
			}
			else {
				set.remove(s.charAt(i));
				i++;
			}
			
		}
		return maxlen;
	}
	
	public static void main (String[] args) {
		String s = "abcabcbb";
		int longsubs = longsub(s);
		System.out.println(longsubs);
		
		
	}
}
