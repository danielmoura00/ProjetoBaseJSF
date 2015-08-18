package br.com.projetobase.web;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projetobase.dao.EquipamentoDAO;
import br.com.projetobase.dao.SensoresDAO;
import br.com.projetobase.modelo.Equipamento;
import br.com.projetobase.modelo.Sensor;
import br.com.projetobase.web.service.SensorService;

@Named
@ViewScoped
public class SensorBean extends AbstractBean {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Sensor sensor;

	private String nomeEquipamento;
	private String nomeSensor;
	
	@Inject
	private SensorService sensorService;
	
	@Inject
	EquipamentoDAO equipamentoDAO;
	
	@Inject
	SensoresDAO sensoresDAO;
	
	public SensorBean() {

	}
	
	public String getNomeEquipamento() {
		return nomeEquipamento;
	}

	public void setNomeEquipamento(String nomeEquipamento) {
		
		this.nomeEquipamento = nomeEquipamento;
	}
	
	public String getNomeSensor() {
		return nomeSensor;
	}

	public void setNomeSensor(String nomeSensor) {
		this.nomeSensor = nomeSensor;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	
	public List<String> getNomeSensores() {
		List<String> sensores = Collections.emptyList();
		if(nomeEquipamento != null) {
				sensores = sensorService.getNomeSensores(nomeEquipamento);		
		}
		return sensores; 
		
	}
	
	public Collection<Sensor> getSensores() {
		if(nomeEquipamento!=null){
		return sensorService.getSensores(nomeEquipamento);
		}else{
			return null;
		}
	}

	public String salvarSensor() {
		
		Equipamento equipamento = equipamentoDAO.buscarPorEquipamento(nomeEquipamento);
		sensor.setEquipamento(equipamento);
		sensorService.salvar(sensor);
		return navegacaoPaginas.getCadastroSensor().construir();
	}
	
	public String editarSensor(Sensor sensorRegistrado){
		sensorService.editar(sensorRegistrado,sensor.getNome());
		return navegacaoPaginas.getEditarSensor().construir();
	}
	
	public void excluirSensor(Sensor sensorRecebido){
		sensorService.excluir(sensorRecebido);
	}
	
	
	
}
