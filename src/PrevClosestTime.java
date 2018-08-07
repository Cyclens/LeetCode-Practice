import java.util.HashSet;
import java.util.Set;

public class PrevClosestTime {
	public String solution(String S) {
		int currTime = Integer.parseInt(S.substring(0, 2)) * 60 + Integer.parseInt(S.substring(3));
		int res = currTime;
		Set<Integer> digits = new HashSet();
		int total = 1440;
		
		for (char c : S.toCharArray()) {
			if (c != ':') {
				digits.add(c - '0');
			}
		}
		
		for (int a : digits) {
			for (int b : digits) {
				if (a * 10 + b < 24) {
					for (int c : digits) {
						for (int d : digits) {
							if (c * 10 + d < 60) {
								int temp = (a * 10 + b) * 60 + (c * 10) + d;
								int diff = Math.floorMod(currTime - temp, 1440);
								if (diff > 0 && diff < total) {
									res = temp;
									total = diff;
								}
							}
						}
					}
				}
			}
		}
		
		String hr, min;
		if (res / 60 == 0) hr = "00";
		else hr = String.valueOf(res/60);
		
		if (res % 60 == 0) min = "00";
		else min = String.valueOf(res % 60);
		
		return hr + ":" + min;
	}
}
