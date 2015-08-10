package br.com.projetobase.dao.hibernate;

import org.hibernate.Query;

import br.com.projetobase.arq.dao.HibernateDAO;
import br.com.projetobase.arq.dao.excecoes.DAOException;
import br.com.projetobase.dao.SensoresDAO;
import br.com.projetobase.modelo.Sensor;

public class SensorHibernateDAO extends HibernateDAO<Sensor> implements SensoresDAO {

	private static final long serialVersionUID = 1L;

	@Override
	public Sensor buscarPorSensor(String nomeSensor) {
		String hql = "From Sensor sensor Where sensor.nome LIKE :nomeSensor";
		Sensor sensorEncontrado;
		try {
			Query query = getSession().createQuery(hql);
			query.setParameter("nomeSensor", nomeSensor);
			sensorEncontrado = (Sensor) query.uniqueResult();
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return sensorEncontrado;
	}

}
