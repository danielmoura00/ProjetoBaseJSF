package br.com.projetobase.sessao;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import br.com.projetobase.modelo.Equipamento;
import br.com.projetobase.modelo.Usuario;

@SessionScoped
public class DadosDaSessao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuarioDaSessao;
	
	Equipamento equipamentoSelecionado;
	
	public Equipamento getEquipamentoSelecionado() {
		return equipamentoSelecionado;
	}

	public void setEquipamentoSelecionado(Equipamento equipamentoSelecionado) {
		this.equipamentoSelecionado = equipamentoSelecionado;
	}

	public DadosDaSessao() {
	}

	public Usuario getUsuarioDaSessao() {
		return usuarioDaSessao;
	}

	public void setUsuarioDaSessao(Usuario usuarioDaSessao) {
		this.usuarioDaSessao = usuarioDaSessao;
	}
	
}
