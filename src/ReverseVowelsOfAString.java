import java.util.Arrays;
import java.util.List;

public class ReverseVowelsOfAString {
	public String reverseVowels(String s) {
		if (s.length() <= 1) return s;
		int i = 0, j = s.length() - 1;
		Character[] vowel = new Character[] {'A','a','E','e','I','i','O','o','U','u'};
		List<Character> vowels = Arrays.asList(vowel);
		char[] chars = s.toCharArray();
		while (i < j && i <= s.length() && j >= 0) {
			if (!vowels.contains(chars[i])) {
				i++;
				continue;
			}
			if (!vowels.contains(chars[j])) {
				j--;
				continue;
			}
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
			i++;
			j--;
		}
		return String.valueOf(chars);
	}
	
	public static void main (String[] args) {
		String s = "eoAO";
		String res = new ReverseVowelsOfAString().reverseVowels(s);
		System.out.println(res);
	}
}
