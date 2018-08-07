package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Division_Handling {

	public static double[] calcDivisions(String[][] equations, double[] values, String[][] queries) {
		HashMap<String, ArrayList<String>> pairs = new HashMap<String, ArrayList<String>>();
		HashMap<String, ArrayList<Double>> vals = new HashMap<String, ArrayList<Double>>();
		double[] res = new double[queries.length];
		for (int i = 0; i < equations.length; i++) {
			String[] equation = equations[i];
			if (!pairs.containsKey(equation[0])) {
				pairs.put(equation[0], new ArrayList<String>());
				vals.put(equation[0], new ArrayList<Double>());
			}
			if (!pairs.containsKey(equation[1])) {
				pairs.put(equation[1], new ArrayList<String>());
				vals.put(equation[1], new ArrayList<Double>());
			}
			pairs.get(equation[0]).add(equation[1]);
			pairs.get(equation[1]).add(equation[0]);
			vals.get(equation[0]).add(values[i]);
			vals.get(equation[1]).add(1/values[i]);
		}
		for (int i = 0; i < queries.length; i++) {
			String[] query = queries[i];
			res[i] = dfs(query[0], query[1], pairs, vals, new HashSet<String>(), 1.0);
		}
		return res;
	}
	
	private static double dfs(String start, String end, HashMap<String, ArrayList<String>> pairs,
			HashMap<String, ArrayList<Double>> vals, HashSet<String> path, double val) {
		if (path.contains(start)) return -1.0;
		if (!pairs.containsKey(start)) return -1.0;
		if (start.equals(end)) return val;
		path.add(start);
		double temp = 0.0;
		ArrayList<String> strs = pairs.get(start);
		ArrayList<Double> values = vals.get(start);
		for (int i = 0; i < path.size(); i++) {
			temp = dfs(strs.get(i), end, pairs, vals, path, val*values.get(i));
		}
		return temp;
	}


	
	public static void main (String[] args) {
		String[][] equations = {{"USD", "GBP"}, {"Meter", "Yard"}, {"YEN", "EUR"}, {"GBP", "YEN"}, {"Horsepower", "Watt"}};
		double[] values = {0.69, 1.09, 0.0077, 167.75, 745.7};
		String[][] queries = {{"USD", "GBP"}, {"Yard", "Meter"}};
		double[] res = calcDivisions(equations, values, queries);
		System.out.println(Arrays.toString(res));
	}
}
