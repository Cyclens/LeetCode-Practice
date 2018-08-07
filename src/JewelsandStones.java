import java.util.HashSet;
import java.util.Set;

public class JewelsandStones {
	public static int numJewelsInStones(String J, String S) {
		int count = 0;
		
		for (String s : S.split("")) {
			if (J.contains(s)) {
				count ++;
			}
		}
		return count;
	}
	
	public static void main (String args[]) {
		String Jewels = "aA";
		String Stones = "aAAbbbb";
		int c = numJewelsInStones(Jewels, Stones);
		System.out.println(c);
	}
}
