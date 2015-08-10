package br.com.projetobase.web.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.projetobase.arq.dao.hibernate.interceptor.transaction.Transactional;
import br.com.projetobase.dao.UsuarioDAO;
import br.com.projetobase.modelo.Usuario;
import br.com.projetobase.sessao.DadosDaSessao;

public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDAO usuarioDAO;
	
	@Inject
	private DadosDaSessao dadosSessao;

	public UsuarioService() {
	}
	
	@Transactional
	public void salvar(Usuario usuario) {
		if (usuario.getId() != null && usuario.getId() != 0) {
			usuarioDAO.atualizar(usuario);
		} else {
			usuarioDAO.inserir(usuario);

		}
	}

	public String logar(Usuario usuario) {
		String userEmail = usuario.getEmail();
		String userSenha = usuario.getSenha();

		if (userEmail != null) {
			Usuario usuarioEncontrado = usuarioDAO.buscarPorLogin(usuario.getEmail());
			if (usuarioEncontrado != null && userSenha.equals(usuarioEncontrado.getSenha())) {
				System.out.println("SUCESSO");
				dadosSessao.setUsuarioDaSessao(usuarioEncontrado);
				return userEmail;
			} else {
				//TODO login e/ou senha inválidos.
			}
		}
		System.out.println("FALHA");
		return "Usuario ou senha incorretos";

	}
}
