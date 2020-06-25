package br.com.gabriel.livraria.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.facelets.FaceletContext;
import javax.validation.ValidationException;

import br.com.gabriel.livraria.dao.DAO;
import br.com.gabriel.livraria.modelo.Autor;
import br.com.gabriel.livraria.modelo.Livro;

@ManagedBean
@RequestScoped
public class LivroBean {

	private Integer autorId;
	private Livro livro = new Livro();

	public List<Autor> getAutores() {
		return new DAO<Autor>(Autor.class).listaTodos();
	}
	
	public List<Autor> getAutoresDoLivro(){
		return this.livro.getAutores();
	}

	public void gravar() {
		System.out.println("gravou o livro: " + this.livro.getTitulo());

		if (livro.getAutores().isEmpty()) {
			//throw new RuntimeException("Livro deve der pelo menos um autor!");
			FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("Livro deve der pelo menos um autor!"));
			return;
		}
		new DAO<Livro>(Livro.class).adiciona(this.livro);
	}
	
	public void gravarAutor() {
		Autor autor = new DAO<Autor>(Autor.class).buscaPorId(this.autorId);
		this.livro.adicionaAutor(autor);
	}
	
	public void comecaComDigitoUm(FaceletContext fc, UIComponent component, Object value)throws ValidationException {
		String valor = value.toString();
		
		if(!valor.startsWith("1")) {
			throw new ValidatorException(new FacesMessage("Deveria começar com 1"));
		}
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
}
