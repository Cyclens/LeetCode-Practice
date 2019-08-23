
public class Word_Search {

	public boolean exist(char[][] board, String word) {
		char[] w = word.toCharArray();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (exists(board, i, j, w, 0)) return true;
			}
		}
		return false;
	}

	private boolean exists(char[][] board, int i, int j, char[] w, int k) {
		// TODO Auto-generated method stub
		if (k == w.length) return true;
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != w[k]) return false;
		board[i][j] = '@';
		boolean exist = exists(board, i, j + 1, w, k + 1) ||
					exists(board, i + 1, j, w, k + 1) ||
					exists(board, i - 1, j , w, k + 1) ||
					exists(board, i, j - 1, w, k + 1);
		board[i][j] = w[k];
		return exist;
		
	}
}
