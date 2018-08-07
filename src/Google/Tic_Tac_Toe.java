package Google;

import java.util.Arrays;

public class Tic_Tac_Toe {
	int[][] board;
	int[] sumrows;
	int[] sumcols;
	int[] sumcross;
	int size;
	public Tic_Tac_Toe(int n) {
		size = n;
		board = new int[n][n];
		sumrows = new int[n];
		sumcols = new int[n];
		sumcross = new int[2];
	}
	
	public int move (int row, int col, int player) {
		int increment = 0;
		if (player == 1)
			increment = 1;
		else
			increment = -1;
		board[row][col] = increment;
		updatesums(row, col, increment);
//		for (int r : sumrows) {
//			if (r == size)
//				winnder = 1;
//			else if (-r == size)
//				winnder = 2;
//		}
//		for (int cols : sumcols) {
//			if (cols == size)
//				winnder = 1;
//			else if (-cols == size)
//				winnder = 2;
//		}
		for (int c : sumcross) {
			if (c == size)
				return 1;
			else if (-c == size)
				return 2;
		}
		if (sumrows[row] == size)
			return 1;
		else if (sumrows[row] == -size)
			return 2;
		else if (sumcols[col] == size)
			return 1;
		else if (sumcols[col] == -size)
			return 2;
		return 0;
	}

	private void updatesums(int row, int col, int increment) {
		sumcols[col] += increment;
		sumrows[row] += increment;
		if (row == col)
			sumcross[0] += increment;
		if (row + col == size - 1)
			sumcross[1] += increment;
	}
	
	public static void main (String[] args) {
//		Tic_Tac_Toe ttt = new Tic_Tac_Toe(3);
//		int r1 = ttt.move(0, 0, 1);
//		System.out.println(Arrays.deepToString(ttt.board));
//		int r2 = ttt.move(0, 2, 2);
//		System.out.println(Arrays.deepToString(ttt.board));
//		int r3 = ttt.move(2 ,2, 1);
//		System.out.println(Arrays.deepToString(ttt.board));
//		int r4 = ttt.move(1, 1, 2);
//		System.out.println(Arrays.deepToString(ttt.board));
//		int r5 = ttt.move(2, 0, 1);
//		System.out.println(Arrays.deepToString(ttt.board));
//		int r6 = ttt.move(1, 0, 2);
//		System.out.println(Arrays.deepToString(ttt.board));
//		int r7 = ttt.move(2, 1, 1);
//		System.out.println(Arrays.deepToString(ttt.board));
//		System.out.println(r7);
		
		Tic_Tac_Toe ttt2 = new Tic_Tac_Toe(2);
		int rr1 = ttt2.move(0, 1, 2);
		int rr2 = ttt2.move(1, 0, 1);
		int rr3 = ttt2.move(1, 1, 2);
		System.out.println(Arrays.deepToString(ttt2.board));
		System.out.println(rr1);
		System.out.println(rr2);
		System.out.println(rr3);
	}
}
