package com.example.gestor_gastos.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.gestor_gastos.persistence.entity.Spend;

/**
 * Interfaz que aplicará el Data Mapper
 */
public interface SpendRepository {

	List<Spend> getAll();
	
	Optional<List<Spend>> getByUser(Integer idUsuarioSpend);
	
	//Optional<List<Spend>> getScarseSpend(Integer montoSpend);
	
	Optional<Spend> getSpend(Integer idGastoSpend);
	
	Spend save(Spend spend);
	
	void delete(Integer idGastoSpend);
 }
