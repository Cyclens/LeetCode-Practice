package ForUsAll;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_1 {

	public static int[] solution(int[] T) {
		// write your code in Java SE 8

		if (T.length == 0 || T == null)
			return new int[0];
		int[] res = new int[T.length - 1];
		Arrays.fill(res, 0);
		Map<Integer, List<Integer>> ancestorMap = new HashMap<>();
		int cap = -1;
		for (int i = 0; i < T.length; i++) {
			if (T[i] == i) {
				cap = i;
				continue;
			}
			if (ancestorMap.containsKey(T[i])) {
				ancestorMap.get(T[i]).add(i);
			} else {
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.add(i);
				ancestorMap.put(T[i], tmp);
			}
		}
		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.addAll(ancestorMap.get(cap));
		int k = 0;
		while (!stack.isEmpty()) {
			res[k] = stack.size();
			//System.out.println(stack.size());
			int j = stack.size();
			while (j > 0) {
				int pop = stack.pop();
				if (ancestorMap.containsKey(pop)) {
					stack.addAll(ancestorMap.get(pop));
				}
				j--;
				
			}
			
			k++;

		}
		return res;
	}



	public static void main(String[] args) {
		int[] T = { 0,0,0,0 };
		System.out.println(Arrays.toString(solution(T)));
	}
}
