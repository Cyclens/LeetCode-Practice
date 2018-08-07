import java.util.*;

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
//		List<Integer> rows = new ArrayList<Integer>();
//		List<Integer> colums = new ArrayList<Integer>();
//		for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix.length; j++) {
//				if (matrix[0][0] == 0) {
//					rows.add(i);
//					colums.add(j);
//				}
//			}
//		}
//		for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix.length; j++) {
//				if (rows.contains(i) || colums.contains(j))
//					matrix[i][j] = 0;
//			}
//		}
		
		int col0 = 1;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) col0 = 0;
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) matrix[i][0] = 0;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 1; j < matrix.length; j++) {
				if (matrix[i][0] == 0) matrix[i][j] = 0;
			}
			if (col0 == 0) matrix[i][0] = 0;
		}
	}
}
