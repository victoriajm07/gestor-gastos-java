package com.example.gestor_gastos.persistence.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Integer idUsuario;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="email")
	private String email;
	
	@Column(name="contraseña")
	private String password;
	
    // Relación con Gasto
    @OneToMany(mappedBy = "usuario")
    private List<Gasto> gastos;

    // Relación con MiembroGrupo
    @OneToMany(mappedBy = "usuario")
    private List<MiembroGrupo> miembroGrupos;

    // Relación con DistribucionGasto
    @OneToMany(mappedBy = "usuario")
    private List<DistribucionGasto> distribuciones;
	
	// Getters and setters

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Gasto> getGastos() {
		return gastos;
	}

	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}

	public List<MiembroGrupo> getMiembroGrupos() {
		return miembroGrupos;
	}

	public void setMiembroGrupos(List<MiembroGrupo> miembroGrupos) {
		this.miembroGrupos = miembroGrupos;
	}

	public List<DistribucionGasto> getDistribuciones() {
		return distribuciones;
	}

	public void setDistribuciones(List<DistribucionGasto> distribuciones) {
		this.distribuciones = distribuciones;
	}
	
}
