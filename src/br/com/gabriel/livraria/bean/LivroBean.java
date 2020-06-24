package br.com.gabriel.livraria.bean;

import java.time.LocalDateTime;

import javax.annotation.ManagedBean;

public class LivroBean {

	private Livro livro = new Livro();

	@ManagedBean()
	public void gravar() {
		System.out.println("gravou o livro: "+ this.livro.getTitulo());
	}
}
