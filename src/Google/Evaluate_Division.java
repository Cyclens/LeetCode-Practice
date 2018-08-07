package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Evaluate_Division {

	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		HashMap<String, ArrayList<String>> pairs = new HashMap<String, ArrayList<String>>();
		HashMap<String, ArrayList<Double>> valuePairs = new HashMap<String, ArrayList<Double>>();
		for (int i = 0; i < equations.length; i++) {
			String[] equation = equations[i];
			if (!pairs.containsKey(equation[0])) {
				pairs.put(equation[0], new ArrayList<String>());
				valuePairs.put(equation[0], new ArrayList<Double>());
			}
			if (!pairs.containsKey(equation[1])) {
				pairs.put(equation[1], new ArrayList<String>());
				valuePairs.put(equation[1], new ArrayList<Double>());
			}
			pairs.get(equation[0]).add(equation[1]);
			pairs.get(equation[1]).add(equation[0]);
			valuePairs.get(equation[0]).add(values[i]);
			valuePairs.get(equation[1]).add(1/values[i]);
		}
		double[] res = new double[queries.length];
		for (int i = 0; i < queries.length; i++) {
			String[] query = queries[i];
			res[i] = dfs(query[0], query[1], pairs, valuePairs, new HashSet<String>(), 1.0);
		}
		return res;
	}

	private double dfs(String start, String end, HashMap<String, ArrayList<String>> pairs,
			HashMap<String, ArrayList<Double>> values, HashSet<String> set, double val) {
		if (set.contains(start)) return -1.0;
		if (!pairs.containsKey(start)) return -1.0;
		if (start.equals(end)) return val;
		set.add(start);
		ArrayList<String> strs = pairs.get(start);
		ArrayList<Double> vals = values.get(start);
		double tmp = 0.0;
		for (int i = 0; i < strs.size(); i++) {
			tmp = dfs(strs.get(i), end, pairs, values, set, val * vals.get(i));
		}
		return tmp;
	}
	
	public static void main (String[] args) {
		String[][] equations = {{"a", "b"}, {"b", "c"}};
		double[] values = {2.0, 3.0};
		String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
		double[] res = new Evaluate_Division().calcEquation(equations, values, queries);
		System.out.println(Arrays.toString(res));
		String[][] equations2 = {{"USD", "GBP"}, {"Meter", "Yard"}, {"YEN", "EUR"}, {"GBP", "YEN"}, {"Horsepower", "Watt"}};
		double[] values2 = {0.69, 1.09, 0.0077, 167.75, 745.7};
		String[][] queries2 = {{"USD", "GBP"}, {"Yard", "Meter"}};
		double[] res2 = new Evaluate_Division().calcEquation(equations2, values2, queries2);
		System.out.println(Arrays.toString(res2));
	}
}
