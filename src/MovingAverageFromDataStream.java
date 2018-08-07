import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {
	Queue<Integer> q;
	int size;
	int sum = 0;
    public MovingAverageFromDataStream(int size) {
        q = new LinkedList<Integer>();
        this.size = size;
    }
    
    public double next(int val) {
        while (q.size() >= size) sum-= q.poll();
        q.offer(val);
        sum += val;
        
        return sum / q.size();
    }
}
