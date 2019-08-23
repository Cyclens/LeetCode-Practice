
public class Valid_Number {

	public boolean isNumber(String s) {
		s = s.trim();
		if (s.length() == 0 || s == null) return false;
		boolean dot = false;
		boolean e = false;
		boolean afterE = true;
		boolean number = false;
		for (int i = 0; i < s.length(); i++) {
			if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
				number = true;
				afterE = true;
			}
			else if (s.charAt(i) == '.') {
				if (e || dot)
					return false;
				dot = true;
			}else if (s.charAt(i) == 'e') {
				if (e || !number)
					return false;
				e = true;
				afterE = false;
			}else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
				if (i != 0 && s.charAt(i - 1) != 'e')
					return false;
			}else 
				return false;
		}
		return number && afterE;
	}
}
