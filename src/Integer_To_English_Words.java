
public class Integer_To_English_Words {
	static String[] twenty = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
			"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	static String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
	static String[] thousands = { "", "Thousand", "Million", "Billion" };

	public static String numberToWords(int num) {
		if (num == 0)
			return "Zero";
		int i = 0;
		String res = "";
		while (num > 0) {
			if (num % 1000 != 0) {
				res = helper(num % 1000) + thousands[i] + " " + res;
			}
			num /= 1000;
			i++;

		}
		return res.trim();
	}

	private static String helper(int num) {
		if (num == 0)
			return "";
		else if (num < 20)
			return twenty[num] + " ";
		else if (num < 100)
			return tens[num / 10] + " " + helper(num % 10);
		else
			return twenty[num / 100] + " Hundred " + helper(num % 100);
	}
	
	public static void main (String[] args) {
		int n = 123456789;
		System.out.println(numberToWords(n));
	}
}
