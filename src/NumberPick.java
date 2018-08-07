import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberPick {

	public static List<Integer> pickBoth (int[] A, int[] B) {
		List<Integer> res = new ArrayList<Integer>();
		Set<Integer> setA = new HashSet<Integer>();
		Set<Integer> setB = new HashSet<Integer>();
		for (int a : A) setA.add(a);
		for (int b : B) setB.add(b);
		for (int num : setA) {
			if (setB.contains(num)) res.add(num);
		}
		return res;
	}
	
	public static List<Integer> pickEither (int[] A, int[] B) {
		List<Integer> res = new ArrayList<Integer>();
		Set<Integer> setA = new HashSet<Integer>();
		Set<Integer> setB = new HashSet<Integer>();
		for (int a : A) setA.add(a);
		for (int b : B) setB.add(b);
		for (int num : setA) {
			if (!setB.contains(num)) res.add(num);
		}
		for (int numB : setB) {
			if (!setA.contains(numB)) res.add(numB);
		}
		return res;
	}
}
