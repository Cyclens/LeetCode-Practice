
public class BombEnemy {
	public int maxKilledEnemies(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		int[][] count = new int[m][n];
		int max = 0;
		for (int i = 0; i < m; i++) {
			int curr = 0;
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '0')
					count[i][j] = curr;
				else if (grid[i][j] == 'E')
					curr++;
				else
					curr = 0;
			}
			curr = 0;
			for (int j = n - 1; j >= 0; j--) {
				if (grid[i][j] == '0')
					count[i][j] += curr;
				else if (grid[i][j] == 'W')
					curr = 0;
				else
					curr++;
			}
		}

		for (int j = 0; j < n; j++) {
			int curr = 0;
			for (int i = 0; i < m; i++) {
				if (grid[i][j] == 'W')
					curr = 0;
				else if (grid[i][j] == 'E')
					curr++;
				else
					count[i][j] += curr;
			}
			curr = 0;
			for (int i = m - 1; i >= 0; i--) {
				if (grid[i][j] == 'W')
					curr = 0;
				else if (grid[i][j] == 'E')
					curr++;
				else {
					count[i][j] += curr;
					max = Math.max(max, count[i][j]);
				}
			}
		}
		return max;
	}

}
