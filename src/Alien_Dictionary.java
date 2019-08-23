import java.util.*;

public class Alien_Dictionary {

	public String alienOrder(String[] words) {
		Map<Character, Set<Character>> map = new HashMap<>();
		Map<Character, Integer> degree = new HashMap<>();
		String res = "";
		if (words == null || words.length == 0)
			return res;
		for (String word : words) {
			for (char c : word.toCharArray()) {
				degree.put(c, 0);
			}
		}
		for (int i = 0; i < words.length - 1; i++) {
			String currWord = words[i];
			String nextWord = words[i + 1];
			int len = Math.min(currWord.length(), nextWord.length());
			for (int j = 0; j < len; j++) {
				char c1 = currWord.charAt(j);
				char c2 = nextWord.charAt(j);
				if (c1 != c2) {
					Set<Character> tmpSet = new HashSet<>();
					if (map.containsKey(c1))
						tmpSet = map.get(c1);
					if (!tmpSet.contains(c2)) {
						tmpSet.add(c2);
						map.put(c1, tmpSet);
						degree.put(c2, degree.get(c2) + 1);
					}
					break;
				}
			}
		}
		Queue<Character> q = new LinkedList<Character>();
		for (char c : degree.keySet()) {
			if (degree.get(c) == 0) {
				q.add(c);
			}
		}
		System.out.println(q.toString());
		System.out.println(map.toString());
		System.out.println(degree.toString());
		while (!q.isEmpty()) {
			char c = q.remove();
			res += c;
			if (map.containsKey(c)) {
				for (char c2 : map.get(c)) {
					degree.put(c2, degree.get(c2) - 1);
					if (degree.get(c2) == 0) {
						q.add(c2);
					}
				}
			}
		}
		if (res.length() != degree.size())
			return "";
		return res;
	}

	public static void main(String[] args) {
		String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
		System.out.println(new Alien_Dictionary().alienOrder(words));
	}
}
