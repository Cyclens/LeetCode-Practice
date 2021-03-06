import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ZigzagIterator {
	LinkedList<Iterator> list;
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		list = new LinkedList<Iterator>();
		if (!v1.isEmpty()) list.add(v1.iterator());
		if (!v2.isEmpty()) list.add(v2.iterator());
	}

	public int next() {
		Iterator iter = list.remove();
		int res = (Integer) iter.next();
		if (iter.hasNext()) list.add(iter);
		return res;
	}

	public boolean hasNext() {
		return !list.isEmpty();
	}
}