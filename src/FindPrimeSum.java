
public class FindPrimeSum {

	public static int[] findPrime(int n) {
		int[] res = new int[] {0, 0};
		for (int i = 1; i <= n / 2; i++) {
			if (isPrime(i) && isPrime(n - i)) {
				res[0] = i;
				res[1] = n -i;
			}
		}
		return res;
		
	}
	
	public static boolean isPrime(int n) {
		if (n < 2) return false;
		if (n == 2) return true;
		if (n % 2 == 0) return false;
		for (int i = 3; i <= Math.sqrt(n); i+=2) {
			if (n % i == 0) return false; 
		}
		return true;
	}
}
