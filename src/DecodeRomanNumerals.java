import java.util.*;

public class DecodeRomanNumerals {
	public static int RomanDecode(String s) {
		System.out.println(s);
		if (s.length() == 0) return 0;
		s = s.replace(" ", "");
		Map<Character, Integer> dic = new HashMap<Character, Integer>();
		dic.put('M', 1000);
		dic.put('D', 500);
		dic.put('C', 100);
		dic.put('L', 50);
		dic.put('X', 10);
		dic.put('V', 5);
		dic.put('I', 1);
		if (s.length() == 1) return dic.get(s.charAt(0));
		int res = dic.get(s.charAt(0));
		int curCount = 1;
		for (int i = 1; i < s.length(); i++) {
			//System.out.println(i);
			res += dic.get(s.charAt(i));
			if (s.charAt(i) == s.charAt(i - 1)) {
				curCount += 1;
			}
			else {
				if (dic.get(s.charAt(i - 1)) < dic.get(s.charAt(i))) {
					
					res -= dic.get(s.charAt(i - 1)) * 2 * curCount;
					//System.out.println(res);
				}
				
				curCount = 1;
			}
			//System.out.println(curCount);
			
		}
		return res;
	}

	public static void main(String[] args) {
		String[] input = new String[] { "I", "III", "VI", "VIII", "III X", "VVVX",
				"MCMLXXII", "MCMXXXCII", "CCCXLV", "MDCLXVI"};
		for (int i = 0; i < input.length; i++) {
			System.out.println(RomanDecode(input[i]));
		}
		//System.out.println(RomanDecode("III X"));
		
	}
}
