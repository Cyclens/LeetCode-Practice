package Google;

import java.util.Arrays;
import java.util.Stack;

public class Daily_Temparatures {

	public static int[] dailyTemperatures(int[] temperatures) {

		int n = temperatures.length;
		Stack<Integer> stack = new Stack<Integer>();
		int[] res = new int[n];
		for (int i= 0; i < n; i++) {
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int j = stack.pop();
				res[j] = i - j;
			}
			stack.push(i);
		}
		return res;
	}
	
	public static void main (String[] args) {
		int[] temperatures = {73,74,75,71,69,72,76,73};
		int[] res = dailyTemperatures(temperatures);
		System.out.println(Arrays.toString(res));
		
	}
}
