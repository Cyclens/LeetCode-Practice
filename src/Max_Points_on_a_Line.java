import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class Max_Points_on_a_Line {

	public int maxPoints(Point[] points) {
		
		if (points.length < 3) return points.length;
		int res = 0;

		for (int i = 0; i < points.length - 1; i++) {
			Map<String, Integer> map = new HashMap<>();

			int overlap = 0;
			int lineres = 0;
			for (int j = i + 1; j < points.length; j++) {
				// System.out.println(i + " " + j);
				Point a = points[i];
				Point b = points[j];
				int detY = b.y - a.y;
				int detX = b.x - a.x;
				int gcd = GCD(detX, detY);
				if (gcd != 0) {
					detY /= gcd;
					detX /= gcd;
				}
				if (detX == 0 && detY == 0) {
					overlap++;
					continue;
				}
				String slp = detX + "/" + detY;
				map.put(slp, map.getOrDefault(slp, 0) + 1);
				lineres = Math.max(lineres, map.get(slp));
				System.out.println(lineres);
			}
			res = Math.max(lineres + overlap + 1, res);
		}
		return res;
	}

	public int GCD(int a, int b) {
		if (b == 0)
			return a;
		else
			return GCD(b, a % b);
	}

	public static void main(String[] args) {
		Point[] points = { new Point(1, 1),new Point(1, 1),new Point(1, 1) };
		System.out.println(new Max_Points_on_a_Line().maxPoints(points));
	}
}
