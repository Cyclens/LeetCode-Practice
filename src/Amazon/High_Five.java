package Amazon;

import java.util.*;
import java.util.Map.Entry;

class Result{
	int id;
	double rate;
	public Result(int id, double rate) {
		this.id = id;
		this.rate = rate;
	}
}

public class High_Five {

	public Map<Integer, Double> highFive(List<Result> results) {
		Map<Integer, PriorityQueue<Double>> ratings = new HashMap<Integer, PriorityQueue<Double>>();
		for (int i = 0; i < results.size(); i++) {
			Result r = results.get(i);
			if (!ratings.containsKey(r.id)) {
				ratings.put(r.id, new PriorityQueue<Double>());
				ratings.get(r.id).add(r.rate);
			}
			else {
				PriorityQueue<Double> pq = ratings.get(r.id);
				if (pq.size() < 5) {
					pq.add(r.rate);
				}
				else if (pq.size() == 5) {
					double least = pq.poll();
					if (r.rate > least)
						pq.add(r.rate);
					else
						pq.add(least);
				}
			}
		}
		Map<Integer, Double> res = new HashMap<Integer, Double>();
		for (int id : ratings.keySet()) {
			double sum = 0.0;
			PriorityQueue<Double> q = ratings.get(id);
			int size = q.size();
			System.out.println(q.size());
			while (!q.isEmpty()) {
				sum = sum + q.poll();
			}
			System.out.println(sum);
			double mean = sum / size;
			res.put(id, mean);
		}
		return res;
	}
	
	public static void main (String[] args) {
		List<Result> input = new ArrayList<Result>();
		input.add(new Result(1, 1));
		input.add(new Result(1, 2));
		input.add(new Result(1, 3));
		input.add(new Result(1, 4));
		input.add(new Result(1, 5));
		input.add(new Result(2, 1));
		input.add(new Result(2, 2));
		input.add(new Result(2, 3));
		input.add(new Result(2, 4));
		input.add(new Result(2, 5));
		input.add(new Result(2, 6));
		High_Five hf = new High_Five();
		Map<Integer, Double> res = hf.highFive(input);
		for (Entry<Integer, Double> entry : res.entrySet()) {
			System.out.println(entry.toString());
		}
	}
}
