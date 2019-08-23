import java.util.ArrayList;
import java.util.List;

public class Restore_IP_Addresses {
	
	public List<String> restoreIpAddresses(String s) {
		
		List<String> res = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		for (int a = 1; a <= 3; a++)
			for (int b = 1; b <= 3; b++)
				for (int c = 1; c <= 3; c++)
					for (int d = 1; d <= 3; d++) {
						if (a + b + c + d == s.length()) {
							int A = Integer.parseInt(s.substring(0, a));
							int B = Integer.parseInt(s.substring(a, a + b));
							int C = Integer.parseInt(s.substring(a + b, a + b + c));
							int D = Integer.parseInt(s.substring(a + b + c, a + b + c + d));
							if (A <= 255 && B <= 255 && C <= 255 && D <= 255) {
								if (sb.append(A).append(".").append(B).append(".").append(C).append(".").append(D).toString().length() == s.length() + 3) {
									res.add(sb.toString());
								}
								sb = new StringBuilder();
							}
						}
					}
		return res;
	}
}
