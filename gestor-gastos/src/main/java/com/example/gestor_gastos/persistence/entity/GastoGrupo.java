package com.example.gestor_gastos.persistence.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="gastogrupo")
public class GastoGrupo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_gasto_grupo")	
    private Integer idGastoGrupo;

    @ManyToOne
    @JoinColumn(name = "id_grupo")
    private Grupo grupo;

    @Column(name="monto")
    private Double monto;

    @Column(name="fecha")
    private LocalDate fecha;

    @Column(name="categoría")
    private String categoría;

    // Relación con DistribucionGasto
    @OneToMany(mappedBy = "gastoGrupo")
    private List<DistribucionGasto> distribuciones;
    
    
    // Getters and setters
	public Integer getIdGastoGrupo() {
		return idGastoGrupo;
	}

	public void setIdGastoGrupo(Integer idGastoGrupo) {
		this.idGastoGrupo = idGastoGrupo;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getCategoría() {
		return categoría;
	}

	public void setCategoría(String categoría) {
		this.categoría = categoría;
	}

	public List<DistribucionGasto> getDistribuciones() {
		return distribuciones;
	}

	public void setDistribuciones(List<DistribucionGasto> distribuciones) {
		this.distribuciones = distribuciones;
	}
    
}
