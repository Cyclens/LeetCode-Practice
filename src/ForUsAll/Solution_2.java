package ForUsAll;

import java.util.*;

public class Solution_2 {

	public static int solution(int[] A) {
        // write your code in Java SE 8
		
		
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int a : A) {
			if (map.containsKey(a))
				map.put(a, map.get(a) + 1);
			else
				map.put(a, 1);
		}
		int k = map.size();
		System.out.println(map.toString());
		Set<Integer> visited = new HashSet<>();
		
		
		int l = 0;
		int minl = 0;
		int minlen = A.length + 1;
		int cnt = 0;
		for (int r = 0; r < A.length; r++) {
			
		}
		
		for (int r = 0; r < A.length; r++) {
			if (map.containsKey(A[r])) {
				map.put(A[r], map.get(A[r]) - 1);
				if (map.get(A[r]) >= 0) {
					cnt++;
				}
				while (cnt == k) {
					if (r - l + 1 < minlen) {
						minl = l;
						minlen = r - l + 1;
					}
					if (map.containsKey(A[l])) {
						map.put(A[l], map.get(A[l]) + 1);
						if (map.get(A[l]) > 0) {
							cnt--;
						}
					}
					l++;
				}
			}
		}
		System.out.println(minl);
		return minlen;
    }
	
	public static void main (String[] args) {
		int[] A = {7,5,2,7,2,7,4,7};
		System.out.println(solution(A));
	}
}
