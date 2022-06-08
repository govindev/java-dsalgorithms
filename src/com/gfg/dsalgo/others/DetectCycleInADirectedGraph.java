package com.gfg.dsalgo.others;

import java.util.*;

public class DetectCycleInADirectedGraph {
// Directed Graph

	private static void addEdge(List<List<Integer>> adj, int v1, int v2, int[] indegree) {
		adj.get(v1).add(v2);
		indegree[v2]++;
	}

	public static void main(String[] args) {
		// Construct the Graph
		// int V = 5;
		// int V = 6;
		int V = 5;

		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		// Figure out the zero in degree vertices
		int[] indegree = new int[V];
		Arrays.fill(indegree, 0);

//		addEdge(adj, 0, 2);
//		addEdge(adj, 0, 3);
//		addEdge(adj, 1, 3);
//		addEdge(adj, 1, 4);

//		addEdge(adj, 0, 1);
//		addEdge(adj, 0, 2);
//		addEdge(adj, 1, 3);
//		addEdge(adj, 2, 3);
//		addEdge(adj, 3, 4);
//		addEdge(adj, 3, 5);

		addEdge(adj, 0, 2, indegree);
		addEdge(adj, 0, 3, indegree);
		addEdge(adj, 2, 3, indegree);
		addEdge(adj, 1, 3, indegree);
		addEdge(adj, 1, 4, indegree);

		doesLoopExist(adj, V, indegree);
	}

	private static void doesLoopExist(List<List<Integer>> adj, int V, int[] indegree) {
		// Using topological sorting -khan's algorithm
		boolean[] visited = new boolean[V];
		int[] sort = new int[V];
		Arrays.fill(visited, false);

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		int s = 0;
		int count = 0;
		while (!q.isEmpty()) {
			int c = q.poll();
			if (!visited[c]) {
				visited[c] = true;
				sort[s++] = c;
			}
			for (int v : adj.get(c)) {
				indegree[v]--;
				if (!visited[v] && indegree[v] == 0)
					q.offer(v);
			}
			count++;
		}
		if (count != V)
			System.out.println("cycle exists in the loop");

		System.out.println("cycle does not exist in the loop");
	}
}
