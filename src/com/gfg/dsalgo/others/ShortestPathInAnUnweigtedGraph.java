package com.gfg.dsalgo.others;

import java.util.*;

public class ShortestPathInAnUnweigtedGraph {
	static void addEdge(List<List<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	static void BFS(List<List<Integer>> adj, int V, int s, int[] dist) {
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);

		Queue<Integer> q = new LinkedList<>();
		visited[s] = true;
		q.add(s);

		while (!q.isEmpty()) {
			int u = q.poll();
			for (int v : adj.get(u)) {
				if (!visited[v]) {
					visited[v] = true;
					dist[v] = dist[u] + 1;
					q.add(v);
				}
			}
		}
	}

	public static void main(String[] args) {
		int V = 4;
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}

		addEdge(adj, 0, 1);
		addEdge(adj, 1, 2);
		addEdge(adj, 2, 3);
		addEdge(adj, 0, 2);
		addEdge(adj, 1, 3);
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;

		BFS(adj, V, 0, dist);

		for (int i = 0; i < V; i++) {
			System.out.println(dist[i] + " ");
		}
	}

}