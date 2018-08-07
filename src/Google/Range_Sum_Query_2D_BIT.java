package Google;

public class Range_Sum_Query_2D_BIT {

	int m, n;
	int [][] memo;
	int [][] BIT;
	
	public Range_Sum_Query_2D_BIT (int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) return;
		m = matrix.length;
		n = matrix[0].length;
		memo = new int[m][n];
		BIT = new int[m + 1][n + 1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				update(i, j, matrix[i][j]);
				memo[i][j] = matrix[i][j];
			}
		}
	}
	public void update(int x, int y, int val) {
		int diff = val - memo[x][y];
		memo[x][y] = val;
		x++;
		y++;
		for (int i = x; i < m + 1; i += i & -i) {
			for (int j = y; j < n + 1; j += j & -j) {
				BIT[i][j] += diff;
			}
		}
	}
	
	public int sum(int i, int j) {
		int sum = 0;
		i++;
		j++;
		for (int x = i; x > 0; x -= x & -x) {
			for (int y = j; y > 0; y -= y & -y) {
				sum += BIT[x][y];
			}
		}
		return sum;
	}
	
	public int sumRegion(int row1, int col1, int row2, int col2) {
		return sum(row1 - 1, col1 - 1) + sum(row2, col2) - sum(row1 - 1, col2) - sum(row2, col1 - 1);
	}
	
	public static void main (String[] args) {
		for (int i = 1; i <100; i += i & -i) {
			System.out.println(i);
		}
	}
}
