package com.github.aguilasa.ratonolabirinto.grafos;

import static com.github.aguilasa.ratonolabirinto.grafos.Cor.BRANCO;
import static com.github.aguilasa.ratonolabirinto.grafos.Cor.CINZA;
import static com.github.aguilasa.ratonolabirinto.grafos.Cor.PRETO;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Classe responsável por realizar a BFS (Busca em Largura)
 * 
 * @author Ingmar.Aguiar, Diovani Motta
 * 
 */
public class BFS {
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
		List<Vertice> vertices = grafo.getVertices();
		int i = 0;
		for (Vertice v : vertices) {
			v.setIndice(i);
			cor[i] = BRANCO;
			pi[i] = null;
			d[i] = Integer.MAX_VALUE;
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

}
