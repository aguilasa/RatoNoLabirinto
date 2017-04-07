package com.github.aguilasa.ratonolabirinto.grafos;

/**
 * Classe responsável por representar um grafo
 * 
 * @author Ingmar.Aguiar, Diovani Motta
 * 
 */
public class GrafoLabirinto {
	private ListaVertices vertices = new ListaVertices();

	public ListaVertices getVertices() {
		return vertices;
	}

	public void addLigacao(String nome1, String nome2) {
		Vertice v1 = vertices.add(nome1);
		Vertice v2 = vertices.add(nome2);
		v1.addAdjacente(v2);
		v2.addAdjacente(v1);
	}

}
