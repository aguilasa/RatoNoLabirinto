package com.github.aguilasa.ratonolabirinto.grafos;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class CaminhoMinimo {

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

	public void imprimirCaminho(int vertice) {
		int anterior = antecessor[vertice];
		if (anterior == -1) {
			return;
		}

		imprimirCaminho(anterior);

		printf("%d ", vertice);
	}

	public void imprimirSolucao() {
		printf("Vertice\t  Distância\tCaminho");
		for (int vertice = 1; vertice < distancia.length; vertice++) {
			printf("\n%d -> %d \t\t %d\t\t%d ", origem, vertice, distancia[vertice], origem);
			imprimirCaminho(vertice);
		}
		System.out.println();
	}

	private void processarCaminho(int vertice, int posicao, int[] caminho) {
		int anterior = antecessor[vertice];
		if (anterior == -1) {
			return;
		}
		caminho[posicao] = anterior;
		processarCaminho(anterior, posicao + 1, caminho);

	}

	private void inverter(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		for (int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
	}

	public int[] retornarCaminho(int vertice) {
		int[] caminho = new int[distancia.length];
		Arrays.setAll(caminho, new IntUnaryOperator() {

			@Override
			public int applyAsInt(int operand) {
				return -1;
			}
		});
		processarCaminho(vertice, 0, caminho);
		int i = 0;
		while (caminho[i] != -1) {
			i++;
		}
		caminho = Arrays.copyOfRange(caminho, 0, i);
		inverter(caminho);

		return caminho;
	}

	public boolean estaNoCaminho(int vertice, int destino) {
		int anterior = antecessor[destino];
		if (anterior == -1) {
			return false;
		}

		return anterior == vertice || estaNoCaminho(vertice, anterior);
	}

	public void processar(int grafo[][], int origem) {
		this.origem = origem;
		int tamanho = grafo.length;
		distancia = new int[tamanho];
		antecessor = new int[tamanho];
		boolean acmSet[] = new boolean[tamanho];

		for (int i = 0; i < tamanho; i++) {
			antecessor[i] = -1;
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

		// imprimirSolucao();
	}

	public static void main(String[] args) {
		int[][] grafo = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
				{ 0, 0, 0, 14, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

		CaminhoMinimo caminho = new CaminhoMinimo();
		caminho.processar(grafo, 0);
	}

}
