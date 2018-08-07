
public class UTF8Validation {
	public boolean validUtf8(int[] data) {
		int count = 0;
		for (int bin : data) {
			if (count == 0) {
				if ((bin >> 5) == 0b110) count = 1;
				else if ((bin >> 4) == 0b1110) count = 2;
				else if ((bin >> 3) == 0b11110) count = 3;
				else if ((bin >> 7) != 0) return false;
			}
			else {
				if ((bin >> 6) != 0b10) return false;
				else count--;
			}
			//System.out.println(count);

		}
		return count == 0;
	}

	public static void main(String[] args) {
		int[] data = new int[] {197, 130, 1};
		boolean res = new UTF8Validation().validUtf8(data);
		System.out.println(res);
	}
}
