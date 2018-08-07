
public class SearchA2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix == null) return false;
		int i = 0, j = matrix[0].length - 1;
		while (i < matrix.length && j >= 0) {
			if (matrix[i][j] > target) {
				j--;
				continue;
			}
			if (matrix[i][j] < target) {
				i++;
				continue;
			}
			else
				return true;
		}
		return false;
	}
}
