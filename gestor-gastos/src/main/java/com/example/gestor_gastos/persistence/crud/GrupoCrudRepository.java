package com.example.gestor_gastos.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.gestor_gastos.persistence.entity.Grupo;

public interface GrupoCrudRepository extends CrudRepository<Grupo, Integer>{
	
	Optional<List<Grupo>> findByNombreGrupo(String nombreGrupo);

}
