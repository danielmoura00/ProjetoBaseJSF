package br.com.projetobase.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.projetobase.arq.modelo.ModeloPersistencia;

@SuppressWarnings("serial")
@Entity
@Table(name = "sensor")
public class Sensor extends ModeloPersistencia{

	@Column(name = "nome", nullable = false)
	private String nome;

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
	@JoinColumn(name="id_equipamento")
	private Equipamento equipamento;
	
	@Transient
	private boolean isEditable=true;

	public boolean isEditable() {
		return isEditable;
	}

	public void setEditable() {
		this.isEditable = !this.isEditable;
	}
	
	public String getNome() {
		if(nome!=null){
		return nome;
		}else{
			return "";
		}
	}

	public void setNome(String nome) {
		this.nome = nome;		
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}


}
