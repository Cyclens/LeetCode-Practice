
public class Pow {
	public double myPow(double x, int n) {
		if (n == 0) return 1.0;
		if (n == Integer.MIN_VALUE) {
			x = x * x;
			n /= 2;
		}
		if (n < 0) {
			n = -n;
			x = 1.0 / x;
		}

		return (n % 2) == 0? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}
	
	public static void main (String[] args) {
		double x = 2.0;
		int n = -2147483648;
		System.out.println(new Pow().myPow(x, n));
	}
}
