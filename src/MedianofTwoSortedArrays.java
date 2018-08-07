
public class MedianofTwoSortedArrays {
	public static double MedianofTwo(int[] A, int[] B) {
		int m = A.length, n = B.length;
		int l = (m + n + 1) / 2;
		int r = (m + n + 2) / 2;
		return (getKth(A, 0, B, 0, l) + getKth(A, 0, B, 0, r)) / 2.0;
	}

	private static double getKth(int[] A, int startA, int[] B, int startB, int k) {
		// TODO Auto-generated method stub

		if (startA > A.length - 1)
			return B[startB + k - 1];
		if (startB > B.length - 1)
			return A[startA + k - 1];
		if (k == 1)
			return Math.min(A[startA], B[startB]);

		int midA = Integer.MAX_VALUE, midB = Integer.MAX_VALUE;
		if (startA + k / 2 - 1 < A.length)
			midA = A[startA + k / 2 - 1];
		if (startB + k / 2 - 1 < B.length)
			midB = B[startB + k / 2 - 1];

		if (midA < midB)
			return getKth(A, startA + k / 2, B, startB, k - k / 2);
		else
			return getKth(A, startA, B, startB + k / 2, k - k / 2);
	}

	public static void main(String[] args) {
		int[] A = new int[] { 2, 3, 4, 5, 6 };
		int[] B = new int[] { 1 };
		double newMid = MedianofTwo(A, B);
		System.out.println(newMid);
	}
}
