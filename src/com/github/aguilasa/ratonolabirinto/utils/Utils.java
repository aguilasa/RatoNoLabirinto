package com.github.aguilasa.ratonolabirinto.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
	public static StringBuilder carregaArquivo(String arquivo) {
		StringBuilder conteudo = new StringBuilder();
		try {
			FileReader file = new FileReader(arquivo);
			BufferedReader in = new BufferedReader(file);
			try {
				boolean done = false;
				while (!done) {
					String line = in.readLine();
					if (line == null) {
						done = true;
					} else {
						conteudo.append(line.trim() + "\r\n");
					}
				}
			} finally {
				in.close();
			}
		} catch (IOException e1) {
		}
		return conteudo;
	}

}
