import java.util.HashSet;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			HashSet<Character> rows = new HashSet<Character>();
			HashSet<Character> colums = new HashSet<Character>();
			HashSet<Character> boxes = new HashSet<Character>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !rows.add(board[i][j]))
					return false;
				if (board[i][j] != '.' && !colums.add(board[i][j]))
					return false;
				int rowIndex = 3 * (j / 3);
				int columnIndex = 3 * (j % 3);
				if (board[rowIndex + (i / 3)][columnIndex + (i % 3)] != '.'
						&& !boxes.add(board[rowIndex + (i / 3)][columnIndex + (i % 3)]))
					return false;

			}
		}
		return true;
	}
	public char board1[][];
	public Board() {
		board1 = new char[9][9];
		board1 = [[".",".","4",".",".",".","6","3","."],[".",".",".",".",".",".",".",".","."],["5",".",".",".",".",".",".","9","."],[".",".",".","5","6",".",".",".","."],["4",".","3",".",".",".",".",".","1"],[".",".",".","7",".",".",".",".","."],[".",".",".","5",".",".",".",".","."],[".",".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".",".","."]];
	}
	
	public static void main(String[] args) {

	}

}
