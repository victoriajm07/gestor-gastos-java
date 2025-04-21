package com.example.gestor_gastos.persistence.entity;


/**
 * Clase que aplicará el Data Mapper
 */
public class User {
	
	private Integer idUsuarioSpend;
	
	private String nombreSpend;
	
	private String emailSpend;
	
	private String passwordSpend;

	public Integer getIdUsuarioSpend() {
		return idUsuarioSpend;
	}

	public void setIdUsuarioSpend(Integer idUsuarioSpend) {
		this.idUsuarioSpend = idUsuarioSpend;
	}

	public String getNombreSpend() {
		return nombreSpend;
	}

	public void setNombreSpend(String nombreSpend) {
		this.nombreSpend = nombreSpend;
	}

	public String getEmailSpend() {
		return emailSpend;
	}

	public void setEmailSpend(String emailSpend) {
		this.emailSpend = emailSpend;
	}

	public String getPasswordSpend() {
		return passwordSpend;
	}

	public void setPasswordSpend(String passwordSpend) {
		this.passwordSpend = passwordSpend;
	}


	
	

}
