import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

// Merge 2 2-dimensional arrays into one 2-dimensional array.

// example input:

// { 1, 2, 3;
// 4, 5, 6}

// { 7, 8, 9;
// 10, 11, 12;
// 13, 14, 15}

// example output:

// { 1, 2, 3;
// 4, 5, 6;
// 7, 8, 9;
// 10, 11, 12;
// 13, 14, 15}  

public class Merge2DimensionalArrays {
	public static int[][] merge2D (int[][] A, int[][] B) {
		int[][] res = new int[A.length + B.length][A[0].length];
		int i = 0;
		while (i < A.length) {
			res[i] = A[i];
			i++;
		}
		while (i < res.length) {
			res[i] = B[i - A.length];
			i++;
		}
		return res;
	}
	
	public static List<List<Integer>> merge2DSorted (int[][] a, int[][] b) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		for (int[] aa : a) {
			res.addAll(Arrays.asList(aa));
		}
		for (int i = 0; i < b.length; i++) {
			res.add(Arrays.asList(b[i]));
		}
		Collections.sort(res, new Comparator<List<Integer>>() {

			@Override
			public int compare (List<Integer> a, List<Integer> b) {
				return a.get(0) - b.get(0);
			}
			
		});
		return res;
	}
	
	public static void main (String[] args) {
		int[][] A = new int[][] {{4, 5, 6}, {1, 2, 3}};
		int[][] B = new int[][] {{7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
		int[][] res = merge2D(A, B);
		List<List<Integer>> res2 =  merge2DSorted(A, B);
		System.out.println(Arrays.deepToString(res));
	}
}
