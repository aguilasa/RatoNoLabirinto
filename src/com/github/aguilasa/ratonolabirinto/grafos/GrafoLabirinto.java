package com.github.aguilasa.ratonolabirinto.grafos;

/**
 * Classe responsável por representar um grafo
 * 
 * @author Ingmar.Aguiar, Diovani Motta
 * 
 */
public class GrafoLabirinto {
	private ListaVertices vertices = new ListaVertices();
	private int[][] matriz;

	public ListaVertices getVertices() {
		return vertices;
	}

	public int[][] getMatriz() {
		return matriz;
	}

	public void addLigacao(String nome1, String nome2) {
		Vertice v1 = vertices.add(nome1);
		Vertice v2 = vertices.add(nome2);
		v1.addAdjacente(v2);
		v2.addAdjacente(v1);
	}

	public void gerarMatrizAdjacencia() {
		int tamanho = vertices.size();
		matriz = new int[tamanho][tamanho];
		for (Vertice v : vertices) {
			for (Vertice a : v.getAdjacentes()) {
				matriz[v.getIndice()][a.getIndice()] = 1;
			}
		}
	}

}
