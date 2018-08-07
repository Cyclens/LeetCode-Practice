
public class SquareFreeNumber {

	public static boolean isSquareFree(int n) {
		if (n % 2 == 0)
			n /= 2;
		if (n % 2 == 0)
			return false;

		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0) {
				n /= i;
				if (n % i == 0)
					return false;
			}
		}
		return true;
	}

	public static void primeFactors(int n) {
		while (n % 2 == 0) {
			System.out.print(2 + " ");
			n /= 2;
		}

		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				System.out.print(i + " ");
				n /= i;
			}
		}
		if (n > 2)
			System.out.print(n);
	}

	public static void main(String[] args) {
		int n = 15769;
		primeFactors(n);
		boolean res = isSquareFree(n);
		System.out.println(res);
		
	}
}
