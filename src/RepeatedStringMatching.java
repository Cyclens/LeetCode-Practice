
public class RepeatedStringMatching {
	public int repeatedStringMatch(String A, String B) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < B.length()) {
        		sb.append(A);
        		count++;
        }
        if (sb.toString().contains(B)) return count;
        if (sb.append(A).toString().contains(B)) return ++count;
        return -1;
    }
	
	public static void mian (String[] args) {
		String A = "abcd";
		String B = "cdabcdab";
		int res = new RepeatedStringMatching().repeatedStringMatch(A, B);
		System.out.println(res);
	}
}
