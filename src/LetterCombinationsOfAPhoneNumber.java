import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	public List<String> letterCombinations (String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if (digits.length() == 0) return ans;;
		ans.add("");
		String[] keyboard = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while (ans.peek().length() == i) {
				String a = ans.pop();
				for (char c : keyboard[x].toCharArray()) {
					ans.add(a + c);
				}
			}
		}
		return ans;
	}
	
	
	private static final String[] dict = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	
	public static List<String> LCwDict (String digits) {

		List<String> res = new ArrayList<String>();
		if (digits.length() == 0) return res;
		res.clear();
		
		doCombinations(digits, 0, "", res);
		return res;
	}

	private static void doCombinations(String digits, int index, String str, List<String> res) {
		// TODO Auto-generated method stub
		if (index == digits.length()) {
			res.add(str);
			return;
		}
		
		int x = Character.getNumericValue(digits.charAt(index));
		String currentStr = dict[x];
		for (int i = 0; i < currentStr.length(); i++) {
			doCombinations(digits, index + 1, str + currentStr.charAt(i), res);
		}
		
	}

	public static void main (String[] args) {
		String digits = "";
		List<String> res = new LetterCombinationsOfAPhoneNumber().letterCombinations(digits);
		List<String> resWDict = new LetterCombinationsOfAPhoneNumber().LCwDict(digits);
		List<String> resWDict2 = new LetterCombinationsOfAPhoneNumber().LCwDict("23");
		List<String> resWDict3 = new LetterCombinationsOfAPhoneNumber().LCwDict("98");
		
		
		System.out.println(res.toString());
		System.out.println("Result with Dictionary: " + resWDict.toString());
		System.out.println("Result with Dictionary: " + resWDict2.toString());
		System.out.println("Result with Dictionary: " + resWDict3.toString());
	}
}
