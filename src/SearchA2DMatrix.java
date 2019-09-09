
public class SearchA2DMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		int l = 0, m = matrix.length, n = matrix[0].length;
		int r = m * n - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (matrix[mid/n][mid%n] == target) {
				return true;
			}
			else if (matrix[mid/n][mid%n] < target) {
				l = mid + 1;
			}
			else {
				r = mid - 1;
			}
		}
		return false;
	}
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix =  {{1}};
		int target = 1;
		System.out.println(searchMatrix(matrix, target));
	}

}
