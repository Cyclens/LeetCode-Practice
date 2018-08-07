import java.util.*;

public class PriorityQ {
	public static void main(String args[]) {
		PriorityQueue<Integer> PriorityQ = new PriorityQueue<Integer>(5, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				//System.out.println(o2);
				return o1 - o2;
			}
		});
		
		PriorityQ.add(1);
		PriorityQ.add(2);
		PriorityQ.add(3);
		PriorityQ.add(4);
		PriorityQ.add(5);
		PriorityQ.add(6);
		for (int i = 0; i < PriorityQ.size(); i++) {
			System.out.println(PriorityQ.);
		}

	}

}
