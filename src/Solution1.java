import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
	public static List<List<String>> groupAnagram(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();

		for (String str : strs) {
			char[] key = new char[26];
			for (char c : str.toCharArray()) {
				key[c - 'a']++;
			}
			String keyStr = new String(key);
			if (hm.containsKey(keyStr)) {
				hm.get(keyStr).add(str);
			} else {
				ArrayList<String> tmp = new ArrayList<String>();
				tmp.add(str);
				hm.put(keyStr, tmp);
			}
		}

		res.addAll(hm.values());
		return res;
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (strs == null || strs.length == 0)
			return res;
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String s : strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String ss = String.valueOf(ca);
			if (!map.containsKey(ss))
				map.put(ss, new ArrayList<String>());
			map.get(ss).add(s);
		}
		res.addAll(map.values());
		return res;
	}

	public static void main(String[] args) {
		String[] strs = { "eatt", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> res = groupAnagrams(strs);
		new StringtoInteger();
		// System.out.println(String.valueOf(res));
		int sti = StringtoInteger.myAtoi("      -11919730356x");
		System.out.println(sti);
		groupAnagram(strs);
	}
}

class StringtoInteger {
	public static int myAtoi(String str) {
		if (str.length() == 0)
			return 0;
		int sign = 1;
		int base = 0;
		int i = 0;
		int signcount = 0;
		while (str.charAt(i) == ' ') {
			i++;
		}
		// System.out.println(str.charAt(i));
		while (str.charAt(i) == '-' || str.charAt(i) == '+') {
			if (str.charAt(i) == '-')
				sign *= -1;
			i++;
			signcount++;
			if (signcount > 1)
				return 0;
			if (i == str.length())
				return 0;

		}
		//boolean isnotnumber = str.charAt(i) - '0' > 9 | str.charAt(i) - '0' < 0;
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {		
			if (base > Integer.MAX_VALUE / 10 ||(base == Integer.MAX_VALUE / 10 && str.charAt(i) > '7')) {
				System.out.println(1);
				if (sign == 1)
					return Integer.MAX_VALUE;
				else
					return Integer.MIN_VALUE;
			} else {
				base *= 10;
				base += str.charAt(i) - '0';
			}
			System.out.println(base);
			System.out.println(str.charAt(i));
			i++;
			
		}
		return sign * base;
	}

	public static void main(String args[]) {
		String input = "-123456";
		int inte = myAtoi(input);
		System.out.println(inte);
	}
}