package com.github.aguilasa.ratonolabirinto;

import com.github.aguilasa.ratonolabirinto.utils.Utils;

/**
 * Classe principal
 * 
 * @author Ingmar.Aguiar, Diovani Motta
 * 
 */

public class RatoNoLabirinto {

	public static void main(String[] args) {
		StringBuilder dados = Utils.carregaArquivo("entradas/01.txt");
		Processamento processamento = new Processamento();
		try {
			processamento.processar(dados.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
