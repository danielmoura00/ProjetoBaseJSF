package br.com.projetobase.web;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projetobase.dao.EquipamentoDAO;
import br.com.projetobase.modelo.Equipamento;
import br.com.projetobase.sessao.DadosDaSessao;
import br.com.projetobase.web.service.EquipamentoService;

@Named
@ViewScoped
public class EquipamentoBean extends AbstractBean {

	private static final long serialVersionUID = 1L;

	private Equipamento equipamento;

	private String equipamentoSelecionado;

	@Inject
	private EquipamentoService equipamentoService;
	
	@Inject
	private DadosDaSessao dadosDaSessao;
	@Inject
	private EquipamentoDAO equipamentoDAO;

	public EquipamentoBean() {
		equipamento = new Equipamento();
	}

	public Collection<Equipamento> getEquipamentos() {
		return equipamentoDAO.todos();
	}

	public Equipamento getEquipamento() {
		return equipamento;
		
	}

	public void setEquipamento(Equipamento equipamento) {
		if(equipamento!=null){
		this.equipamento = equipamento;}
	}

	public void setEquipamentoSelecionado(String equipamentoSelecionado) {
		this.equipamentoSelecionado = equipamentoSelecionado;
	}

	public String getEquipamentoSelecionado() {
		return equipamentoSelecionado;
	}

	public ArrayList<String> getNomeEquipamentos() {
		ArrayList<String> equipamentosCadastrados = new ArrayList<String>();
		
			if (dadosDaSessao.getUsuarioDaSessao() != null) {
				
				equipamentosCadastrados = equipamentoService.getNomeEquipamentos();
			}
		return equipamentosCadastrados;
	}

	public String salvarEquipamento() {
		equipamento.setUsuario(dadosDaSessao.getUsuarioDaSessao());
		equipamentoService.salvar(equipamento);
		
		return navegacaoPaginas.getCadastroEquipamento().construir();
	}
	
	
	public String miau() {
		return navegacaoPaginas.getCadastro().construir();
	}
	
	
	
	public void editarEquipamento(Equipamento equip) {
		equipamentoService.editar(equip);
	}
	
	
	public void excluirEquipamento(Equipamento equip){
		equipamentoService.excluir(equip);
	}

}
