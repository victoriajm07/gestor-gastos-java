package com.example.gestor_gastos.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestor_gastos.domain.repository.SpendRepository;
import com.example.gestor_gastos.persistence.entity.Spend;

@Service
public class SpendService {
	
	@Autowired
	private SpendRepository spendRepository;
	
	
	public List<Spend> getAll() {
		return spendRepository.getAll();
	}
	
	
	public Optional<Spend> getSpend(Integer idGastoSpend) {
		return spendRepository.getSpend(idGastoSpend);
	}
	
	
	public Optional<List<Spend>> getByUser(Integer idUsuarioSpend) {
		return spendRepository.getByUser(idUsuarioSpend);
	}
	
	
	public Spend save(Spend spend) {
		return spendRepository.save(spend);
	}
	
	public boolean delete(Integer idGastoSpend) {
		return getSpend(idGastoSpend).map(spend -> {
			spendRepository.delete(idGastoSpend);
			return true;
		}).orElse(false);
	}

}
