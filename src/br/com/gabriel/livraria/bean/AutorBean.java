package br.com.gabriel.livraria.bean;

import br.com.gabriel.livraria.dao.DAO;
import br.com.gabriel.livraria.modelo.Autor;

public class AutorBean {
	private Autor autor = new Autor();

	public Autor getAutor() {
		return autor;
	}

	public void gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		new DAO<Autor>(Autor.class).adiciona(this.autor);
	
		this.autor = new Autor();
	}
}
