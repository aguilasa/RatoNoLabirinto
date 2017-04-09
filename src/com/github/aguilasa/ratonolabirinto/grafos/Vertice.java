package com.github.aguilasa.ratonolabirinto.grafos;

import java.util.LinkedList;

/**
 * Classe responsável por representar um vértice de um grafo
 * 
 * @author Ingmar.Aguiar, Diovani Motta
 * 
 */
public class Vertice {
	private String nome;
	private int indice;
	private LinkedList<Vertice> adjacentes = new LinkedList<>();

	public Vertice() {

	}

	public Vertice(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public void addAdjacente(Vertice v) {
		adjacentes.add(v);
	}

	public LinkedList<Vertice> getAdjacentes() {
		return adjacentes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertice other = (Vertice) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%d: %s", indice, nome);
	}

}
