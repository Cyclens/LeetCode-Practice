import java.awt.List;
import java.util.ArrayList;

public class magicSquaresInGrid {

	public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int res = 0;
        for (int r = 1; r < row - 1; r++) {
            for (int c = 1; c < col - 1; c++) {
                if (grid[r][c] != 5) continue;
                if (isMagic(grid, r, c)) res++;
            }
        }
        return res;
    }

	public boolean isMagic(int[][] grid, int i, int j) {
        int[] counter = new int[10];
        for (int k = i - 1; k < i + 2; k++) {
            for (int l = j - 1; l < j + 2; l ++) {
                if (grid[k][l] > 9) return false;
                counter[grid[k][l]]++;
                if (counter[grid[k][l]] > 1) return false;
            }
        }
		return (grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] == 15 &&
				grid[i][j - 1] + grid[i][j + 1] == 10 &&
				grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1] == 15 &&
				grid[i - 1][j - 1] + grid[i][j - 1] + grid[i + 1][j - 1] == 15 &&
				grid[i - 1][j] + grid[i + 1][j] == 10 &&
				grid[i - 1][j + 1] + grid[i][j + 1] + grid[i + 1][j + 1] == 15 &&
				grid[i - 1][j - 1] + grid[i + 1][j + 1] == 10 &&
				grid[i - 1][j + 1] + grid[i + 1][j - 1] == 10
				);
		
	}
	 
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("hello");
		System.out.println(list.get(0) instanceof Object);
	}
}
