package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Closest_Two_Sum {

	public static ArrayList<Double> findTwoSum(double[] nums, double target) {

		if (nums == null || nums.length < 2)
			return new ArrayList<Double>();
		ArrayList<Double> res = new ArrayList<Double>();
		if (nums.length == 2) {
			res.add(nums[0]);
			res.add(nums[1]);
			return res;
		}
		Arrays.sort(nums);
		int i = 0;
		int j = nums.length - 1;
		double min = nums[i] + nums[j];
		double l = nums[i];
		double r = nums[j];
		while (i < j) {
			double sum = nums[i] + nums[j];
			double diff = sum - target;
			if (diff == 0.0) {
				res.add(nums[i]);
				res.add(nums[j]);
				return res;
			}

			if (Math.abs(sum - target) < Math.abs(min - target)) {
				min = sum;
				l = nums[i];
				r = nums[j];
			}
			if (sum > target) {
				j--;
			} else {
				i++;
			}
		}
		res.add(l);
		res.add(r);
		return res;
	}

	public static ArrayList<Double> findTwoSumList(List<Double> nums, double target) {

		if (nums == null || nums.size() < 2)
			return new ArrayList<Double>();
		ArrayList<Double> res = new ArrayList<Double>();
		if (nums.size() == 2) {
			res.add(nums.get(0));
			res.add(nums.get(1));
			return res;
		}

		Collections.sort(nums);
		int i = 0;
		int j = nums.size() - 1;
		double min = nums.get(i) + nums.get(j);
		double l = nums.get(i);
		double r = nums.get(j);
		while (i < j) {
			double sum = nums.get(i) + nums.get(j);
			double diff = sum - target;
			if (diff == 0.0) {
				res.add(nums.get(i));
				res.add(nums.get(j));
				return res;
			}

			if (Math.abs(sum - target) < Math.abs(min - target)) {
				min = sum;
				l = nums.get(i);
				r = nums.get(j);
			}
			if (sum > target) {
				j--;
			} else {
				i++;
			}
		}
		res.add(l);
		res.add(r);
		return res;
	}

	public static void main(String[] args) {
		double[] nums = new double[] { -1, 2, 1, -4 };
		double target = 4;;
		
		List<Double> input = new ArrayList<Double>();
		input.add(-1.0);
		input.add(2.0);
		input.add(1.0);
		input.add(-4.0);
		System.out.println(findTwoSumList(input, target).toString());
		System.out.println(findTwoSum(nums, target).toString());
	}
}
