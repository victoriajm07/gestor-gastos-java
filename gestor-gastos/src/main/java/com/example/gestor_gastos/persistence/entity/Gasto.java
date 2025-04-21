package com.example.gestor_gastos.persistence.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="gasto")
public class Gasto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_gasto")
	private Integer idGasto;

	@Column(name="monto")
	private Integer monto;
	
	@Column(name="fecha")
	private Date fecha;
	
	@Column(name="categoría")
	private String categoria;
	
	@Column(name="tipo")
	private String tipo;
	
	@ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
	
	// Getters and setters	
	public Integer getIdGasto() {
		return idGasto;
	}

	public void setIdGasto(Integer idGasto) {
		this.idGasto = idGasto;
	}

	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
