package com.gfg.dsalgo.others;

import java.util.*;

public class TopologicalSortUsingDFS {
// Directed Graph

	private static void addEdge(List<List<Integer>> adj, int v1, int v2) {
		adj.get(v1).add(v2);
	}

	public static void main(String[] args) {
		// Construct the Graph
		int V = 5;

		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		addEdge(adj, 0, 1);
		addEdge(adj, 1, 3);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
		addEdge(adj, 2, 4);
		
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				dfs(adj, V, i, visited, stack);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + ", ");
		}
	}

	private static void dfs(List<List<Integer>> adj, int V, int s, boolean[] visited, Stack<Integer> stack) {
		visited[s] = true;
		for (int v : adj.get(s)) {
			if (!visited[v]) {
				dfs(adj, V, v, visited, stack);
			}
		}
		stack.push(s);
	}
}
