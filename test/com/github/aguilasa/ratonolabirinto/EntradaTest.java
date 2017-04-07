package com.github.aguilasa.ratonolabirinto;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.github.aguilasa.ratonolabirinto.utils.Utils;

public class EntradaTest {

	@Test
	public void testProcessarDadosEntrada01() {
		StringBuilder dados = Utils.carregaArquivo("entradas/01.txt");
		Entrada entrada = new Entrada(dados.toString());
		entrada.processar();
		List<List<String>> lista = entrada.getEntradaProcessada();
		assertEquals("Número de linhas arquivo 01", 21, lista.size());
	}

	@Test
	public void testProcessarDadosEntrada02() {
		StringBuilder dados = Utils.carregaArquivo("entradas/02.txt");
		Entrada entrada = new Entrada(dados.toString());
		entrada.processar();
		List<List<String>> lista = entrada.getEntradaProcessada();
		assertEquals("Número de linhas arquivo 01", 12, lista.size());
	}

}
