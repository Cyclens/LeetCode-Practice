import java.util.*;

public class Insert_Delete_GetRandom {

	List<Integer> list;
	Map<Integer, Integer> map;
	Random rand = new Random();
	public Insert_Delete_GetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {

		if (map.containsKey(val)) return false;
		else {
			map.put(val, list.size());

			list.add(val);
			return true;
		}
		
		
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {

		if (!map.containsKey(val)) return false;
		int idx = map.get(val);
		if (idx < list.size() - 1) {
			int last = list.get(list.size() - 1);
			list.set(idx, last);
			map.put(last, idx);
		}
		map.remove(val);
		list.remove(list.size() - 1);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {

		return list.get(rand.nextInt(list.size()));
	}
}
