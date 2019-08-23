import java.util.Comparator;
import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array {

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 -o2;
			}
		});
		for (int num : nums) {
			pq.offer(num);
		}
		int res = nums[0];
		for (int i = 0; i <= nums.length - k; i++) {
			res = pq.poll();
		}
		return res;
	}
}
