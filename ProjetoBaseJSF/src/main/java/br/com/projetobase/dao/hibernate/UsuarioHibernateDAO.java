package br.com.projetobase.dao.hibernate;

import org.hibernate.Query;

import br.com.projetobase.arq.dao.HibernateDAO;
import br.com.projetobase.arq.dao.excecoes.DAOException;
import br.com.projetobase.dao.UsuarioDAO;
import br.com.projetobase.modelo.Usuario;

public class UsuarioHibernateDAO extends HibernateDAO<Usuario> implements UsuarioDAO {

	private static final long serialVersionUID = 1L;

	@Override
	public Usuario buscarPorLogin(String login) {
		String hql = "From Usuario usuario Where usuario.email = :login";
		Usuario usuarioEncontrado;
		try {
			Query query = getSession().createQuery(hql);
			query.setParameter("login", login);
			usuarioEncontrado = (Usuario) query.uniqueResult();
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return usuarioEncontrado;
	}

}
