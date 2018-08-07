import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {
	public String nextClosestTime(String time) {
		int currTime = 60 * Integer.parseInt(time.substring(0, 2));
		currTime += Integer.parseInt(time.substring(3));
		int res = currTime;
		int total = 24 * 60;
		//System.out.println(total);
		Set<Integer> allowed = new HashSet<>();
		for (char c : time.toCharArray())
			if (c != ':') {
				allowed.add(c - '0');
			}

		for (int hr1 : allowed)
			for (int hr2 : allowed)
				if (hr1 * 10 + hr2 < 24) {
					for (int min1 : allowed)
						for (int min2 : allowed)
							if (min1 * 10 + min2 < 60) {
								int cur = 60 * (hr1 * 10 + hr2) + (min1 * 10 + min2);
								int interval = Math.floorMod(currTime - cur, 24 * 60);
								if (0 < interval && interval < total) {
									res = cur;
									total = interval;
								}
							}
				}
		
		String hr;
		if (res / 60 == 0) hr = "00";
		else hr = String.valueOf(res / 60);
		if (hr == "0") hr = "00";
		String min;
		if (res % 60 == 0) min = "00";
		else min = String.valueOf(res % 60);

		return hr + ":" + min;
	}

	public static void main(String[] args) {
		String time = "12:34";
		String nexttime = new NextClosestTime().nextClosestTime(time);
		System.out.println(nexttime);
	}
}
