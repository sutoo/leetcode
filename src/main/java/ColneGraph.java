import java.util.*;

/**
 * Created by sutao on 14/11/20.
 */
public class ColneGraph {

    /**
     * Definition for undirected graph.
     * class UndirectedGraphNode {
     * int label;
     * List<UndirectedGraphNode> neighbors;
     * UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
     * };
     */


    private UndirectedGraphNode cloneGraphInner(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {

        UndirectedGraphNode targetNode = map.get(node.label);
        if (targetNode == null) {
            targetNode = new UndirectedGraphNode(node.label);
            map.put(node.label, targetNode);
            targetNode.neighbors = new ArrayList<UndirectedGraphNode>();
            for (UndirectedGraphNode neihbor : node.neighbors) {
                targetNode.neighbors.add(cloneGraphInner(neihbor, map));
            }
        }

        return targetNode;

    }


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<Integer, UndirectedGraphNode> buf = new HashMap<Integer, UndirectedGraphNode>();
        return cloneGraphInner(node, buf);

    }


    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}
