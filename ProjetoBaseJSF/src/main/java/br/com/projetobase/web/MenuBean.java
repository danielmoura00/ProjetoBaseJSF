package br.com.projetobase.web;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class MenuBean extends AbstractBean {
	
	private static final long serialVersionUID = 1L;

	private String selecioneOption;
	
	public String getSelecioneOption() {
		return "Selecione";
	}
	public void setSelecioneOption(String selecioneOption) {
		this.selecioneOption = selecioneOption;
	}

	public String irCadsatroEquipamento() {
		return navegacaoPaginas.getCadastroEquipamento().redirect().construir();
	}

	public String irCadastroEquipamento() {
		return navegacaoPaginas.getCadastroEquipamento().construir();
	}
	
	public String irCadastroSensor() {
		return navegacaoPaginas.getCadastroSensor().construir();
	}
	
	public String irCadastroUsuario(){
		return navegacaoPaginas.getCadastro().construir();
	}
	
	public String irLogin(){
		return navegacaoPaginas.getLogin().construir();
	}
	
	public String irHome(){
		return navegacaoPaginas.getHome().construir();
	}
	
	public String irEditarEquipamento(){
		return navegacaoPaginas.getEditarEquipamento().construir();
	}
	
	public String irEditarSensor(){
		return navegacaoPaginas.getEditarSensor().construir();
	}
	

}
