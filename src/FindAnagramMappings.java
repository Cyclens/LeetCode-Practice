import java.util.Arrays;

public class FindAnagramMappings {
	public int[] anagramMappings(int[] A, int[] B) {
		int[] res = new int[A.length];
		for (int a = 0; a < A.length; a++) {
			for (int b = 0; b < B.length; b++) {
				if (A[a] == B[b]) {
					res[a] = b;
				}
			}
		}
		return res;
	}
	
	public static void main (String[] args) {
		int[] A = new int[] {12, 28, 46, 32, 50};
		int[] B = new int[] {50, 12, 32, 46, 28};
		int[] index = new FindAnagramMappings().anagramMappings(A, B);
		System.out.println(Arrays.toString(index));
	}
}
