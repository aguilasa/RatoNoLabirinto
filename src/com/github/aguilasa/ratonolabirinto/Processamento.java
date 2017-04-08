package com.github.aguilasa.ratonolabirinto;

import java.util.List;

import com.github.aguilasa.ratonolabirinto.grafos.BFS;
import com.github.aguilasa.ratonolabirinto.grafos.GrafoLabirinto;
import com.github.aguilasa.ratonolabirinto.grafos.Vertice;

/**
 * Classe responsável por realizar o processamento dos algoritmos
 * 
 * @author Ingmar.Aguiar, Diovani Motta
 * 
 */
public class Processamento {

	private int resultado = 0;

	public int getResultado() {
		return resultado;
	}

	public Processamento() {

	}

	public void processar(String dadosEntrada) throws Exception {
		Entrada entrada = new Entrada(dadosEntrada);
		entrada.processar();
		List<List<String>> processada = entrada.getEntradaProcessada();
		int vertices = Integer.valueOf(processada.get(0).get(0));
		int ligacoes = Integer.valueOf(processada.get(0).get(1));

		GrafoLabirinto grafo = new GrafoLabirinto();

		for (int i = 1; i < processada.size(); i++) {
			List<String> linha = processada.get(i);
			String origem = linha.get(0);
			String destino = linha.get(1);
			grafo.addLigacao(origem, destino);
		}

		if (grafo.getVertices().size() != vertices) {
			throw new Exception("Número de vértices diferente do definido na entrada.");
		}

		if (processada.size() - 1 != ligacoes) {
			throw new Exception("Número de arestas diferente do definido na entrada.");
		}

		Vertice s = grafo.getVertices().find("Entrada");
		if (s == null) {
			throw new Exception("Não foi encontrada a definição do vértice de entrada.");
		}
		
		grafo.gerarMatrizAdjacencia();
		StringBuilder sb = new StringBuilder();		
		int[][] matriz = grafo.getMatriz();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				sb.append(matriz[i][j]).append(" ");
			}
			sb.append("\r\n");
		}
		
		System.out.println(sb.toString());

		BFS bfs = new BFS(grafo, s);
		bfs.bfs();
		System.out.println(bfs);

	}

}
