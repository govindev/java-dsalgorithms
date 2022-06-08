package com.gfg.dsalgo.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectCycleInAnUndirectedGraph {
	static void addEdge(List<List<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
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
		addEdge(adj, 1, 3);

		System.out.println(doesLoopExist(adj, V));
	}

	public static boolean doesLoopExist(List<List<Integer>> adj, int V) {
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (dfs(adj, i, visited, -1) == true) {
					return true;
				}
			}
		}

		return false;

	}

	public static boolean dfs(List<List<Integer>> adj, Integer s, boolean[] visited, Integer parent) {
		visited[s] = true;
		for (int i : adj.get(s)) {
			if (!visited[i]) {
				if (dfs(adj, i, visited, s) == true) {
					return true;
				}
			} else if (i != parent) {
				return true;
			}
		}
		return false;
	}
}
