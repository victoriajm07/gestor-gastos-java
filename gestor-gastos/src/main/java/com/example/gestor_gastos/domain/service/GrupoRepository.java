package com.example.gestor_gastos.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.gestor_gastos.domain.repository.GroupRepository;
import com.example.gestor_gastos.persistence.crud.GrupoCrudRepository;
import com.example.gestor_gastos.persistence.entity.Group;
import com.example.gestor_gastos.persistence.entity.Grupo;
import com.example.gestor_gastos.persistence.mapper.GroupMapper;

@Repository
public class GrupoRepository implements GroupRepository{
	
	@Autowired
	private GrupoCrudRepository grupoCrudRepository;
	
	@Autowired
	private GroupMapper groupMapper;

	@Override
	public List<Group> getAll() {
		return groupMapper.toGroups((List<Grupo>) grupoCrudRepository.findAll());
	}

	@Override
	public Group save(Group group) {
		Grupo grupo = groupMapper.toGrupo(group);
		return groupMapper.toGroup(grupoCrudRepository.save(grupo));
	}


	@Override
	public Optional<List<Group>> getByNameGroup(String nameGroup) {
		return grupoCrudRepository.findByNombreGrupo(nameGroup).map(grupos -> groupMapper.toGroups(grupos));
	}

}
