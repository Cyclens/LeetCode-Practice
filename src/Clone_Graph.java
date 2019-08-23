import java.util.*;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

public class Clone_Graph {

	Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		return dfs(node);

	}

	private UndirectedGraphNode dfs(UndirectedGraphNode node) {
		// TODO Auto-generated method stub
		if (node == null)
			return null;
		if (!map.containsKey(node.label)) {
			UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
			map.put(clone.label, clone);
			for (UndirectedGraphNode ngbr : node.neighbors) {
				clone.neighbors.add(dfs(ngbr));
			}
			return clone;
		}else {
			return map.get(node.label);
		}

	}
}
