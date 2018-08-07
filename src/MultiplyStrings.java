
public class MultiplyStrings {

	public String multiply(String num1, String num2) {
		int l1 = num1.length(), l2 = num2.length();
		int[] res = new int[l1 + l2];
		
		for (int i = l1 - 1; i >= 0; i--) {
			for (int j = l2 - 1; j >= 0; j--) {
				int mult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int start = i + j, end = i + j + 1;
				int sum = mult + res[end];
				
				res[start] += sum / 10;
				res[end] = sum % 10;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int d : res) {
			if (!(sb.length() == 0 && d == 0)) sb.append(d);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}

	public static void main(String[] args) {
		String num1 = "123";
		String num2 = "456";
		String res = new MultiplyStrings().multiply(num1, num2);
		System.out.println(res);
	}

}
