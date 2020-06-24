package br.com.gabriel.livraria.bean;

import br.com.gabriel.livraria.modelo.Livro;

public class LivroBean {

	private Livro livro = new Livro();


	public void gravar() {
		System.out.println("gravou o livro: "+ this.livro.getTitulo());
	}
}
