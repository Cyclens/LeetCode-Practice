import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.*;
import java.util.Map.Entry;


public class TrappingRainWater {
	public static int trap(int[] height ) {
		int left = 0, right = height.length - 1, maxleft = 0, maxright = 0;
		int sum = 0;
		while (left <= right) {
			if (height[left] <= height[right]) {
				if (height[left] >= maxleft) {
					maxleft = height[left];
					System.out.println("maxleft = " + maxleft);
				}
				else {
					sum += maxleft - height[left];
				}
				left++;
			}else {
				if (height[right] >= maxright) {
					maxright = height[right];
					System.out.println("maxleft = " + maxleft);
				}
				else {
					sum += maxright - height[right];
					
				}
				right--;
			}
		}
		return sum;
	}
	
	/*
	public static int trap(int[] height) {
		if (height.length < 3) return 0;
		int sum = 0;
		int max = Arrays.stream(height).max().getAsInt();
		if (max < 1) return 0;
		Set<Integer> heightSet = new TreeSet<Integer>();
		for (int i = 0; i < height.length; i++) {
			heightSet.add(height[i]);
		}
		
		System.out.println(heightSet.toString());
		Map<Integer, Integer> freqmap = new HashMap<Integer, Integer>();
		for (int i = 0; i < height.length; i++) {
			Integer f = freqmap.get(height[i]);
			if (f == null)
				freqmap.put(height[i], 1);
			else
				freqmap.put(height[i], f + 1);
		}
		
		for (Entry<Integer, Integer> pair : freqmap.entrySet())
			System.out.println(pair.getKey() + " : " + pair.getValue());

		//System.out.println(freqmap.get(2));
		int freq = 0;
		for (int i = heightSet.size() - 1; i >= 0; i--) {
			int layer = 0;
			
			freq += freqmap.get(heightSet[i]);
			int FirstIndex = findIndex(height, i);
			int LastIndex = findLastIndex(height, i);
			System.out.println("First index is : " + FirstIndex + ", last index is : " + LastIndex );
			if (LastIndex > FirstIndex + 1)
				layer = LastIndex - FirstIndex - 1 - freq + 2;
				System.out.println("Layer: " + layer);
			sum += layer;
		}
		
		return sum;
	}
	
	private static int findLastIndex(int[] nums, int n) {
		// TODO Auto-generated method stub
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == n) return i;
		}
		return -1;
	}

	public static int findIndex(int[] nums, int n) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == n) return i;
		}
		return -1;
	}
	*/
	public static void main(String args[]) {
		int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		int sumOfWater = trap(height);
		System.out.println(sumOfWater);
	}
}
