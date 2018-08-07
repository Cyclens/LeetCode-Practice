import java.util.Arrays;

public class KEmptySlotsLastDay {
	public int solution(int[] A, int K, int M) {
        // write your code in Java SE 8
        int len = A.length;
        int latest = -2;
		int[] root = new int[len];
		int[] length = new int[len];
		Arrays.fill(root, -1);
		Arrays.fill(length, 0);
		int count = 0;
        
		for (int i = 0; i < len; i++) {
			int curr = A[i] - 1;
			root[curr] = curr;
			length[curr] = 1;
            
			if (curr + 1 < len && root[curr + 1] > -1) {
				if (length[curr + 1] >= K) count--;
				root[curr + 1] = curr;
				length[curr] += length[curr + 1];
			}
            
			if (curr - 1 > -1 && root[curr - 1] > -1) {
				root[curr] = findRoot(root, curr - 1);
				length[root[curr]] += length[curr];
				if (length[root[curr]] >= K && length[root[curr]] - length[curr] < K) count++;
			} 
            else if (length[curr] >= K) count++;
			
            if (count == M) latest = i;
		}
        
		return latest + 1;
	}

	public int findRoot(int[] root, int n) {
		while (root[n] != n) {
			root[n] = root[root[n]];
			n = root[n];
		}
        
		return n;
	}
}