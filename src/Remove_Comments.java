import java.util.ArrayList;
import java.util.List;

public class Remove_Comments {

	public List<String> removeComments(String[] source) {
		List<String> res = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		boolean cmt = false;
		for (String s : source) {
			for (int i = 0; i < s.length(); i++) {
				if (cmt) {
					if (s.charAt(i) == '*' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
						cmt = false;
						i++;
					}
				}
				else {
					if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
						break;
					}
					else if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '*') {
						cmt = true;
						i++;
					}
					else sb.append(s.charAt(i));
				}
			}
			if (!cmt && sb.length() > 0) {
				res.add(sb.toString());
				sb = new StringBuilder();
			}
		}
		return res;
	}
	
}
