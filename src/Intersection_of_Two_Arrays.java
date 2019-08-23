import java.util.*;

public class Intersection_of_Two_Arrays {

	public int[] intersection(int[] nums1, int[] nums2) {

		Set<Integer> intersection = new HashSet<Integer>();
		Map<Integer,Integer> map = new HashMap<>();
		for (int num1 : nums1) {
			map.put(num1, map.getOrDefault(num1, 0) + 1);
		}
		for (int num2 : nums2) {
			if (map.containsKey(num2) && map.get(num2) > 0) {
				intersection.add(num2);
				map.put(num2, map.get(num2) - 1);
			}
		}
		int[] res = new int[intersection.size()];
		int idx = 0;
		for (int num : intersection) {
			res[idx] = num;
			idx++;
		}
		System.out.println(intersection.toString());
		return res;
	}
	
	public static void main (String[] args) {
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		int[] res = new Intersection_of_Two_Arrays().intersection(nums1, nums2);
		System.out.println(Arrays.toString(res));
	}
}
