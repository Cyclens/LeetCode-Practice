package Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public class Topological_Sort {

	public String topologicalSort(String[][] input) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < input.length; i++) {
			String[] pair = input[i];
			if (!map.containsKey(pair[0]))
				map.put(pair[0], 0);
			if (!map.containsKey(pair[1]))
				map.put(pair[1], 1);
			else
				map.put(pair[1], map.get(pair[1]) + 1);
		}
		ArrayList<String> strs = new ArrayList<String>();
		Queue<String> q = new LinkedList<String>();
		for (Entry<String, Integer> e : map.entrySet()) {
			if(e.getValue() == 0) {
				q.add(e.getKey());
			}
		}
		while (!q.isEmpty()) {
			String from = q.poll();
			strs.add(from);
			for (int i = 0; i < input.length; i++) {
				if (input[i][0] == from) {
					String to = input[i][1];
					int val = map.get(to);
					map.put(to, val - 1);
					if (val - 1 == 0)
						q.add(to);
				}
			}
		}
		String res = "";
		for (String str : strs) {
			res += str;
			res += " ";
		}
		return res;
	}
	
	public static void main(String[] args) {
		String[][] input = {{"dogs", "are"}, {"cats", "are"}, {"are", "very"}, {"very", "cute"}};
		System.out.println(new Topological_Sort().topologicalSort(input));
	}
}
