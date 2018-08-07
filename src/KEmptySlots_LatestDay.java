import java.util.Arrays;

public class KEmptySlots_LatestDay {
	static int KEmptySlots(int[] flowers, int k) {
		int[] days = new int[flowers.length];
		for (int i = 0; i < flowers.length; i++) {
			days[flowers[i] - 1] = i + 1;
		}
		System.out.println(Arrays.toString(days));
		int res = Integer.MAX_VALUE;
		int left = 0, right = k + 1;
		int latest = 0;
		for (int i = 0; right < flowers.length; i++) {

			if (days[i] > days[left] && days[i] > days[right])
				continue;
			if (i == right) {
				res = Math.min(res, Math.max(days[left], days[right]));
				System.out.println(left);
			}
			left = i;
			right = left + k + 1;
		}
//		System.out.println(latest);
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	public static void main(String[] args) {
		int[] flowers = new int[] { 6, 2, 1, 4, 5, 3 };
		int k = 3;
		System.out.println(KEmptySlots(flowers, k));
	}
}
