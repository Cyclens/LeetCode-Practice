
public class ReadNCharactersGivenRead4 extends Reader4{
	
	
	public int read(char[] buf, int n) {
		boolean end = false; // end of file flag
		int total = 0; // total bytes have read
		char[] tmp = new char[4]; // temp buffer

		while (!end && total < n) {
			int count = read4(tmp);

			// check if it's the end of the file
			end = count < 4;

			// get the actual count
			count = Math.min(count, n - total);

			// copy from temp buffer to buf
			for (int i = 0; i < count; i++)
				buf[total++] = tmp[i];
		}

		return total;
	}
}
