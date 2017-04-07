package com.github.aguilasa.ratonolabirinto.grafos;

import static com.github.aguilasa.ratonolabirinto.grafos.Cor.BRANCO;
import static com.github.aguilasa.ratonolabirinto.grafos.Cor.CINZA;
import static com.github.aguilasa.ratonolabirinto.grafos.Cor.PRETO;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Classe responsável por realizar a BFS (Busca em Largura)
 * 
 * @author Ingmar.Aguiar, Diovani Motta
 * 
 */
public class BFS {
	private static final String ESPACOS = " %-8s";
	private static final String BARRA_ESPACOS = "|" + ESPACOS;
	public Vertice[] pi;
	private Cor[] cor;
	public int[] d;
	private GrafoLabirinto grafo;
	private Vertice inicial;

	public BFS(GrafoLabirinto g, Vertice s) {
		grafo = g;
		inicial = s;
		int tamanho = g.getVertices().size();
		pi = new Vertice[tamanho];
		cor = new Cor[tamanho];
		d = new int[tamanho];
	}

	public void bfs() {
		ListaVertices vertices = grafo.getVertices();
		int i = 0;
		for (Vertice v : vertices) {
			v.setIndice(i);
			cor[i] = BRANCO;
			pi[i] = null;
			d[i] = Integer.MAX_VALUE;
			i++;
		}
		int s = inicial.getIndice();
		d[s] = 0;
		cor[s] = CINZA;

		Queue<Vertice> q = new LinkedList<>();
		q.add(inicial);

		while (!q.isEmpty()) {
			Vertice u = q.poll();
			int indiceU = u.getIndice();
			for (Vertice v : u.getAdjacentes()) {
				int indice = v.getIndice();
				if (cor[indice] == BRANCO) {
					q.add(v);
					cor[indice] = CINZA;
					pi[indice] = u;
					d[indice] = d[indiceU] + 1;
				}
			}
			cor[indiceU] = PRETO;
		}
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		ListaVertices vertices = grafo.getVertices();

		s.append(String.format(ESPACOS, ""));
		for (Vertice v : vertices) {
			s.append(String.format(BARRA_ESPACOS, v.getNome()));
		}
		int tamanho = s.length();
		s.append("\r\n");

		linha(s, tamanho);

		s.append(String.format(ESPACOS, "pi"));
		for (int i = 0; i < pi.length; i++) {
			Vertice v = pi[i];
			String nome = v != null ? v.getNome() : "nil";
			s.append(String.format(BARRA_ESPACOS, nome));
		}
		s.append("\r\n");

		linha(s, tamanho);

		s.append(String.format(ESPACOS, "d"));
		for (int i = 0; i < d.length; i++) {
			int v = d[i];
			String valor = String.valueOf(v).trim();
			s.append(String.format(BARRA_ESPACOS, valor));
		}
		s.append("\r\n");

		linha(s, tamanho);

		return s.toString();
	}

	private void linha(StringBuilder s, int tamanho) {
		for (int i = 0; i < tamanho; i++) {
			s.append("-");
		}
		s.append("\r\n");
	}

}
