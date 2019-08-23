import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Most_Common_Word {
	
	public static String mostCommonWord(String paragraph, String[] banned) {
		String[] words = paragraph.split(" ");
		//System.out.println(Arrays.toString(words));
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			word = word.toLowerCase();
			//System.out.println(word);
			if (!word.matches("[a-z]+"))
				// System.out.println(word);
				word = word.substring(0, word.length() - 1);
			//System.out.println(word);
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			}else {
				map.put(word, 1);
			}
		}
		for (String bWord : banned) {
			map.remove(bWord);
		}
		int max_count = 0;
		String res = words[0];
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (max_count == 0) {
				max_count = entry.getValue();
				res = entry.getKey();
			}
			else {
				if (max_count < entry.getValue()) {
					max_count = entry.getValue();
					res = entry.getKey();
				}
			}
		}
		System.out.println(map.toString());
		return res;
		
	}
	
	public static void main (String[] args) {
		String str = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = {"hit"};
		System.out.println(mostCommonWord(str, banned));
	}
}
