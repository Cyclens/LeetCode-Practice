package Google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Remove_Duplicate_Letter {


	public String removeDuplicateLetters(String s) {
/*
		char[] letters = s.toCharArray();
		boolean[] visited = new boolean[26];
		int[] counts = new int[26];
		int[] st = new int[26];
		int size = 0;

		for (char c : letters)
			counts[c - 'a']++;
		System.out.println(Arrays.toString(counts));
		for (char c : letters) {
			int idx = c - 'a';
			counts[idx]--;
			if (visited[idx])
				continue;
			while (size > 0 && st[size - 1] > idx && counts[st[size - 1]] > 0) {
				visited[st[size - 1]] = false;
				size--;
			}
			st[size++] = idx;
			visited[idx] = true;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++)
			sb.append((char) (st[i] + 'a'));
		return sb.toString();
	}
*/
//	public static String removeDuplicateLetters(String s) {
		if (s == null || s.length() <= 1) return s;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), i);
		}
		char[] res = new char[map.size()];
		int begin = 0;
		int end = findMinMap(map);
		for (int i = 0; i < s.length(); i++) {
			char minChar = 'z' + 1;
			for (int j = begin; j <= end; j++) {
				if (map.containsKey(s.charAt(j)) && s.charAt(j) < minChar) {
					minChar = s.charAt(j);
					begin = j + 1;
				}
			}
			res[i] = minChar;
			if (i == res.length - 1) break;
			map.remove(minChar);
			if (s.charAt(end) == minChar) end = findMinMap(map);
		}
		return new String(res);
	}

	private static int findMinMap(Map<Character, Integer> map) {
		int min = Integer.MAX_VALUE;
		for (int val : map.values()) {
			min = Math.min(min, val);
		}
		return min;
	}

	public static void main(String[] args) {
		String str = "cbacdcbc";
		System.out.println(new Remove_Duplicate_Letter().removeDuplicateLetters(str));
	}
}
