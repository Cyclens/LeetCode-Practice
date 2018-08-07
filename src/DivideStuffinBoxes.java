
public class DivideStuffinBoxes {
	
	public static boolean divide (int n) {
		if (n == 0) return true;
		while (n >= 0) {
			if ( n % 3 == 0 && n / 3 >1) return true;
			n -= 20;
		}
		return false;
	}
	
	public static void main (String[] args) {
		int n = 1892456;
		boolean res = divide(n);
		System.out.println(res);
	}
}
