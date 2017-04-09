package com.github.aguilasa.ratonolabirinto.grafos;

public class Dijkstra {

	public int origem;
	public int[] distancia;
	public int[] antecessor;

	private void printf(String format, Object... args) {
		System.out.printf(format, args);
	}

	private int distanciaMinima(boolean acmSet[]) {
		int minimo = Integer.MAX_VALUE, indice_minimo = 0;

		for (int v = 0; v < distancia.length; v++)
			if (acmSet[v] == false && distancia[v] <= minimo) {
				minimo = distancia[v];
				indice_minimo = v;
			}

		return indice_minimo;
	}

	public void imprimirCaminho(int j) {
		if (antecessor[j] == -1) {
			return;
		}

		imprimirCaminho(antecessor[j]);

		printf("%d ", j);
	}

	public void imprimirSolucao() {
		printf("Vertice\t  Distância\tCaminho");
		for (int i = 1; i < distancia.length; i++) {
			printf("\n%d -> %d \t\t %d\t\t%d ", origem, i, distancia[i], origem);
			imprimirCaminho(i);
		}
		System.out.println();
	}

	public void dijkstra(int grafo[][], int origem) {
		this.origem = origem;
		int tamanho = grafo.length;
		distancia = new int[tamanho];
		antecessor = new int[tamanho];
		boolean acmSet[] = new boolean[tamanho];

		for (int i = 0; i < tamanho; i++) {
			antecessor[0] = -1;
			distancia[i] = Integer.MAX_VALUE;
			acmSet[i] = false;
		}

		distancia[origem] = 0;

		for (int count = 0; count < tamanho - 1; count++) {
			int u = distanciaMinima(acmSet);

			acmSet[u] = true;

			for (int v = 0; v < tamanho; v++) {
				int distanciaPara = distancia[u] + grafo[u][v];
				if (!acmSet[v] && grafo[u][v] != 0 && distanciaPara < distancia[v]) {
					antecessor[v] = u;
					distancia[v] = distanciaPara;
				}
			}
		}

		imprimirSolucao();
	}

	public static void main(String[] args) {
		int[][] graph = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
				{ 0, 0, 0, 14, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

		Dijkstra dijkstra = new Dijkstra();
		dijkstra.dijkstra(graph, 0);
	}

}
