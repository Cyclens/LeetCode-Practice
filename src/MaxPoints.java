import java.util.*;

class Point {
	int x;
	int y;

	Point () {
		x = 0;
		y = 0;
	}
	
	Point (int a, int b) {
		x = a;
		y = b;
	}
}

public class MaxPoints {
	public static int maxPoints(Point[] points) {
		if (points == null) return 0;
		if (points.length <= 2) return points.length;
		int count = 0;
		for (int i = 0; i < points.length - 1; i++) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			int samex = 1;
			int samey = 1;
			for (int j = i + 1; j < points.length; j++) {
				if (j != i) {
					if (points[j].x == points[i].x)
						samex++;
					if (points[j].y == points[j].x)
						samey++;
				}
				int diffy = points[i].y - points[j].y;
				int diffx = points[i].x - points[j].x;
				int gcd = genGCD(diffy, diffx);
				String slope = diffy / gcd + "&&" + diffx / gcd;
				if (map.containsKey(slope)) {
					map.put(slope, map.get(slope) + 1);
				}else {
					map.put(slope, 1);
				}
				count = Math.max(count, map.get(slope));
			}
			count = Math.max(count, Math.max(samex, samey));
		
		}
		return count;
	}
	
	public static int genGCD (int a, int b) {
		if (a == 0) return b;
		else return genGCD(b % a, a);
	}
	
	public static void main (String args[]) {
		//Point[] p = new Point[3];
		//p[0].x = p[2].x = p[0].y = p[2].y = 0;
		//p[1].x = p[1].y = 1;
		//int maxp = maxPoints(p);
		//System.out.println(maxp);
		int a = 0, b = 0;
		System.out.println(genGCD(a, b));
	}
}
