package Paypal_Credit;

import java.util.*;

public class K_Difference {

	public static int kDifference(List<Integer> a, int k) {

		int count = 0;
		Collections.sort(a);
		int l = 0, r = 0;
		while (r < a.size()) {

			//System.out.println(a.get(r) + " " + a.get(l));
			if (a.get(r) - a.get(l) == k) {
				count++;
				l++;
				r++;
			}
			else if (a.get(r) - a.get(l) > k) {
				l++;
			}else
				r++;
		}
		return count;
	}

	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(new Integer[] { 1, 5, 3, 4, 2 });
		System.out.println(kDifference(a, 2));
	}
}
