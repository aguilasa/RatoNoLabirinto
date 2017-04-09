package com.github.aguilasa.ratonolabirinto;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntUnaryOperator;

import com.github.aguilasa.ratonolabirinto.grafos.CaminhoMinimo;
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
		GrafoLabirinto grafo = gerarGrafo(entrada);

		Vertice verticeEntrada = grafo.getVertices().find("Entrada");
		Vertice s = verticeEntrada;
		if (s == null) {
			throw new Exception("Não foi encontrada a definição do vértice de entrada.");
		}

		grafo.gerarMatrizAdjacencia();
		int[][] matriz = grafo.getMatriz();

		for (Vertice v : grafo.getVertices()) {
			System.out.println(v);
		}
		System.out.println();

		Vertice saida = grafo.getVertices().find("Saida");
		Vertice queijo = grafo.getVertices().find("*");

		CaminhoMinimo caminho = new CaminhoMinimo();
		caminho.processar(matriz, verticeEntrada.getIndice());
		caminho.imprimirSolucao();

		// se o queijo está no caminho entre a entrada e a saída
		if (caminho.estaNoCaminho(queijo.getIndice(), saida.getIndice())) {
			resultado = caminho.distancia[saida.getIndice()];
		} else {
			int distancia_saida = caminho.distancia[saida.getIndice()];
			int distancia_queijo = caminho.distancia[queijo.getIndice()];

			int comum = -1;
			int[] caminhoSaida = caminho.retornarCaminho(saida.getIndice());
			int[] caminhoQueijo = caminho.retornarCaminho(queijo.getIndice());

			int menor = Math.min(caminhoSaida.length, caminhoQueijo.length);
			for (int i = 1; i < menor; i++) {
				if (caminhoQueijo[i] == caminhoSaida[i]) {
					comum = caminhoSaida[i];
				} else {
					break;
				}
			}

			// se não existe caminho comum, primeiro vai ao queijo, volta a
			// entrada e depois sai
			if (comum == -1) {
				resultado = (distancia_saida - 1) + (distancia_queijo * 2);
			} else {
				int distancia_comum = caminho.distancia[comum];
				resultado = distancia_saida + (distancia_queijo * 2) - (distancia_comum * 2) - 1;
			}
		}
	}

	private GrafoLabirinto gerarGrafo(Entrada entrada) throws Exception {
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
		return grafo;
	}

}
