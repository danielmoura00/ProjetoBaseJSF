package br.com.projetobase.dao;

import br.com.projetobase.arq.dao.DAO;
import br.com.projetobase.modelo.Sensor;

public interface SensoresDAO extends DAO<Sensor> {
	
	public Sensor  buscarPorSensor(String nomeSensor);

}
