
public class SentenceScreenFitting {

	public int wordsTyping(String[] sentence, int rows, int cols) {
		String s = String.join(" ", sentence) +  " ";
		int start = 0, l = s.length();
		for (int i = 0; i < rows; i++) {
			start += cols;
			if (s.charAt(start % l) == ' ') {
				start++;
			}
			else {
				while (start > 0 && s.charAt((start - 1) % l) != ' ') {
					start--;
				}
			}
			
		}
		return start / s.length();
	}
	
	public static void main (String[] args) {
		String[] sentence = new String[] {"hello", "world"};
		int rows = 8, cols = 2;
		int res = new SentenceScreenFitting().wordsTyping(sentence, rows, cols);
		System.out.println(res);
	}
}
