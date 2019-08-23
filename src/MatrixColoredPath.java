import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixColoredPath {

	public static List<List<List<Integer>>> pathFinder(int[][] matrix) {
		List<List<Integer>> curr = new ArrayList<List<Integer>>();
		List<List<List<Integer>>> res = new ArrayList<List<List<Integer>>>();
		
		if (matrix.length > 1 && matrix[0].length > 1)
			backtrack(curr, res, matrix, 0, 0, matrix[0][0]);
		return res;
	}

	private static void backtrack(List<List<Integer>> curr, List<List<List<Integer>>> res, int[][] matrix, int i, int j,
			int sum) {
		// TODO Auto-generated method stub
		curr.add(Arrays.asList(new Integer[] { i, j }));
		if (i == matrix.length - 1 && j == matrix[0].length - 1 && sum == 0) {
			res.add(curr);
			return;
		}
		if (i < matrix.length - 2)
			backtrack(curr, res, matrix, i + 1, j, sum + matrix[i + 1][j]);
		if (j < matrix.length - 2)
			backtrack(curr, res, matrix, i, j + 1, sum + matrix[i][j + 1]);
	}
	
	public static List<List<Integer>> pathFinderBaLi(int[][] matrix) {
		int sum = 0;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		baoli(res, matrix, 0, 0, sum);
		return res;
	}

	private static void baoli(List<List<Integer>> curr, int[][] matrix, int i, int j, int sum) {
		// TODO Auto-generated method stub
		curr.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {i, j})));
		if (i == matrix.length || j == matrix[0].length) return;

		sum += matrix[i][j];
		if (i == matrix.length - 1 && j == matrix[0].length - 1 && sum == 0) return;
		baoli(curr, matrix, i + 1, j, sum);
		baoli(curr, matrix, i, j + 1, sum);
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, -1 }, { -1, 1 } };
		System.out.println(pathFinderBaLi(matrix).toString());
	}
}
