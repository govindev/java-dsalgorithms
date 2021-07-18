package com.gfg.dsalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectCycleInAnDirectedGraph {
	static void addEdge(List<List<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
	}

	public static void main(String[] args) {
		int V = 6;
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}

		addEdge(adj, 0, 1);
		addEdge(adj, 2, 1);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
		addEdge(adj, 4, 5);
		addEdge(adj, 5, 3);

		System.out.println(doesLoopExist(adj, V));
	}

	public static boolean doesLoopExist(List<List<Integer>> adj, int V) {
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);
		boolean[] callstack = new boolean[V];
		Arrays.fill(callstack, false);

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (dfs(adj, i, visited, callstack) == true) {
					return true;
				}
			}
		}

		return false;

	}

	public static boolean dfs(List<List<Integer>> adj, Integer s, boolean[] visited, boolean[] callstack) {
		visited[s] = true;
		callstack[s] = true;
		for (int i : adj.get(s)) {
			if (!visited[i]) {
				if (dfs(adj, i, visited, callstack) == true) {
					return true;
				}
			} else if (callstack[i]) {
				return true;
			}
		}
		callstack[s] = false;
		return false;
	}
}
