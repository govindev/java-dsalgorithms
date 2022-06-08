package com.gfg.dsalgo.others;

import java.util.*;

// Construct the Adj List Node
class AdjListNode {
	private int v;
	private int weight;

	AdjListNode(int v, int weight) {
		this.v = v;
		this.weight = weight;
	}

	int getV() {
		return v;
	}

	int getWeight() {
		return weight;
	}
}

// Construct the Graph
class Graph {
	private int V;
	private LinkedList<AdjListNode> adj[];

	Graph(int v) {
		this.V = v;
		adj = new LinkedList[V];
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList<AdjListNode>();
		}
	}

	void addEdge(int u, int v, int weight) {
		AdjListNode node = new AdjListNode(v, weight);
		adj[u].add(node);
	}

	void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
		visited[v] = true;
		for (AdjListNode a : adj[v]) {
			if (!visited[a.getV()]) {
				topologicalSortUtil(a.getV(), visited, stack);
			}
		}
		stack.push(v);
	}

	void shortestPath(int s) {
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);
		Stack<Integer> statck = new Stack<>();
		for (int i = 0; i < V; i++) {
			if (!visited[i])
				topologicalSortUtil(i, visited, statck);
		}

		// create the distances array
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;

		while (!statck.isEmpty()) {
			int v = statck.pop();
			for (AdjListNode u : adj[v]) {
				dist[u.getV()] = Math.min(dist[v] + u.getWeight(), dist[u.getV()]);
			}
		}

		for (int d : dist) {
			if (d == Integer.MAX_VALUE) {
				System.out.print("INF, ");
			} else {
				System.out.print(d + ", ");
			}

		}

	}
}

public class ShortedPathInDAG {

	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(0, 1, 2);
		g.addEdge(0, 4, 1);
		g.addEdge(1, 2, 3);
		g.addEdge(4, 2, 2);
		g.addEdge(4, 5, 4);
		g.addEdge(2, 3, 6);
		g.addEdge(5, 3, 1);

		int s = 0;
		System.out.println("Following are shortest distances " + "from source " + s);
		g.shortestPath(s);

	}

}