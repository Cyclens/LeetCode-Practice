package Google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Obj{
	int x;
	int y;
	boolean visited;
	public Obj (int x, int y){
		this.x = x;
		this.y = y;
		visited = false;
	}
}

class pair{
	Obj P;
	Obj B;
	int dist;
	public pair(Obj p, Obj b) {
		this.P = p;
		this.B = b;
		this.dist = Math.abs(p.x - b.x) + Math.abs(p.y - b.y);
	}
}
public class Bike_Match {

	public static List<pair> minDist(char[][] pos) {
		List<pair> res = new ArrayList<pair>();
		int n = pos.length;
		if (n == 0) return res;
		int m = pos[0].length;
		if (m == 0) return res;
		List<Obj> Persons = new ArrayList<Obj>();
		List<Obj> Bikes = new ArrayList<Obj>();
		List<pair> pairs = new ArrayList<pair>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (pos[i][j] == 'P') Persons.add(new Obj(i, j));
				else if (pos[i][j] == 'B') Bikes.add(new Obj(i, j));
			}
		}
		for (Obj p : Persons) {
			for (Obj b : Bikes) {
				pairs.add(new pair(p, b));
			}
		}
		Collections.sort(res, new Comparator<pair>() {
			public int compare(pair p1, pair p2) {
				return p1.dist - p2.dist;
			}
		});
		for (pair p : pairs) {
			if (p.P.visited == false && p.B.visited == false) {
				res.add(p);
				p.P.visited = true;
				p.B.visited = true;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		char[][] pos = new char[][] {{'P', '0', 'B', '0'}, {'0','P','0','B'},{'0','B','0','P'},{'B','0','P','0'}};
		List<pair> res = minDist(pos);
		for (pair p : res) System.out.println(p.dist);
	}
}
