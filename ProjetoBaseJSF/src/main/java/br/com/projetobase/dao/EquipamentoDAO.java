package br.com.projetobase.dao;

import br.com.projetobase.arq.dao.DAO;
import br.com.projetobase.modelo.Equipamento;

public interface EquipamentoDAO extends DAO<Equipamento> {
	public Equipamento  buscarPorEquipamento(String nomeEquipamento);
}
