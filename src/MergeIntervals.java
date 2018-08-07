import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class MergeIntervals {
	private class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
			return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		LinkedList<Interval> mergedList = new LinkedList<Interval>();
		Collections.sort(intervals, new IntervalComparator());

		for (Interval interval : intervals) {
			if (mergedList.size() == 0 || mergedList.getLast().end < interval.start)
				mergedList.add(interval);

			else {
				mergedList.getLast().end = Math.max(mergedList.getLast().end, interval.end);
			}
		}
		return mergedList;
	}
}
