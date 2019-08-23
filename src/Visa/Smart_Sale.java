package Visa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Smart_Sale {

	public static int deleteProducts(List<Integer> ids, int m) {
		// Write your code here

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < ids.size(); i++) {
			if (!map.containsKey(ids.get(i))) {
				map.put(ids.get(i), 1);
			} else {
				map.put(ids.get(i), map.get(ids.get(i)) + 1);
			}
		}
		List<Integer> occur = new ArrayList<Integer>();
		for (int i : map.keySet()) {
			occur.add(map.get(i));
		}
		
		System.out.println(map.toString());
		Collections.sort(occur);
		System.out.println(occur.toString());
		int res = map.size();
		for (int i = 0; i < occur.size(); i++) {
			m -= occur.get(i);
			if (m < 0)
				break;
			res--;
		}
		return res;

	}

	public static void main(String[] args) {
		Integer[] id = { 1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3 };
		List<Integer> ids = Arrays.asList(id);
		//System.out.println(deleteProducts(ids, 10));
		
		
		int a = 2437, b = 875;
		int x = a, y = b;
		while (x != y) {
			if (x > y) x = x- y;
			if (x < y) y = y -x;
		}
		System.out.println(x);
	}
}
