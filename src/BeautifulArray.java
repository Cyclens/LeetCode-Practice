import java.util.ArrayList;
import java.util.HashMap;

public class BeautifulArray {
    public int[] beautifulArray(int N) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < N) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i : res) if (i * 2 - 1 <= N) tmp.add(i * 2 - 1);
            for (int i : res) if (i * 2 <= N) tmp.add(i * 2);
            res = tmp;
            System.out.println(res.toString());
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
    
    
    
}

class Solution {
    HashMap<Integer, int[]> map;
    public int[] dfs(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int[] res = new int[n];
        if (n == 1) {
            res[0] = 1;
        } else {
            int idx = 0;
            int[] temp = dfs((n + 1) / 2) ;
            for (int x: temp) {
                res[idx++] = 2 * x - 1; 
            }
            int[] temp1 = dfs(n / 2);
            for (int x: temp1) {
                res[idx++] = 2 * x;
            }
        }
        map.put(n, res);
        return res;
    }
    
    public int[] beautifulArray(int N) {
        map = new HashMap<>();
        return dfs(N);
    }
}
