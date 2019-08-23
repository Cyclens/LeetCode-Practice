import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Interval {
		int start;
		int end;
		Interval() {start = 0; end = 0;}
		Interval(int s, int e) {start = s; end = e;}
	}
public class Meeting_Rooms_II {
	
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) return 0;
		
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		
		PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.end - b.end;
			}
		});
		pq.offer(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			Interval currInterval = pq.poll();
			if (intervals[i].start >= currInterval.end) {
				currInterval.end = intervals[i].end;
			}else {
				pq.offer(intervals[i]);
			}
			pq.offer(currInterval);
		}
		return pq.size();
	}
	
}
