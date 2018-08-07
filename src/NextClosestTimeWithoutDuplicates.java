import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextClosestTimeWithoutDuplicates {
	public String nextClosestTime(String time) {
		int TimeDigits = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
		List<String> StrPer = new ArrayList<String>();
		String time1 = time.substring(0, 2) + time.substring(3);
		System.out.println(time1);
		permutation(StrPer, "", time1);
		System.out.println(StrPer.toString());
		List<Integer> IntPer = new ArrayList<Integer>();
		for (String s : StrPer) {
			//System.out.println(s);
			int hr = Integer.parseInt(s.substring(0, 2)), sec = Integer.parseInt(s.substring(2));
			if (hr < 24 && sec < 60) {
				int IntTime = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(2));
				IntPer.add(IntTime);
			}
		}
		Collections.sort(IntPer);
		System.out.println(IntPer.toString());
		int index = IntPer.indexOf(TimeDigits);
		String res;
		if (index != IntPer.size() - 1) {
			res = String.valueOf(IntPer.get(index + 1) / 60) + ":" + String.valueOf(IntPer.get(index + 1) % 60);
		}
		else {
			res = String.valueOf(IntPer.get(0) / 60) + ":" + String.valueOf(IntPer.get(0) % 60);
		}
		return res;
		
	}

	private static void permutation(List<String> res, String prefix, String str) {
		int n = str.length();
		if (n == 0)
			res.add(prefix);
		else {
			for (int i = 0; i < n; i++)
				permutation(res, prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
		}
	}
	public static void main (String[] args) {
		String time = "19:34";
		String nexttime = new NextClosestTimeWithoutDuplicates().nextClosestTime(time);
		System.out.println(nexttime);
	}
}
