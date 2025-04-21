package com.example.gestor_gastos.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestor_gastos.domain.service.SpendService;
import com.example.gestor_gastos.persistence.entity.Spend;

@RestController
@RequestMapping("/spend")
public class SpendController {

	@Autowired
	private SpendService spendService;
	
	@GetMapping("/all")
	public List<Spend> getAll() {
		return spendService.getAll();
	}
	
	@GetMapping("/{idGastoSpend}")
	public Optional<Spend> getSpend(@PathVariable("idGastoSpend") Integer idGastoSpend) {
		return spendService.getSpend(idGastoSpend);
	}
	
	@GetMapping("/{idUsuarioSpend}")
	public Optional<List<Spend>> getByUser(@PathVariable("idUsuarioSpend") Integer idUsuarioSpend) {
		return spendService.getByUser(idUsuarioSpend);
	}
	
	@PostMapping("/save")
	public Spend save(@RequestBody Spend spend) {
		return spendService.save(spend);
	}
	
	@DeleteMapping("/delete/{idGastoSpend}")
	public boolean delete(@PathVariable("idGastoSpend") Integer idGastoSpend) {
		return spendService.delete(idGastoSpend);
	}
}
