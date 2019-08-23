import java.util.Arrays;

public class Temperature {

	public static int[] maxTemp (int[] temps) {
		int max = temps[0];
		int[] res = new int[temps.length];
		res[0] = 0;
		for (int i = 1; i < temps.length; i++) {
			if (temps[i] < temps[i - 1])
				res[i] = 0;
			else {
				if (temps[i] >= max) 
					res[i] = i;
				else
					res[i] = res[i - 1] + 1;
			max = Math.max(max, temps[i]);
			}
		}
		return res;
	}
	
	public static void main (String[] args) {
		int[] temps = new int[] {13,21,20,18,27,23,25};
		System.out.println(Arrays.toString(maxTemp(temps)));
	}
}
