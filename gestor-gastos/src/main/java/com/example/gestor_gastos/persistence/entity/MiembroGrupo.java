package com.example.gestor_gastos.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "miembrogrupo")
public class MiembroGrupo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_miembro")
	private Integer idMiembro;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_grupo")
	private Grupo grupo;

	// Getters and setters
	public Integer getIdMiembro() {
		return idMiembro;
	}

	public void setIdMiembro(Integer idMiembro) {
		this.idMiembro = idMiembro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}
