package com.example.gestor_gastos.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.gestor_gastos.persistence.entity.Gasto;

public interface GastoCrudRepository extends CrudRepository<Gasto, Integer> {

	List<Gasto> findByUsuarioIdUsuarioOrderByCategoria(Integer idUsuario);

	//Optional<List<Gasto>> findByMontoLessThanAndEstado(Integer monto, boolean estado);
}
