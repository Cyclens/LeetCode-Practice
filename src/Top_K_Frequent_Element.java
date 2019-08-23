import java.util.*;
import java.util.Map.Entry;

public class Top_K_Frequent_Element {

	public List<Integer> topKFrequent_BucketSort(int[] nums, int k) {

		if (nums.length == 0 || k == 0)
            return new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		List<Integer>[] buckets = new ArrayList[nums.length + 1];
		for (int key : map.keySet()) {
			int freq = map.get(key);
			if (buckets[freq] == null) {
				buckets[freq] = new ArrayList<>();
			}
			buckets[freq].add(key);
		}
		List<Integer> res = new ArrayList<>();
		for (int i = buckets.length - 1; i >= 0 && res.size() < k; i--) {
			if (buckets[i] != null) {
				res.addAll(buckets[i]);
			}
		}
		return res;
	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {

		if (nums.length == 0 || k == 0)
            return new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		List<Integer> freqs = new ArrayList<>();
		for (int n : map.values()) {
			freqs.add(n);
		}
		Collections.sort(freqs);
		freqs = freqs.subList(freqs.size() - k, freqs.size());

		// System.out.println(freqs.toString());
		List<Integer> res = new ArrayList<>();
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (freqs.contains(entry.getValue()))
				res.add(entry.getKey());
		}
		return res;
	}
	
	public static void main (String[] args) {
		int[] num = {1};
		int k = 1;
		System.out.println(new Top_K_Frequent_Element().topKFrequent(num, k).toString());
		System.out.println(new Top_K_Frequent_Element().topKFrequent_BucketSort(num, k).toString());
	}
}
