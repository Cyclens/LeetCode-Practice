import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int left = 0;
		int best = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
			while (map.size() > k) {
				char leftChar = s.charAt(left);
				if (map.containsKey(leftChar)) {
					map.put(leftChar, map.get(leftChar) - 1);
					if (map.get(leftChar) == 0) {
						map.remove(leftChar);
					}
				}
				left++;
			}
			best = Math.max(best, i - left + 1);
		}
		return best;
	}
	
	public static int SlidingWindow(String s, int k) {
		int[] dic = new int[256];
		int i = 0, j = 0, res = 0, count = 0;
		while (j < s.length()) {
			if (dic[s.charAt(j)]++ == 0) count++;
			if (count > k) {
				while (--dic[s.charAt(i)] > 0) {
					i++;
				}

				count--;
			}
			res = Math.max(res, j - i + 1);
			j++;
		}
		return res;
	}
	
	
	public static void main (String[] args) {
		
		String s = "a";
		int k = 0;
		int res = new LongestSubstringWithAtMostKDistinctCharacters().lengthOfLongestSubstringKDistinct(s, k);
		int res2 = SlidingWindow(s, k);
		System.out.println(res);
		System.out.println(res2);
		
	}
}
