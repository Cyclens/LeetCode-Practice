import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
    
    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] candidates, int remain, int start){
        if (remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < candidates.length; i++){
                tempList.add(candidates[i]);
                backtrack(list, tempList, candidates, remain - candidates[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    
    public static void main(String args[]) {
    		int [] tt = new int[4];
    		tt[0] = 2;
    		tt[1] = 3;
    		tt[2] = 7;
    		tt[3] = 4;
    		List<List<Integer>> l1 = new ArrayList<>();
    		l1 = combinationSum(tt, 7);
    		System.out.println(l1  );
    }
}