package com.github.aguilasa.ratonolabirinto.grafos;

public class ArvoreBFS<T> {
	private No<T> raiz;

	public No<T> getRaiz() {
		return raiz;
	}

	public ArvoreBFS(T item) {
		raiz = new No<T>(item, null, null);
	}

	public static class No<T> {
		T item;
		No<T> primeiro;
		No<T> proximo;

		public No(T item, No<T> primeiro, No<T> proximo) {
			this.item = item;
			this.primeiro = primeiro;
			this.proximo = proximo;
		}
	}

}
