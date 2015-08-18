package br.com.projetobase.web.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.inject.Inject;

import br.com.projetobase.arq.dao.hibernate.interceptor.transaction.Transactional;
import br.com.projetobase.dao.EquipamentoDAO;
import br.com.projetobase.modelo.Equipamento;
import br.com.projetobase.modelo.Usuario;
import br.com.projetobase.sessao.DadosDaSessao;

public class EquipamentoService implements Serializable {

	private static final long serialVersionUID = 1L;

	private Collection<Equipamento> equipamentos = new ArrayList<Equipamento>();

	@Inject
	DadosDaSessao dados;
	
	@Inject
	private EquipamentoDAO equipamentoDAO;
	
	public EquipamentoService() {
	}

	@Transactional
	public void salvar(Equipamento equipamento){
		Usuario user = dados.getUsuarioDaSessao();
		Collection<Equipamento> equipamentos = user.getEquipamentos();
		equipamentos.add(equipamento);
		if (equipamento.getId() != null && equipamento.getId() != 0) {
			equipamentoDAO.atualizar(equipamento);
		} else {
			equipamentoDAO.inserir(equipamento);

		}
	}
	@Transactional
	public void editar(Equipamento equipamento){
		equipamentoDAO.atualizar(equipamento);
		
	}
	@Transactional
	public void excluir(Equipamento equipamento){
		equipamentoDAO.remover(equipamento);
	}
		
	public ArrayList<String> getNomeEquipamentos() {
		equipamentos = equipamentoDAO.todos();
		ArrayList<String> lista = new ArrayList<String>();
		if (equipamentos != null) {
			Iterator<Equipamento> EquipIterator = equipamentos.iterator();
			while (EquipIterator.hasNext()) {
				Equipamento equipamento = EquipIterator.next();
				String nome = equipamento.getNome();
				lista.add(nome);
			}
		}
		return lista;
	}
	
	public Collection<Equipamento> getEquipamentos(){
		return equipamentoDAO.todos();
	}

}
