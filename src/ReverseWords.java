import java.util.Scanner;

public class ReverseWords {
	public static void main(String[] args) {
		String a = "welcome to the show!";
		String b = reverseWords(a);
		System.out.println(b);
		String c = reverseWords1(a);
		System.out.println(c);
	}
	
	public static String reverseWords(String s) {
		Scanner parts = new Scanner(s);
		String res = "";
		while (parts.hasNext()) {
			res = parts.next() + " " + res;
		}
		return res.trim();
	}
	
	public static String reverseWords1(String s) {
		String[] temp = s.split(" ");
		StringBuilder sb = new StringBuilder();
		System.out.println(temp.length);
		
		for (int i = 1; i <= temp.length; i++) {
			if(temp[temp.length -  i].equals("")) {
				continue;
			}
			
			sb.append(temp[temp.length - i]);
			sb.append(" ");
		}
		
		return sb.toString().trim();
	}
}
