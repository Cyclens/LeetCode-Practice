import java.util.Arrays;

public class PrimeNumbersDivision {
	public static void numbers (int tgt, boolean prime[]) {
		prime[0] = prime[1] = false;
		for (int i = 0; i < prime.length; i++) {
			prime[i] = true;
		}
		for (int j = 2; j * j <= tgt; j++) {
			if (prime[j]) {
				for (int i = j * 2; j <= tgt; j += i) {
					prime[j] = false;
				}
			}
		}
	}
	
	public static int[] primeDivision (int tgt) {
		boolean prime[] = new boolean[tgt + 1];
		numbers(tgt, prime);
		int[] res = new int[2];
		for (int i = 0; i < tgt; i++) {
			if (prime[i] && prime[tgt - i]) {
				res[0] = i;
				res[1] = tgt - i;
			}
		}
		return res;
	}
	public static void main (String[] args)
    {
        int n = 74;
        int[] res = primeDivision(n);
        System.out.println(Arrays.toString(res));
    }
}
