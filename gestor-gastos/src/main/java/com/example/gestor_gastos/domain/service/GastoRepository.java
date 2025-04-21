package com.example.gestor_gastos.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.gestor_gastos.domain.repository.SpendRepository;
import com.example.gestor_gastos.persistence.crud.GastoCrudRepository;
import com.example.gestor_gastos.persistence.entity.Gasto;
import com.example.gestor_gastos.persistence.entity.Spend;
import com.example.gestor_gastos.persistence.mapper.SpendMapper;

@Repository
public class GastoRepository implements SpendRepository{
	
	@Autowired
	private GastoCrudRepository gastoRepository;
	
	@Autowired
	private SpendMapper spendMapper;

	
	@Override
	public List<Spend> getAll() {
		 List<Gasto> gastos = (List<Gasto>) gastoRepository.findAll();
		 return spendMapper.toSpends(gastos);
	}
	
	@Override
	public void delete(Integer idGastoSpend) {
		gastoRepository.deleteById(idGastoSpend);
	}

	@Override
	public Optional<List<Spend>> getByUser(Integer idUsuarioSpend) {
		List<Gasto> gastos = gastoRepository.findByUsuarioIdUsuarioOrderByCategoria(idUsuarioSpend);
		return Optional.of(spendMapper.toSpends(gastos));
	}

	/**@Override
	public Optional<List<Spend>> getScarseSpend(Integer montoSpend) {
		Optional<List<Gasto>> gastos = gastoRepository.findByMontoLessThanAndEstado(montoSpend, true);
		return gastos.map(gast -> spendMapper.toSpends(gast));
	}*/

	@Override
	public Optional<Spend> getSpend(Integer idGastoSpend) {		
		return gastoRepository.findById(idGastoSpend).map(producto -> spendMapper.toSpend(producto));
	}

	@Override
	public Spend save(Spend spend) {
		Gasto gasto = spendMapper.toGasto(spend);
		return spendMapper.toSpend(gastoRepository.save(gasto));
	}

}
