package com.example.gestor_gastos.persistence.entity;

import java.time.LocalDate;


public class SpendGroup {

	private Integer idSpendGroup;

    private Grupo group;

    private Double amount;

    private LocalDate date;

    private String category;
    
    

	public Integer getIdSpendGroup() {
		return idSpendGroup;
	}

	public void setIdSpendGroup(Integer idSpendGroup) {
		this.idSpendGroup = idSpendGroup;
	}

	public Grupo getGroup() {
		return group;
	}

	public void setGroup(Grupo group) {
		this.group = group;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
    
    
    
}
