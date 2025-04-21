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
@Table(name="distribuciongasto")
public class DistribucionGasto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_distribucion")
    private Integer idDistribucion;

    
	@ManyToOne
    @JoinColumn(name = "id_gasto_grupo")
    private GastoGrupo gastoGrupo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name="monto_a_pagar")
    private Double montoAPagar;
    
    // Getters and setters
    public Integer getIdDistribucion() {
		return idDistribucion;
	}

	public void setIdDistribucion(Integer idDistribucion) {
		this.idDistribucion = idDistribucion;
	}

	public GastoGrupo getGastoGrupo() {
		return gastoGrupo;
	}

	public void setGastoGrupo(GastoGrupo gastoGrupo) {
		this.gastoGrupo = gastoGrupo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double getMontoAPagar() {
		return montoAPagar;
	}

	public void setMontoAPagar(Double montoAPagar) {
		this.montoAPagar = montoAPagar;
	}

}
