package com.github.aguilasa.ratonolabirinto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.aguilasa.ratonolabirinto.utils.Utils;

public class ProcessamentoTest {

	@Test
	public void testGetResultado01() throws Exception {
		StringBuilder dados = Utils.carregaArquivo("entradas/01.txt");
		Processamento processamento = new Processamento();
		processamento.processar(dados.toString());
		assertEquals("Saída esperada", 8, processamento.getResultado());
	}

	@Test
	public void testGetResultado02() throws Exception {
		StringBuilder dados = Utils.carregaArquivo("entradas/02.txt");
		Processamento processamento = new Processamento();
		processamento.processar(dados.toString());
		assertEquals("Saída esperada", 6, processamento.getResultado());
	}

}
