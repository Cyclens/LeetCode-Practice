
public class Reverse_Algebraic_Expression {

	public String reverseExpression(String input) {
		StringBuilder sb = new StringBuilder();
		for(int i = input.length() - 1; i >= 0; i--) {
			sb.append(input.charAt(i));
		}
		return sb.toString();
		
	}
	public static void main (String args) {
		String input = "1*2.4+9.6-23.89";
		String output = new Reverse_Algebraic_Expression().reverseExpression(input);
		System.out.println(output);
	}
}
