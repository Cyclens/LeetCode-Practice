import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Insert_Delete_GetRandom_Dupliecates_Allowed {
	List<Integer> list;
	Map<Integer, Set<Integer>> map;
	Random rand = new Random();

	public Insert_Delete_GetRandom_Dupliecates_Allowed() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {

		if (!map.containsKey(val))
			map.put(val, new LinkedHashSet<Integer>());
		map.get(val).add(list.size());
		list.add(val);
		return !map.containsKey(val);

	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {

		if (!map.containsKey(val))
			return false;
		int idx = map.get(val).iterator().next();
		map.get(val).remove(idx);
		if (idx < list.size() - 1) {
			int last = list.get(list.size() - 1);
			list.set(idx, last);
			map.get(last).remove(list.size() - 1);
			map.get(last).add(idx);
		}
		list.remove(list.size() - 1);
		if (map.get(val).isEmpty()) map.remove(val);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {

		return list.get(rand.nextInt(list.size()));
	}
}
