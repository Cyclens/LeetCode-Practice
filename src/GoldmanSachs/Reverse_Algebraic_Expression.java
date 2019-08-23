package GoldmanSachs;

import java.util.HashSet;
import java.util.Set;

public class Reverse_Algebraic_Expression {

	public String reverseExpression(String input) {
		StringBuilder sb = new StringBuilder();
		for(int i = input.length() - 1; i >= 0; i--) {
			sb.append(input.charAt(i));
		}
		Set<Character> ops = new HashSet<Character>();
		ops.add('+');
		ops.add('-');
		ops.add('*');
		ops.add('/');
		System.out.println(sb.toString());
		//System.out.println(sb.charAt(5));
		StringBuilder res = new StringBuilder();
		int i = 0;
		while (i < sb.length()) {
			StringBuilder num = new StringBuilder();
			int j = i;
			while (j < sb.length() && (sb.charAt(j) == '.' || Character.isDigit(sb.charAt(j)))) {
				j++;
			}
			
			if ((j <= sb.length() - 2 && sb.charAt(j) == '-' && ops.contains(sb.charAt(j + 1)))|| j == sb.length() - 1 && sb.charAt(j) == '-') {
				//System.out.println(123);
				res.append('-');
				num.append(sb.subSequence(i,  j));
				num.reverse();
				res.append(num);
			}
			else if (j <= sb.length() - 2 && ops.contains(sb.charAt(j))) {
				num.append(sb.subSequence(i,  j));
				num.reverse();
				res.append(num);
				res.append(sb.charAt(j));
			}
			else {
				num.append(sb.subSequence(i,  j));
				num.reverse();
				res.append(num);
			}
			if (j == sb.length() - 1) break;
			i = j + 1;
		}
			
		
		return res.toString();
		
	}
	public static void main (String[] args) {
		String input = "-2";
		String output = new Reverse_Algebraic_Expression().reverseExpression(input);
		System.out.println(output);
	}
}