import java.util.*;

public class CombinationSumII {

	public List<List<Integer>> combinationSum2(int[] cand, int target) {
		Arrays.sort(cand);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> combs = new ArrayList<Integer>();
		dfs(cand, 0, target, combs, res);
		return res;
	}

	public void dfs(int[] cand, int cur, int target, List<Integer> combs, List<List<Integer>> res) {
		// TODO Auto-generated method stub
		if (target == 0) {
			res.add(new ArrayList(combs));
			return;
		}
		if (target < 0)
			return;

		for (int i = cur; i < cand.length; i++) {
			if (i > cur && cand[i] == cand[i - 1])
				continue;
			combs.add(combs.size(), cand[i]);
			dfs(cand, i + 1, target - cand[i], combs, res);
			combs.remove(combs.size() - 1);
		}
	}

	public static void main(String args[]) {
		int[] cand = new int[7];
		cand = new int[] {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res = new CombinationSumII().combinationSum2(cand, target);
		System.out.println(res);
	}
}
