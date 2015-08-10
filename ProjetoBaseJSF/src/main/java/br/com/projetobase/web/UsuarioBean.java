package br.com.projetobase.web;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projetobase.modelo.Usuario;
import br.com.projetobase.web.NavegacaoPaginasController.Pagina;
import br.com.projetobase.web.service.UsuarioService;

@Named
@ViewScoped
public class UsuarioBean extends AbstractBean {

	private static final String FALHA_DE_AUTENTICACAO = "Usuario ou senha incorretos";

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuario usuario;

	@Inject
	private UsuarioService usuarioService;

	public UsuarioBean() {

	}
	//Metodos referentes ao usuario
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String salvar() {
		usuarioService.salvar(usuario);
		return navegacaoPaginas.getCadastro().construir();
	}

	public String logarUsuario() {
		String UserName = usuarioService.logar(usuario);
		Boolean LogState = UserName.contains(FALHA_DE_AUTENTICACAO);
		Pagina link;
		if (!LogState) {
			link = navegacaoPaginas.getHome();
		} else {
			link = navegacaoPaginas.getFalhaDeLogin();
		}
		return link.construir();
	}

}
