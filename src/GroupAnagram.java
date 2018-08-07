import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
	public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0)
            return res;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String ss = String.valueOf(ca);
            if (! map.containsKey(ss))
                map.put(ss, new ArrayList<String>());
            map.get(ss).add(s);
        }
        for (String ls : map.keySet())
            res.add(map.get(ls));
        return res;
        }
	
	public static void main(String args[]) {
		String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = groupAnagrams(strs);
		System.out.println(String.valueOf(res));
		}
}
