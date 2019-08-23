import java.util.Arrays;

public class String_to_Integer_atoi {

	
	public static int myAtoi(String str) {
		int res = 0, symbol = 1, i = 0;
		if (str.length() == 0 || str == null || str.trim().length() == 0) {
			return 0;
		}
		while (str.charAt(i) == ' ') {
			i++;
		}
		if (str.charAt(i) == '+') {
			i++;
		}else if (str.charAt(i) == '-') {
			symbol = -1;
			i++;
		}
		
		while (i < str.length()) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9')
				break;
			int d = str.charAt(i) - '0';
			if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < d)) {
				return symbol == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			res = res * 10 + d;
			i++;
		}
		
		return res * symbol;
		
	}
	
	public static void main (String[] args) {
		String str = "42";
		//System.out.println(Arrays.toString(str.trim().split(" ")));
		System.out.println(myAtoi(str));
	}
}
