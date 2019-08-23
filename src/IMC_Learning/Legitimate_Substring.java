package IMC_Learning;

import java.util.ArrayList;
import java.util.List;

public class Legitimate_Substring {

	public static int maxLength(String input) {
		List<String> list = new ArrayList<String>();
		int i = 0;
		while (i < input.length()) {
			if (Character.isDigit(input.charAt(i))) {
				i++;
				continue;
			} else {
				int j = i;
				while (j < input.length() - 1 && !Character.isDigit(input.charAt(j))) {
					j++;
				}
				//System.out.println("i = " + i);
				//System.out.println("j = " + j);
				list.add(input.substring(i, j + 1));
				i = j + 1;
			}
		}
		int len = 0;
		for (String s : list) {
			boolean hasUpper = false;
			for (char c : s.toCharArray()) {
				if (Character.isUpperCase(c))
					hasUpper = true;
			}
			if (hasUpper) {
				len = Math.max(len, s.length());
			}
		}
		return len;
	}

	public static void main(String[] args) {
		String input = "afwefawefawefawefc1245Afaewfawefawe";
		//System.out.println(input.substring(0, 2));
		int maxlen = maxLength(input);
		System.out.println(maxlen);
	}
}
