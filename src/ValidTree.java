import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValidTree {
	public static boolean validTree(int n, int[][] edges) {
        if (n == 1) return edges.length == 0;
        if (edges.length != n - 1) return false;
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		int[] visited = new int[n];
		for (int i = 0; i < edges.length; i++) {
			if (!map.containsKey(edges[i][0])) {
				List<Integer> ary0 = new ArrayList<Integer>();
				ary0.add(edges[i][1]);
				map.put(edges[i][0], ary0);
			}else 
				map.get(edges[i][0]).add(edges[i][1]);
			if (!map.containsKey(edges[i][1])) {
				List<Integer> ary1 = new ArrayList<Integer>();
				ary1.add(edges[i][0]);
				map.put(edges[i][1], ary1);
			}else
				map.get(edges[i][1]).add(edges[i][0]);
		}
        Set<Integer> keyset = new HashSet<Integer>();
		keyset = map.keySet();
		if (n != keyset.size()) return false;
		if (isAcyclic(map, 0, -1, visited)) return false;
		for (int i : visited) if (i == 0) return false;
		return true;
	}
	
	public static boolean isAcyclic(Map<Integer, List<Integer>> map, int v, int pre, int[] visited) {
		visited[v] = 1;
		for (int u : map.get(v)) {
			if (u != pre) {
				if (visited[u] == 1) return true;
				else if (visited[u] == 0) 
					if (isAcyclic(map, u, v, visited)) return true;
			}
		}
		visited[v] = 2;
		return false;
	}
	
	public static boolean validTreeUnionFind(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int i = 0; i < n - 1; i++) {
            int pu = find(parent, edges[i][0]);
            int pv = find(parent, edges[i][1]);
            if (pu == pv)
                return false;
            parent[pu] = pv;
        }
        return true;
    }
        
    public static int find(int[] parent, int r) {
        if (parent[r] == r) return r;
        
        return find(parent, parent[r]);
    }
	
	public static void main(String[] args) {
		int n = 4;
		int[][] edges = new int[][] {{2,3},{1,2},{1,3}};
		boolean res = validTree(n, edges);
		System.out.println(res);
		boolean resUF = validTreeUnionFind(n, edges);
		System.out.println(resUF);
	}
}
