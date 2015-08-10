package br.com.projetobase.modelo;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.projetobase.arq.modelo.ModeloPersistencia;

@SuppressWarnings("serial")
@Entity
@Table(name = "usuario")
public class Usuario extends ModeloPersistencia {
	
	

	@Column
	private String nome;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "senha")
	private String senha;

	@Transient
	private String novaSenha;
	
	@Column(nullable=true)
	@OneToMany(mappedBy="usuario", fetch = FetchType.EAGER)
	private Collection<Equipamento> equipamentos;

	public Collection<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(Collection<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}

	public Usuario() {
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

}