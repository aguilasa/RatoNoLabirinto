package com.github.aguilasa.ratonolabirinto.grafos;

public class Dijkstra {

	private static final int V = 9;

	private static void printf(String format, Object... args) {
		System.out.printf(format, args);
	}

	private static int minDistance(int dist[], boolean sptSet[]) {
		int min = Integer.MAX_VALUE, min_index = 0;

		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}

	private static void printPath(int parent[], int j) {
		// Base Case : If j is source
		if (parent[j] == -1) {
			return;
		}

		printPath(parent, parent[j]);

		printf("%d ", j);
	}

	private static void printSolution(int dist[], int n, int parent[]) {
		int src = 0;
		printf("Vertex\t  Distance\tPath");
		for (int i = 1; i < V; i++) {
			printf("\n%d -> %d \t\t %d\t\t%d ", src, i, dist[i], src);
			printPath(parent, i);
		}
	}

	private static void dijkstra(int graph[][], int src) {
		int dist[] = new int[V];

		boolean sptSet[] = new boolean[V];

		int parent[] = new int[V];

		for (int i = 0; i < V; i++) {
			parent[0] = -1;
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		dist[src] = 0;

		for (int count = 0; count < V - 1; count++) {
			int u = minDistance(dist, sptSet);

			sptSet[u] = true;

			for (int v = 0; v < V; v++) {
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
					parent[v] = u;
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}

		printSolution(dist, V, parent);
	}

	public static void main(String[] args) {
		int[][] graph = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
				{ 0, 0, 0, 14, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		dijkstra(graph, 0);
	}

}
