package com.github.aguilasa.ratonolabirinto.grafos;

import java.util.LinkedList;

public class ListaVertices extends LinkedList<Vertice> {

	private static final long serialVersionUID = -8964309612462871898L;

	public Vertice add(String nome) {
		Vertice vertice = new Vertice(nome);
		int index = indexOf(vertice);
		if (index > -1) {
			return get(index);
		}
		add(vertice);
		return vertice;
	}

	public Vertice find(String nome) {
		Vertice vertice = new Vertice(nome);
		int index = indexOf(vertice);
		if (index > -1) {
			return get(index);
		}
		return null;
	}

}
