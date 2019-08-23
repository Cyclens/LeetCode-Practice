package Twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Whos_the_closest {
	// Complete the closest function below.
	static List<Integer> closest(String s, List<Integer> queries) {

		/*
		List<Integer> res = new ArrayList<Integer>();
		for (Integer q : queries) {
			char tgt = s.charAt(q);
			int idx = -1;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == tgt && i != q) {
					if (idx == -1) {
						idx = i;
					}else {
						if (Math.abs(q - i) < Math.abs(q - idx)) {
							idx = i;
						}
						else if (Math.abs(q - i) == Math.abs(q - idx)) {
							idx = i < idx? i : idx;
						}
					}
				}
			}
			res.add(idx);
		}
		return res;
		*/
		int [][] idx = new int[s.length()][2];
		for (int i = 0; i < s.length(); i++) {
			int l = i == 0? -1 : i - 1;
			int r = i == s.length() - 1? -1 : i + 1;
			while (l >= 0 && l != -1) {
				if (s.charAt(l) != s.charAt(i))
					l--;
				else 
					break;
			}
			while (r <= s.length() - 1 && r != -1) {
				if (s.charAt(r) != s.charAt(i))
					r++;
				else
					break;
			}
			if (r == s.length()) r = -1;
			idx[i][0] = l;
			idx[i][1] = r;
		}
		System.out.println(Arrays.deepToString(idx));
		List<Integer> res = new ArrayList<Integer>();
		for (int q : queries) {
			int r;
			if (idx[q][0] == -1)
				r = idx[q][1];
			else if (idx[q][1] == -1)
				r = idx[q][0];
			else if (q - idx[q][0] == idx[q][1] - q)
				r = idx[q][0];
			else {
				r = q - idx[q][0] < idx[q][1] - q? idx[q][0] : idx[q][1];
			}
			res.add(r);
		}
		return res;
	}
	
	public static void main (String[] args) {
		String s = "aaaa";
		List<Integer> q = Arrays.asList(new Integer[] {0,1,2,3});
		List<Integer> res = closest(s, q);
		System.out.println(res.toString());
	}
}