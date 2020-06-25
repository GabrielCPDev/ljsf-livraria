package br.com.gabriel.livraria.bean;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gabriel.livraria.dao.UsuarioDAO;
import br.com.gabriel.livraria.modelo.Usuario;

@ManagedBean
@ViewScoped
public class LoginBean {

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String efetuaLogin(){
		System.out.println("fazenod login");
		boolean existe = new UsuarioDAO().existe(this.usuario);
		if(existe) {
			System.out.println("login efetuado");
		}
		return "Email ou senha inválido!";
	
	}
}
