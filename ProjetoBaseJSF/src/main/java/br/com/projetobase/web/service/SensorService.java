package br.com.projetobase.web.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.inject.Inject;

import br.com.projetobase.arq.dao.hibernate.interceptor.transaction.Transactional;
import br.com.projetobase.dao.EquipamentoDAO;
import br.com.projetobase.dao.SensoresDAO;
import br.com.projetobase.modelo.Equipamento;
import br.com.projetobase.modelo.Sensor;

public class SensorService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private SensoresDAO sensoresDAO;
	
	@Inject
	private EquipamentoDAO equipamentoDAO;
	
	
	public SensorService() {
	}
	
	@Transactional
	public void salvar(Sensor sensor){
		if (sensor.getId() != null && sensor.getId() != 0) {
			sensoresDAO.atualizar(sensor);
		} else {
			sensoresDAO.inserir(sensor);
		}
	}
	
	@Transactional
	public void editar(Sensor sensor ,String novoNome){
		sensor.setNome(novoNome);
		sensoresDAO.atualizar(sensor);
		
	}
	
	@Transactional
	public void excluir(Sensor sensor){
		
		sensoresDAO.remover(sensor);
	}
	
	public ArrayList<String> getNomeSensores(String nomeEquipamento) {
		ArrayList<String> nomesSensores = new ArrayList<String>();
		
		Equipamento equipamento = equipamentoDAO.buscarPorEquipamento(nomeEquipamento);
		Collection<Sensor> sensores = equipamento.getSensores();
		
		Iterator<Sensor> sensorIterator = sensores.iterator();
		while(sensorIterator.hasNext()){
			Sensor sensorAtual = sensorIterator.next();
			nomesSensores.add(sensorAtual.getNome());
		}
	return nomesSensores;
	}
	
	public Collection<Sensor> getSensores(String nomeEquipamento){
		Equipamento equipamento = equipamentoDAO.buscarPorEquipamento(nomeEquipamento);
		Collection<Sensor> sensores = equipamento.getSensores();
		return sensores;
	}
	

}
