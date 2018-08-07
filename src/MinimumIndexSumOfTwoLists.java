import java.util.*;

public class MinimumIndexSumOfTwoLists {
	public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap();
        List<String> res = new ArrayList<String>();
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int j = 0; j < list2.length; j++) {
        		if (map.containsKey(list2[j])) {
        			if (minIndex > map.get(list2[j]) + j) minIndex = map.get(list2[j]) + j;
        			res.clear();
        			res.add(list2[j]);
        		}
        }
        return res.toArray(new String[res.size()]);
    }
	
}
