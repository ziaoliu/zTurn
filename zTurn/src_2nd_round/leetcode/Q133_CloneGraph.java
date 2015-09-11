package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 OJ's undirected graph serialization:
 Nodes are labeled uniquely.

 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:

 *       1
 *      / \
 *     /   \
 *    0 --- 2
 *         / \
 *         \_/

 Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };

 http://blog.csdn.net/linhuanmars/article/details/22715747
 */
public class Q133_CloneGraph {
	public static void main(String[] args) {
		List<UndirectedGraphNode> list = new ArrayList<UndirectedGraphNode>();
		UndirectedGraphNode a = new UndirectedGraphNode(1);
		a.neighbors = null;
		list.add(a);
		UndirectedGraphNode aa = new UndirectedGraphNode(1);
		aa.neighbors = null;
		System.out.println(list.contains(aa));
	}

	public class Solution {
		public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
			if (node == null)
				return node;
			LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
			queue.add(node);
			HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
			UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
			map.put(node, clone);
			while (queue.size() > 0) {
				UndirectedGraphNode cur = queue.remove(0);
				if (cur.neighbors.size() > 0)
					for (UndirectedGraphNode inCurList : cur.neighbors) {
						// eliminate cycle - cycle check
						if (!map.containsKey(inCurList)) {
							clone = new UndirectedGraphNode(inCurList.label);
							map.put(inCurList, clone);
							queue.add(inCurList);
						}
						map.get(cur).neighbors.add(map.get(inCurList));
					}
			}
			return map.get(node);
		}

		private boolean cycleCheck(List<UndirectedGraphNode> neighbors,
				UndirectedGraphNode node) {
			for (UndirectedGraphNode temp : neighbors) {
				if (temp.label == node.label)
					return true;
			}

			return false;
		}
	}
}
