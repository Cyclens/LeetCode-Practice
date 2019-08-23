import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_Substring {

	public String minWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, 0);
		}
		for (char c : t.toCharArray()) {
			if (!map.containsKey(c))
				return "";
			else {
				map.put(c, map.get(c) + 1);
			}
		}
		System.out.println(map.toString());
		int minLen = Integer.MAX_VALUE;
		int start = 0, end = 0, minStart = 0, counter = t.length();
		while (end < s.length()) {
			char c1 = s.charAt(end);
			if (map.get(c1) > 0) {
				counter--;
			}
			map.put(c1, map.get(c1) - 1);
			end++;
			while (counter == 0) {
				if (minLen > end - start) {
					minLen = end - start;
					minStart = start;
				}
				char c2 = s.charAt(start);
				map.put(c2, map.get(c2) + 1);
				if (map.get(c2) > 0) {
					counter++;
				}
				start++;
			}
		}
		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
	}

	public String minWindow2(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray())
			map.put(c, 0);
		for (char c : t.toCharArray()) {
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				return "";
		}

		System.out.println(map.toString());
		int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
		while (end < s.length()) {
			char c1 = s.charAt(end);
			if (map.get(c1) > 0)
				counter--;
			map.put(c1, map.get(c1) - 1);

			end++;

			while (counter == 0) {
				if (minLen > end - start) {
					minLen = end - start;
					minStart = start;
				}

				char c2 = s.charAt(start);
				map.put(c2, map.get(c2) + 1);

				if (map.get(c2) > 0)
					counter++;

				start++;
			}
		}
		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
	}
	
	public static void main (String[] args) {
		String s = "ADOBECODEBANC", t = "ABC";
		System.out.println(new Minimum_Window_Substring().minWindow(s, t));
		System.out.println(new Minimum_Window_Substring().minWindow2(s, t));
	}
}
