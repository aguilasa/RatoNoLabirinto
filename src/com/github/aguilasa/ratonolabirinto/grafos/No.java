package com.github.aguilasa.ratonolabirinto.grafos;

public class No {
	public Vertice vertice;
	public Vertice esquerda;
	public Vertice direita;

	public No(Vertice vertice) {
		this.vertice = vertice;
		this.esquerda = null;
		this.direita = null;
	}
}
