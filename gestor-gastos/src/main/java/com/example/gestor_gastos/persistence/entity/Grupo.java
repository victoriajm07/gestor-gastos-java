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
@Table(name="grupo")
public class Grupo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_grupo")
    private Integer idGrupo;

	@Column(name="nombre_grupo")
    private String nombreGrupo;

	@Column(name="descripcion")
    private String descripcion;    

	// Relación con MiembroGrupo
    @OneToMany(mappedBy = "grupo")
    private List<MiembroGrupo> miembroGrupos;

    // Relación con GastoGrupo
    @OneToMany(mappedBy = "grupo")
    private List<GastoGrupo> gastosGrupo;
    
    // Getters and setters
    public Integer getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<MiembroGrupo> getMiembroGrupos() {
		return miembroGrupos;
	}

	public void setMiembroGrupos(List<MiembroGrupo> miembroGrupos) {
		this.miembroGrupos = miembroGrupos;
	}

	public List<GastoGrupo> getGastosGrupo() {
		return gastosGrupo;
	}

	public void setGastosGrupo(List<GastoGrupo> gastosGrupo) {
		this.gastosGrupo = gastosGrupo;
	}
}
