package br.com.projetobase.modelo;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.Transactional;

import br.com.projetobase.arq.modelo.ModeloPersistencia;

@SuppressWarnings("serial")
@Entity
@Table(name = "equipamento")
public class Equipamento extends ModeloPersistencia {

	
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@OneToMany(mappedBy="equipamento", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Collection<Sensor> sensores;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_usuario", nullable = true)
	private Usuario usuario;
	
	@Transient
	private boolean isEditable=true;

	public boolean isEditable() {
		return isEditable;
	}

	public void setEditable() {
		this.isEditable = !this.isEditable;
	}

	public Equipamento() {
		this.nome = "";

	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome!=null)
		this.nome = nome;
	}
	
	public void setSensores(Collection<Sensor> sensores) {
		this.sensores = sensores;
	}

	public Collection<Sensor> getSensores() {
		return sensores;
	}

	public void popSensor(int tagSensor){
		sensores.remove(tagSensor);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
