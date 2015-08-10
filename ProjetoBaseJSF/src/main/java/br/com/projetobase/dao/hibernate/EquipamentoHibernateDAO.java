package br.com.projetobase.dao.hibernate;

import org.hibernate.Query;

import br.com.projetobase.arq.dao.HibernateDAO;
import br.com.projetobase.arq.dao.excecoes.DAOException;
import br.com.projetobase.dao.EquipamentoDAO;
import br.com.projetobase.modelo.Equipamento;

public class EquipamentoHibernateDAO extends HibernateDAO<Equipamento> implements EquipamentoDAO {

	private static final long serialVersionUID = 1L;
	
	@Override
	public Equipamento buscarPorEquipamento(String nomeEquipamento) {
		String hql = "From Equipamento equipamento Where equipamento.nome LIKE :nomeEquipamento";
		Equipamento equipamentoEncontrado;
		try {
			Query query = getSession().createQuery(hql);
			query.setParameter("nomeEquipamento", nomeEquipamento);
			equipamentoEncontrado = (Equipamento) query.uniqueResult();
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return equipamentoEncontrado;
	}
	

}
