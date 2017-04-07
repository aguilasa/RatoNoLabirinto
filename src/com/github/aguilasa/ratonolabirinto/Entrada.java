package com.github.aguilasa.ratonolabirinto;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Classe responsável por processar a String de entrada e transformar numa lista
 * 
 * @author Ingmar.Aguiar, Diovani Motta
 * 
 *
 */
public class Entrada {

	private String dadosEntrada;
	private List<List<String>> entradaProcessada = new LinkedList<>();

	public Entrada(String dadosEntrada) {
		this.dadosEntrada = dadosEntrada;
	}

	public String getDadosEntrada() {
		return dadosEntrada;
	}

	public void setDadosEntrada(String dadosEntrada) {
		this.dadosEntrada = dadosEntrada;
	}

	public List<List<String>> getEntradaProcessada() {
		return entradaProcessada;
	}

	public void processar() {
		String[] linhas = dadosEntrada.split("\r?\n");
		for (String linha : linhas) {
			String[] valores = linha.split(" ");
			if (valores.length > 0 && valores.length <= 2) {
				List<String> lista = new LinkedList<>();
				lista.add(valores[0].trim());
				lista.add(valores[1].trim());
				entradaProcessada.add(lista);
			}
		}
	}

}
